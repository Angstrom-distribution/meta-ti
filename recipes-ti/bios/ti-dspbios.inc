DESCRIPTION = "TI DSP/BIOS v5 Kernel"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios"
SECTION = "devel"
LICENSE = "TI"

# We can't depend on license files to be present, so just use the TI logo
LIC_FILES_CHKSUM = "file://docs/tilogo.gif;md5=f049a774c576a5cef3fca4932d707b39"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

TI_BIN_UNPK_WDEXT="/bios_${PV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${PV}/exports/bios_setuplinux_${PV}.bin;name=biosbin"

BINFILE="bios_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"

do_install() {
    install -d ${D}${BIOS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOS_INSTALL_DIR_RECIPE}
}

