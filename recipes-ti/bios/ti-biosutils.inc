DESCRIPTION = "TI DSP/BIOS Utilities"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/Bios_Utils"
SECTION = "devel"
LICENSE = "TI"
LIC_FILES_CHKSUM = "file://packages/ti/bios/utils/Load.c;md5=e666d585907c3456e82b7e10f7a09a73"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc

S = "${WORKDIR}/biosutils_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/Bios_Utils/${PV}${PVsuffix}/exports/biosutils_${PV}.tar.gz;name=biosutilstarball"

do_install() {
    install -d ${D}${BIOSUTILS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOSUTILS_INSTALL_DIR_RECIPE}
}

