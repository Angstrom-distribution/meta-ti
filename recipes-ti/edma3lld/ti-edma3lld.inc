DESCRIPTION = "TI EDMA3 Low Level Driver (LLD)"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/${SRC_URI_edma3lldsite}/edma3_lld"
SECTION = "devel"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://packages/ti/sdo/edma3/drv/edma3_drv.h;md5=c1aa300aaf369a0a03e7922c1b0bbf8e"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

TI_BIN_UNPK_WDEXT="/edma3_lld_${PV}"
S = "${WORKDIR}${TI_BIN_UNPK_WDEXT}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/${SRC_URI_edma3lldsite}/edma3_lld/edma3-lld-bios5/${PV}/exports/EDMA3_LLD_setuplinux_${PV}.bin;name=edma3lldbin"

BINFILE="EDMA3_LLD_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS="Y:workdir"

do_install() {
    install -d ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${EDMA3_LLD_INSTALL_DIR_RECIPE}
}

