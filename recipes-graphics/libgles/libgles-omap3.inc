DESCRIPTION = "libGLES for the omap3"
LICENSE = "proprietary-binary"
# 'TSPA.txt' might not be the best file to md5sum
LIC_FILES_CHKSUM = "file://TSPA.txt;md5=c0d5d9c1e38b41677144c4e24d6ddee1"

PR = "r35"

COMPATIBLE_MACHINE = "(omap3|ti814x|ti816x|ti33x)"

X11DEPENDS = "virtual/libx11 libxau libxdmcp libdrm"
DEPENDS = "${@base_contains('DISTRO_FEATURES', 'x11', '${X11DEPENDS}', '', d)}"

export SUPPORT_XORG ?= "${@base_contains('DISTRO_FEATURES', 'x11', '1', '0', d)}"
PVR_INIT ?= "pvrsrvinit"

PROVIDES += "virtual/egl virtual/libgles1 virtual/libgles2"

RREPLACES_${PN} = "libegl libgles1 libgles2"
RREPLACES_${PN}-dev = "libegl-dev libgles1-dev libgles2-dev"
RREPLACES_${PN}-dbg = "libegl-dbg"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
		   file://cputype \
		   file://rc.pvr \
		   file://sample.desktop \
		   file://99-bufferclass.rules  \
"

S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}"

# Logic to unpack installjammer file
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../../recipes-ti/includes/ti-eula-unpack.inc

export BINLOCATION ?= "${S}/gfx_rel"
export ES2LOCATION ?= "${S}/gfx_rel_es2.x"
export ES3LOCATION ?= "${S}/gfx_rel_es3.x"
export ES5LOCATION ?= "${S}/gfx_rel_es5.x"
export ES6LOCATION ?= "${S}/gfx_rel_es6.x"
export ES8LOCATION ?= "${S}/gfx_rel_es8.x"

LIBGLESWINDOWSYSTEM ?= "libpvrPVR2D_FRONTWSEGL.so.1"

do_configure() {
	# Attempt to fix up the worst offenders for file permissions
	for i in $(find ${S} -name "*.h") $(find ${S} -name "*.c") $(find ${S} -name "Make*") ; do
		chmod 0644 $i
	done

	# Attempt to create proper library softlinks
	for sofile in $(find ${S} -name "lib*Open*.so") $(find ${S} -name "lib*srv*.so") $(find ${S} -name "lib*gl*.so") $(find ${S} -name "libpvr*.so") $(find ${S} -name "lib*GL*.so"); do
		if [ "$(readlink -n ${sofile})" = "" ] ; then
			mv $sofile ${sofile}.${IMGPV}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1}')
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1 "." $2}')
		fi
	done

	# Due to recursive make PLAT_* isn't always passed down correctly, so use sed to fix those
	for mak in $(find ${S} -name "*.mak") ; do
		sed -i -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g $mak
	done

	# clear out old stuff
	find Binaries/ | xargs rm -f || true
}

# Force in GNU_HASH and paths to libs
TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION} \
-L${STAGING_DIR_TARGET}${libdir} -Wl,-rpath-link,${STAGING_DIR_TARGET}${libdir}"
PARALLEL_MAKE = ""

PLATFORM ?= "LinuxOMAP3"

