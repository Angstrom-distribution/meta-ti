DESCRIPTION = "TI ARM Code Generation Tools"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/CodeGenerationTools.htm"
SECTION = "devel"
LICENSE = "TI"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=62f46f1125a152a2e213b414db7ac600"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

S = "${WORKDIR}/cgt470_${PV}"

SRC_URI = "http://install.source.dir.local/ti_cgt_tms470_${PVwithdots}_setup_linux_x86.bin;name=cgt470bin"

BINFILE="ti_cgt_tms470_${PVwithdots}_setup_linux_x86.bin"
TI_BIN_UNPK_CMDS="Y:qY:workdir: : "
TI_BIN_UNPK_WDEXT="/cgt470_${PV}"

do_install() {
    install -d ${D}${CODEGEN_ARM_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEGEN_ARM_INSTALL_DIR_RECIPE}
}

