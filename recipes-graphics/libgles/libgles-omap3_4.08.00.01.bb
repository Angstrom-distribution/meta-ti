require libgles-omap3.inc

LICENSE = "TSPA"

DEFAULT_PREFERENCE = "-1"

BINLOCATION_omap3  = "${S}/gfx_rel_es3.x"
BINLOCATION_ti816x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti814x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti33x = "${S}/gfx_rel_es8.x"

PLATFORM = "LinuxARMV7"
PVR_INIT = "pvrsrvctl"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "4_08_00_01"
IMGPV = "1.9.2139099"
BINFILE = "Graphics_SDK_setuplinux_${SGXPV}.bin"
TI_BIN_UNPK_WDEXT := "/Graphics_SDK_${SGXPV}"
SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
           file://cputype \
           file://rc.pvr \
           file://rc_dri.pvr \
           file://sample.desktop \
           file://99-bufferclass.rules  \
"

SRC_URI[md5sum] = "dd0d994a48ecc4293f272a1fddddf159"
SRC_URI[sha256sum] = "fd721288c95314e0d676dd89462e1dec994e185cb608bcb8ac4a4b5809f9693a"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

LIBGLESWINDOWSYSTEM ?= "${@base_contains('DISTRO_FEATURES', 'x11',"libpvrPVR2D_DRIWSEGL.so" ,"libpvrPVR2D_FRONTWSEGL.so.1", d)}"

do_configure_append() {

    # Change PVR server's user mode library to point to DRI
    for drifile in $(find ${S} -name "libsrv_um_dri.so"); do
    if [ "$drifile" != "" ]
    then
        dir=$(dirname ${drifile})
        if [ "$SUPPORT_XORG" = "1" ]
        then
            mv ${dir}/libsrv_um_dri.so ${dir}/libsrv_um.so
        else
            rm -rf ${dir}/libsrv_um_dri.so
        fi
    fi

    done
}

do_install_append() {

    # In this version of the graphics SDK the following directories do not exist:
    #    /GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/pvr2d.h (doesn't exist)
    #    /GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/GLES/egltypes.h (doesn't exist)
    # Therefore, need to copy these files manually at the only location that they do exist
    cp -pPr ${S}/include/pvr2d/*.h ${D}${includedir}
    cp -pPr ${S}/include/OGLES/GLES ${D}${includedir}/

    rm ${D}${sysconfdir}/init.d/pvr-init

    if [ "$SUPPORT_XORG" = "1" ]; then
        cp -pP ${WORKDIR}/rc_dri.pvr ${D}${sysconfdir}/init.d/pvr-init
    else
        cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init
    fi

}

RRECOMMENDS_${PN}-x11demos = "${PN}-driwsegl"
RRECOMMENDS_${PN}-x11trainingcourses = "${PN}-driwsegl"