do_compile() {
	export TOOLCHAIN="${TOOLCHAIN_PATH}"
	export PLAT_CC="${CC}"
	export PLAT_CPP="${CXX}"
	export PLAR_AR="${AR}"

	if [ ${SUPPORT_XORG} -eq 1 ] ; then
		export X11ROOT="${STAGING_DIR_HOST}/usr"
		mkdir -p ${S}/demos/x11
		mkdir -p ${S}/trainingcourses/x11
	fi

	mkdir -p ${S}/demos/raw
	mkdir -p ${S}/trainingcourses/raw

	# Rebuild demos
	for X11BUILD in 0 1 ; do
		# Don't rebuild demos with X11 support for a non X11 distro
		if [ ${SUPPORT_XORG} -eq 0 -a $X11BUILD -eq 1 ] ; then
			continue
		fi

		for demo in ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Demos/* ; do
			cd $demo/OGLES/Build/LinuxGeneric
			oe_runmake Common=1 PLATFORM=${PLATFORM} X11BUILD=$X11BUILD
			rm $demo/OGLES/Build/${PLATFORM}/Release*/*.o

			if [ $X11BUILD -eq 1 ] ; then
				install -m 0755 $demo/OGLES/Build/${PLATFORM}/ReleaseX11/* ${S}/demos/x11 || true
				sed -e s:NAME:$(basename $demo): \
				    -e s:EXEC:${bindir}/SGX/demos/X11/$(basename $demo/OGLES/Build/${PLATFORM}/ReleaseX11/*): \
				    ${WORKDIR}/sample.desktop > ${WORKDIR}/$(basename $demo).desktop
			else
				install -m 0755 $demo/OGLES/Build/${PLATFORM}/ReleaseRaw/* ${S}/demos/raw || true
			fi
		done

		for demo in ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Demos/* ; do
			cd $demo/OGLES2/Build/LinuxGeneric
			oe_runmake Common=1 PLATFORM=${PLATFORM} X11BUILD=$X11BUILD
			rm -f $demo/OGLES2/Build/${PLATFORM}/Release*/*.o

			if [ $X11BUILD -eq 1 ] ; then
				install -m 0755 $demo/OGLES2/Build/${PLATFORM}/ReleaseX11/* ${S}/demos/x11 || true
				sed -e s:NAME:$(basename $demo): \
				    -e s:EXEC:${bindir}/SGX/demos/X11/$(basename $demo/OGLES2/Build/${PLATFORM}/ReleaseX11/*): \
				    ${WORKDIR}/sample.desktop > ${WORKDIR}/$(basename $demo).desktop
			else
				install -m 0755 $demo/OGLES2/Build/${PLATFORM}/ReleaseRaw/* ${S}/demos/raw || true
			fi
		done
	done

	find ${S} -name "*_org" -delete

	# Build OGLES2 Trainingcourses
	for X11BUILD in 0 1 ; do
		# Don't rebuild training courses with X11 support for a non X11 distro
		if [ ${SUPPORT_XORG} -eq 0 -a $X11BUILD -eq 1 ] ; then
			continue
		fi

		for training in ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/TrainingCourse/* ; do
			if [ -e $training/OGLES2/Build/LinuxGeneric/Makefile ] ; then
				cd $training/OGLES2/Build/LinuxGeneric
			fi

			if [ -e $training/OGLES2/Build/${PLATFORM}/Makefile ] ; then
				cd $training/OGLES2/Build/${PLATFORM}
			fi

			oe_runmake Common=1 PLATFORM=${PLATFORM} X11BUILD=$X11BUILD
			rm -f $training/OGLES2/Build/${PLATFORM}/Release*/*.o

			if [ $X11BUILD -eq 1 ] ; then
				install -m 0755 $training/OGLES2/Build/${PLATFORM}/ReleaseX11/* ${S}/trainingcourses/x11 || true
			else
				install -m 0755 $training/OGLES2/Build/${PLATFORM}/ReleaseRaw/* ${S}/trainingcourses/raw || true
			fi
		done
	done

}

do_install () {
	install -d ${D}${libdir}
	cp -pPR ${BINLOCATION}/*.so* ${D}${libdir}
	install -m 0644 ${BINLOCATION}/*.a ${D}${libdir}

	install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/cputype ${D}${bindir}/

	install -m 0755 ${BINLOCATION}/*_test ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/gl* ${D}${bindir}/
	install -m 0755 ${BINLOCATION}/${PVR_INIT} ${D}${bindir}/

	if [ ${SUPPORT_XORG} -eq 1 ] ; then
		install -m 0755 ${BINLOCATION}/xgles1test1 ${D}${bindir}/
		install -m 0755 ${BINLOCATION}/freedesktop/kdrive/usr/X11R6_SGX/bin/Xsgx ${D}${bindir}/|| true
		cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/${PLATFORM}/lib/*X11WS* ${D}${libdir} || true
	fi

	install -d ${D}${includedir}
	cp -pPR ${S}/GFX_Linux_KM/include4 ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_KM/services4 ${D}${includedir}/

	cp -pPR ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/Include/* ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/* ${D}${includedir}/
	cp -pPR ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/${PLATFORM}/Include/GLES/* ${D}${includedir}/GLES/ 2>/dev/null || true
	cp -pPr ${S}/GFX_Linux_SDK/OGLES2/SDKPackage/Builds/OGLES2/${PLATFORM}/Include/GLES/* ${D}${includedir}/GLES2/ 2>/dev/null || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/v* ${D}${includedir}/ 2>/dev/null || true
	cp -pPr ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/V* ${D}${includedir}/ 2>/dev/null || true
	cp -pPr ${S}/include/*.h ${D}${includedir} || true
	cp -pPr ${S}/include/wsegl/*.h ${D}${includedir} || true
	
	install -d ${D}${sysconfdir}/init.d/
	cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init

	install -d ${D}${sysconfdir}
	echo "[default]" > ${D}${sysconfdir}/powervr.ini
	echo "WindowSystem=${LIBGLESWINDOWSYSTEM}" >> ${D}${sysconfdir}/powervr.ini

	# The ES2.x, ES3.x, ES5.x and ES6.x CPUs have different SGX hardware, so we need to install multiple sets of userspace

	install -d ${D}${libdir}/ES8.0
	install -d ${D}${libdir}/ES6.0
	install -d ${D}${libdir}/ES5.0
	install -d ${D}${libdir}/ES3.0
	install -d ${D}${libdir}/ES2.0

	install -d ${D}${bindir}/ES8.0
	install -d ${D}${bindir}/ES6.0
	install -d ${D}${bindir}/ES5.0
	install -d ${D}${bindir}/ES3.0
	install -d ${D}${bindir}/ES2.0

	shared_prog="eglinfo pvr2d_test ${PVR_INIT} services_test sgx_blit_test sgx_clipblit_test sgx_flip_test sgx_init_test sgx_render_flip_test"
	raw_prog="gles1test1 gles2test1 ovg_unit_test"
	x11_prog="eglinfo_x xgles1test1 xgles2test1 xmultiegltest xovg_unit_test"

	for esrev in 2 3 5 6 8 ; do
		ESLOCATION=$(eval echo $(echo \$\{ES${esrev}LOCATION\}))
		if [ -e ${ESLOCATION} ] ; then
			cp -pPR ${ESLOCATION}/lib*${IMGPV} ${ESLOCATION}/pvr_drv.so ${ESLOCATION}/*.a ${D}${libdir}/ES${esrev}.0/
			for esprog in $shared_prog $raw_prog ${@base_contains('DISTRO_FEATURES', 'x11',"$x11_prog","",d)} ; do
				install -m 0755 ${ESLOCATION}/$esprog ${D}${bindir}/ES${esrev}.0/ 2>/dev/null || true
			done
		fi
	done

	rm ${D}${bindir}/ES*/*.h ${D}${bindir}/ES*/pdsasm ${D}${bindir}/pdsasm -f || true

	install -d ${D}${prefix}/share/applications
	cp ${WORKDIR}/*.desktop ${D}${prefix}/share/applications
	rm ${D}${prefix}/share/applications/sample.desktop

	if [ ${SUPPORT_XORG} -eq 1 ] ; then
		install -d ${D}${bindir}/SGX/demos/X11/
		install -m 0755 ${S}/demos/x11/* ${D}${bindir}/SGX/demos/X11/
		install -d ${D}${bindir}/SGX/trainingcourses/X11  2>/dev/null || true
		install -m 0755 ${S}/trainingcourses/x11/* ${D}${bindir}/SGX/trainingcourses/X11/ 2>/dev/null || true
	fi

	install -d ${D}${bindir}/SGX/demos/Raw/
	install -m 0755 ${S}/demos/raw/* ${D}${bindir}/SGX/demos/Raw/
	install -d ${D}${bindir}/SGX/trainingcourses/Raw 2>/dev/null || true
	install -m 0755 ${S}/trainingcourses/raw/* ${D}${bindir}/SGX/trainingcourses/Raw/ 2>/dev/null || true


	# Delete objects and linker scripts hidden between the headers
	find ${D} -name "*.o" -delete
	find ${D} -name "*.o.cmd" -delete

	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/99-bufferclass.rules ${D}${sysconfdir}/udev/rules.d/

}

PACKAGES =+ "${@base_contains('DISTRO_FEATURES', 'x11',"${PN}-x11demos ${PN}-x11trainingcourses xserver-kdrive-powervrsgx" ,"", d)}  \
             ${PN}-rawdemos ${PN}-rawtrainingcourses ${PN}-tests"
# Package the base libraries per silicon revision
PACKAGES =+ "${PN}-es2 ${PN}-es3 ${PN}-es5 ${PN}-es6 ${PN}-es8"
RRECOMMENDS_${PN} += "${PN}-es2 ${PN}-es3 ${PN}-es5 ${PN}-es6 ${PN}-es8"
FILES_${PN}-es2 = "${libdir}/ES2*/* ${bindir}/ES2*/*"
FILES_${PN}-es3 = "${libdir}/ES3*/* ${bindir}/ES3*/*"
FILES_${PN}-es5 = "${libdir}/ES5*/* ${bindir}/ES5*/*"
FILES_${PN}-es6 = "${libdir}/ES6*/* ${bindir}/ES6*/*"
FILES_${PN}-es8 = "${libdir}/ES8*/* ${bindir}/ES8*/*"

# Stop shlib code from picking a subpackage
PRIVATE_LIBS_${PN}-es2 = "libGLESv2.so libIMGegl.so libsrv_um.so libOpenVG.so libpvr2d.so libsrv_init.so libEGL.so libsrv_um_dri.so libOpenVGU.so libglslcompiler.so libGLES_CM.so"
PRIVATE_LIBS_${PN}-es3 = "libGLESv2.so libIMGegl.so libsrv_um.so libOpenVG.so libpvr2d.so libsrv_init.so libEGL.so libsrv_um_dri.so libOpenVGU.so libglslcompiler.so libGLES_CM.so"
PRIVATE_LIBS_${PN}-es5 = "libGLESv2.so libIMGegl.so libsrv_um.so libOpenVG.so libpvr2d.so libsrv_init.so libEGL.so libsrv_um_dri.so libOpenVGU.so libglslcompiler.so libGLES_CM.so"
PRIVATE_LIBS_${PN}-es6 = "libGLESv2.so libIMGegl.so libsrv_um.so libOpenVG.so libpvr2d.so libsrv_init.so libEGL.so libsrv_um_dri.so libOpenVGU.so libglslcompiler.so libGLES_CM.so"
PRIVATE_LIBS_${PN}-es8 = "libGLESv2.so libIMGegl.so libsrv_um.so libOpenVG.so libpvr2d.so libsrv_init.so libEGL.so libsrv_um_dri.so libOpenVGU.so libglslcompiler.so libGLES_CM.so"


PACKAGES =+ "${PN}-blitwsegl ${PN}-flipwsegl ${PN}-frontwsegl ${PN}-linuxfbwsegl"
PACKAGES =+ "${@base_contains('DISTRO_FEATURES', 'x11',"${PN}-x11wsegl ${PN}-driwsegl" ,"", d)}"
FILES_${PN}-blitwsegl = "${libdir}/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-flipwsegl = "${libdir}/libpvrPVR2D_FLIPWSEGL.so.*"
FILES_${PN}-frontwsegl = "${libdir}/libpvrPVR2D_FRONTWSEGL.so.*"
FILES_${PN}-linuxfbwsegl = "${libdir}/libpvrPVR2D_LINUXFBWSEGL.so.*"
FILES_${PN}-x11wsegl = "${libdir}/libpvrPVR2D_X11WSEGL.so* ${bindir}/x* ${bindir}/*x"
FILES_${PN}-driwsegl = "${libdir}/libpvrPVR2D_DRIWSEGL.so* ${libdir}/libsrv_um_dri*"

PACKAGES =+ "${PN}-blitwsegl-es2 ${PN}-blitwsegl-es3 ${PN}-blitwsegl-es5 ${PN}-blitwsegl-es6 ${PN}-blitwsegl-es8 ${PN}-flipwsegl-es2 ${PN}-flipwsegl-es3 ${PN}-flipwsegl-es5 ${PN}-flipwsegl-es6 ${PN}-flipwsegl-es8 ${PN}-frontwsegl-es2 ${PN}-frontwsegl-es3 ${PN}-frontwsegl-es5 ${PN}-frontwsegl-es6 ${PN}-frontwsegl-es8 ${PN}-linuxfbwsegl-es2 ${PN}-linuxfbwsegl-es3 ${PN}-linuxfbwsegl-es5 ${PN}-linuxfbwsegl-es6 ${PN}-linuxfbwsegl-es8"

X11_SEGL = " ${PN}-x11wsegl-es2 ${PN}-x11wsegl-es3 ${PN}-x11wsegl-es5 ${PN}-x11wsegl-es6 ${PN}-x11wsegl-es8 ${PN}-driwsegl-es2 ${PN}-driwsegl-es3 ${PN}-driwsegl-es5 ${PN}-driwsegl-es6 ${PN}-driwsegl-es8 "
PACKAGES =+ "${@base_contains('DISTRO_FEATURES', 'x11',"${X11_SEGL}" ,"", d)}"
FILES_${PN}-blitwsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-blitwsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-blitwsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-blitwsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_BLITWSEGL.so.*"
FILES_${PN}-blitwsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_BLITWSEGL.so.*"
RRECOMMENDS_${PN}-blitwsegl = " ${PN}-blitwsegl-es2 ${PN}-blitwsegl-es3 ${PN}-blitwsegl-es5 ${PN}-blitwsegl-es6 ${PN}-blitwsegl-es8"

FILES_${PN}-flipwsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_FLIPWSEGL.so.*"
FILES_${PN}-flipwsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_FLIPWSEGL.so.*"
FILES_${PN}-flipwsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_FLIPWSEGL.so.*"
FILES_${PN}-flipwsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_FLIPWSEGL.so.*"
FILES_${PN}-flipwsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_FLIPWSEGL.so.*"
RRECOMMENDS_${PN}-flipwsegl = " ${PN}-flipwsegl-es2 ${PN}-flipwsegl-es3 ${PN}-flipwsegl-es5 ${PN}-flipwsegl-es6 ${PN}-flipwsegl-es8"

FILES_${PN}-frontwsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_FRONTWSEGL.so.*"
FILES_${PN}-frontwsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_FRONTWSEGL.so.*"
FILES_${PN}-frontwsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_FRONTWSEGL.so.*"
FILES_${PN}-frontwsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_FRONTWSEGL.so.*"
FILES_${PN}-frontwsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_FRONTWSEGL.so.*"
RRECOMMENDS_${PN}-frontwsegl = " ${PN}-frontwsegl-es2 ${PN}-frontwsegl-es3 ${PN}-frontwsegl-es5 ${PN}-frontwsegl-es6 ${PN}-frontwsegl-es8"

FILES_${PN}-linuxfbwsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_LINUXFBWSEGL.so.*"
FILES_${PN}-linuxfbwsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_LINUXFBWSEGL.so.*"
FILES_${PN}-linuxfbwsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_LINUXFBWSEGL.so.*"
FILES_${PN}-linuxfbwsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_LINUXFBWSEGL.so.*"
FILES_${PN}-linuxfbwsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_LINUXFBWSEGL.so.*"
RRECOMMENDS_${PN}-linuxfbwsegl = " ${PN}-linuxfbwsegl-es2 ${PN}-linuxfbwsegl-es3 ${PN}-linuxfbwsegl-es5 ${PN}-linuxfbwsegl-es6 ${PN}-linuxfbwsegl-es8"

FILES_${PN}-x11wsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_X11WSEGL.so.* ${bindir}/ES2*/x* ${bindir}/ES2*/*x"
FILES_${PN}-x11wsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_X11WSEGL.so.* ${bindir}/ES3*/x* ${bindir}/ES3*/*x"
FILES_${PN}-x11wsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_X11WSEGL.so.* ${bindir}/ES5*/x* ${bindir}/ES5*/*x"
FILES_${PN}-x11wsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_X11WSEGL.so.* ${bindir}/ES6*/x* ${bindir}/ES6*/*x"
FILES_${PN}-x11wsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_X11WSEGL.so.* ${bindir}/ES8*/x* ${bindir}/ES8*/*x"
RRECOMMENDS_${PN}-x11wsegl = " ${PN}-x11wsegl-es2 ${PN}-x11wsegl-es3 ${PN}-x11wsegl-es5 ${PN}-x11wsegl-es6 ${PN}-x11wsegl-es8"

FILES_${PN}-driwsegl-es2 = "${libdir}/ES2*/libpvrPVR2D_DRIWSEGL.so.* ${libdir}/ES2*/libsrv_um_dri*"
FILES_${PN}-driwsegl-es3 = "${libdir}/ES3*/libpvrPVR2D_DRIWSEGL.so.* ${libdir}/ES3*/libsrv_um_dri*"
FILES_${PN}-driwsegl-es5 = "${libdir}/ES5*/libpvrPVR2D_DRIWSEGL.so.* ${libdir}/ES5*/libsrv_um_dri*"
FILES_${PN}-driwsegl-es6 = "${libdir}/ES6*/libpvrPVR2D_DRIWSEGL.so.* ${libdir}/ES6*/libsrv_um_dri*"
FILES_${PN}-driwsegl-es8 = "${libdir}/ES8*/libpvrPVR2D_DRIWSEGL.so.* ${libdir}/ES8*/libsrv_um_dri*"
RRECOMMENDS_${PN}-driwsegl = " ${PN}-driwsegl-es2 ${PN}-driwsegl-es3 ${PN}-driwsegl-es5 ${PN}-driwsegl-es6 ${PN}-driwsegl-es8"

CONFFILES_${PN} = "${sysconfdir}/powervr.ini"

FILES_${PN} = "${sysconfdir} ${libdir}/*.so* ${bindir}/${PVR_INIT} ${bindir}/cputype ${bindir}/*"

FILES_xserver-kdrive-powervrsgx = "${bindir}/Xsgx"
FILES_${PN}-tests = "${bindir}/*test*"
FILES_${PN}-dbg = "${libdir}/.debug/* ${bindir}/.debug/* \
                   ${libdir}/ES*/.debug ${bindir}/*/.debug\
                   ${bindir}/SGX/demos/*/.debug/* \
                   ${bindir}/SGX/trainingcourses/*/.debug/* \
	"

FILES_${PN}-rawdemos = "${bindir}/SGX/demos/Raw/*"
FILES_${PN}-x11demos = "${bindir}/SGX/demos/X11/* ${prefix}/share/applications "
RRECOMMENDS_${PN}-x11demos = "${PN}-x11wsegl"

FILES_${PN}-rawtrainingcourses = "${bindir}/SGX/trainingcourses/Raw/*"
FILES_${PN}-x11trainingcourses = "${bindir}/SGX/trainingcourses/X11/*"
RRECOMMENDS_${PN}-x11trainingcourses = "${PN}-x11wsegl"

# The libs need the kernel-modules
RRECOMMENDS_${PN} += "omap3-sgx-modules"

# The initscript calls fbset, cputype calls devmem2
RDEPENDS_${PN} += "fbset devmem2"

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so"
INSANE_SKIP_${PN}-es3 = "ldflags dev-so staticdev"
INSANE_SKIP_${PN}-es5 = "ldflags dev-so staticdev"
INSANE_SKIP_${PN}-es6 = "ldflags dev-so staticdev"
INSANE_SKIP_${PN}-es8 = "ldflags dev-so staticdev"
INSANE_SKIP_${PN}-rawdemos = "ldflags dev-so useless-rpaths"
INSANE_SKIP_${PN}-x11demos = "ldflags dev-so useless-rpaths"
INSANE_SKIP_${PN}-blitwsegl = "ldflags"
INSANE_SKIP_${PN}-blitwsegl-es3 = "ldflags"
INSANE_SKIP_${PN}-blitwsegl-es5 = "ldflags"
INSANE_SKIP_${PN}-blitwsegl-es6 = "ldflags"
INSANE_SKIP_${PN}-blitwsegl-es8 = "ldflags"
INSANE_SKIP_${PN}-flipwsegl = "ldflags"
INSANE_SKIP_${PN}-flipwsegl-es3 = "ldflags"
INSANE_SKIP_${PN}-flipwsegl-es5 = "ldflags"
INSANE_SKIP_${PN}-flipwsegl-es6 = "ldflags"
INSANE_SKIP_${PN}-flipwsegl-es8 = "ldflags"
INSANE_SKIP_${PN}-frontwsegl = "ldflags"
INSANE_SKIP_${PN}-frontwsegl-es3 = "ldflags"
INSANE_SKIP_${PN}-frontwsegl-es5 = "ldflags"
INSANE_SKIP_${PN}-frontwsegl-es6 = "ldflags"
INSANE_SKIP_${PN}-frontwsegl-es8 = "ldflags"
INSANE_SKIP_${PN}-linuxfbwsegl = "ldflags"
INSANE_SKIP_${PN}-linuxfbwsegl-es3 = "ldflags"
INSANE_SKIP_${PN}-linuxfbwsegl-es5 = "ldflags"
INSANE_SKIP_${PN}-linuxfbwsegl-es6 = "ldflags"
INSANE_SKIP_${PN}-linuxfbwsegl-es8 = "ldflags"
INSANE_SKIP_${PN}-x11wsegl = "ldflags dev-so"
INSANE_SKIP_${PN}-x11wsegl-es3 = "ldflags dev-so"
INSANE_SKIP_${PN}-x11wsegl-es5 = "ldflags dev-so"
INSANE_SKIP_${PN}-x11wsegl-es6 = "ldflags dev-so"
INSANE_SKIP_${PN}-x11wsegl-es8 = "ldflags dev-so"
INSANE_SKIP_${PN}-driwsegl = "ldflags dev-so"
INSANE_SKIP_${PN}-driwsegl-es3 = "ldflags dev-so"
INSANE_SKIP_${PN}-driwsegl-es5 = "ldflags dev-so"
INSANE_SKIP_${PN}-driwsegl-es6 = "ldflags dev-so"
INSANE_SKIP_${PN}-driwsegl-es8 = "ldflags dev-so"
INSANE_SKIP_${PN}-tests = "ldflags"
INSANE_SKIP_xserver-kdrive-powervrsgx = "ldflags"

# Quality control is really poor on these SDKs, so hack around the latest madness:
FILES_${PN} += "${libdir}/*.so "
FILES_${PN}-dev = "${includedir}"

inherit update-rc.d

INITSCRIPT_NAME = "pvr-init"
INITSCRIPT_PARAMS = "start 30 5 2 . stop 40 0 1 6 ."

# Append to update-rc.d postinst
pkg_postinst_${PN}_append() {
rm -f $D${sysconfdir}/powervr-esrev

if [ ${SUPPORT_XORG} -eq 1 ] ; then
	ln -sf /usr/lib/libXdmcp.so.6.0.0 /usr/lib/libXdmcp.so.0
	ln -sf /usr/lib/libXau.so.6.0.0 /usr/lib/libXau.so.0
fi

}

pkg_postinst_${PN}-blitwsegl() {
rm -f $D${sysconfdir}/powervr-esrev
}

pkg_postinst_${PN}-flipwsegl() {
rm -f $D${sysconfdir}/powervr-esrev
}

pkg_postinst_${PN}-frontwsegl() {
rm -f $D${sysconfdir}/powervr-esrev
}
pkg_postinst_${PN}-linuxfbwsegl() {
rm -f $D${sysconfdir}/powervr-esrev
}

pkg_postinst_${PN}-x11wsegl() {
rm -f $D${sysconfdir}/powervr-esrev

echo "[default]" > $D${sysconfdir}/powervr.ini
echo "WindowSystem=libpvrPVR2D_X11WSEGL.so.1" >> $D${sysconfdir}/powervr.ini
}

pkg_postinst_${PN}-driwsegl() {
rm -f $D${sysconfdir}/powervr-esrev
}

