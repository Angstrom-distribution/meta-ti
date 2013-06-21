DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs (for X11)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5743acf520dd81ca172e69f818a3d4"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../../recipes-ti/includes/ti-eula-unpack.inc

SGXPV = "4_09_00_01"
IMGPV = "1.9.2188537"
BINFILE = "Graphics_SDK_setuplinux_${SGXPV}_minimal_demos.bin"

inherit module

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE}"

SRC_URI[md5sum] = "bd35e9d8843aff3a2aca9d41e7db1c7d"
SRC_URI[sha256sum] = "eb37f75ddde4640b09e760fa86e689beb394330ecdf68786188c34f249247647"

TI_BIN_UNPK_WDEXT="/Graphics_SDK_${SGXPV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}/GFX_Linux_KM"

PVRBUILD = "release"
export KERNELDIR = "${STAGING_KERNEL_DIR}"

INHIBIT_PACKAGE_STRIP = "1"

TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti814x = "ti81xx"
TI_PLATFORM_ti816x = "ti81xx"
TI_PLATFORM_ti33x = "ti335x"

MODULESLOCATION_omap3 = "dc_omapfb3_linux"
MODULESLOCATION_ti814x = "dc_ti81xx_linux"
MODULESLOCATION_ti816x = "dc_ti81xx_linux"
MODULESLOCATION_ti33x = "dc_ti335x_linux"

export SUPPORT_XORG ?= "1"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM} SUPPORT_XORG=${SUPPORT_XORG}"

do_compile() {
	export TOOLCHAIN="${TOOLCHAIN_PATH}"
	export PLAT_CC="${CC}"
	export PLAT_CPP="${CXX}"
	export PLAR_AR="${AR}"
	for kernelver in ${WORKDIR}/../../linux-ti-staging/* ; do
		cp -f $kernelver/git/drivers/gpu/drm/*.c ${S}/services4/3rdparty/linux_drm/
	done
	if [ $(echo -e "${KERNEL_VERSION}\n3.3" | sort --version-sort | head -1) = "3.3" ] ; then
		cp -f ${S}/services4/3rdparty/linux_drm/Kbuild_3.3 \
			${S}/services4/3rdparty/linux_drm/Kbuild
	else 
		if [ $(echo -e "${KERNEL_VERSION}\n3.2" | sort --version-sort | head -1) = "3.2" ] ; then
			cp -f ${S}/services4/3rdparty/linux_drm/Kbuild_3.2 \
				${S}/services4/3rdparty/linux_drm/Kbuild
		fi
	fi
	oe_runmake BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM} SUPPORT_XORG=${SUPPORT_XORG}
}

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    cp  ${S}/pvrsrvkm.ko \
         ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
        ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr

    cp ${S}/services4/3rdparty/linux_drm/drm.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
