DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL-COPYING;md5=60422928ba677faaa13d6ab5f5baaa1e"

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../../recipes-ti/includes/ti-eula-unpack.inc

SGXPV = "5_00_00_01"
IMGPV = "1.10.2359475"

inherit module

MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

BINFILE_HARDFP = "Graphics_SDK_setuplinux_${SGXPV}_alpha_hardfp_minimal_demos.bin"
MD5SUM_HARDFP = "ae6125d7f8a313ea5c02afded893052d"
SHA256SUM_HARDFP = "c2782a2f85024741722b936ec9dca66b858ae8561aa71b693f11e12d8c0385e0"

# For now we only have hardfp version
python __anonymous() {
    tunes = bb.data.getVar("TUNE_FEATURES", d, 1)
    if not tunes:
        return
    pkgn = bb.data.getVar("PN", d, 1)
    pkgv = bb.data.getVar("PV", d, 1)
    if "callconvention-hard" not in tunes:
        bb.warn("%s-%s ONLY supports hardfp mode for now" % (pkgn, pkgv))
        raise bb.parse.SkipPackage("%s-%s ONLY supports hardfp mode for now" % (pkgn, pkgv))
}

BINFILE := "${BINFILE_HARDFP}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/gfxsdk/${SGXPV}/exports/${BINFILE}"

SRC_URI[md5sum] := "${MD5SUM_HARDFP}"
SRC_URI[sha256sum] := "${SHA256SUM_HARDFP}"

TI_BIN_UNPK_WDEXT="/Graphics_SDK_${SGXPV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}/GFX_Linux_KM"

PVRBUILD = "release"
export KERNELDIR = "${STAGING_KERNEL_DIR}"

INHIBIT_PACKAGE_STRIP = "1"

TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti814x = "ti81xx"
TI_PLATFORM_ti816x = "ti81xx"
TI_PLATFORM_ti33x = "ti335x"
TI_PLATFORM_ti43x = "ti43xx"

MODULESLOCATION_omap3 = "dc_omapfb3_linux"
MODULESLOCATION_ti814x = "dc_ti81xx_linux"
MODULESLOCATION_ti816x = "dc_ti81xx_linux"
MODULESLOCATION_ti33x = "dc_ti335x_linux"
MODULESLOCATION_ti43x = "dc_ti43xx_linux"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM} SUPPORT_XORG=${SUPPORT_XORG}"

do_install() {
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    cp  ${S}/pvrsrvkm.ko \
        ${S}/services4/3rdparty/${MODULESLOCATION}/omaplfb.ko  \
        ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
        ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
