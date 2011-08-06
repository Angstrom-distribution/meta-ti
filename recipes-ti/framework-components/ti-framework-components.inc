DESCRIPTION = "TI Framework Components"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc"
SECTION = "devel"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://framework_components_2_26_00_01_manifest.html;md5=3250f9da7ee72284c07f8dd840400c75"

require recipes-ti/includes/ti-paths.inc
require recipes-ti/includes/ti-staging.inc

PR = "r1"

S = "${WORKDIR}/framework_components_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc/${PV}/exports/framework_components_${PV},lite.tar.gz;name=fctarball"

do_install() {
    install -d ${D}${FC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${FC_INSTALL_DIR_RECIPE}
}

