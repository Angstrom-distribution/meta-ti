DESCRIPTION = "TI DSP/BIOS v5 Kernel"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios"
SECTION = "devel"
LICENSE = "TI"

LIC_FILES_CHKSUM = "file://docs/license/TSPA_License_Agreement_DSP_BIOS_bios_5_41_07_24.html;md5=86096a08e4088ef291c98313d82b8742"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

PR = "r1"

S = "${WORKDIR}/bios_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${PV}/exports/bios_setuplinux_${PV}.bin;name=biosbin"

BINFILE="bios_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

do_install() {
    install -d ${D}${BIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOS_INSTALL_DIR_RECIPE}
}

