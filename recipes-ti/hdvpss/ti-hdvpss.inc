DESCRIPTION = "TI HDVPSS"
SECTION = "devel"
LICENSE = "TI"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc

S = "${WORKDIR}/REL.HDVPSS_${PV}"

SRC_URI = "http://install.source.dir.local/REL.HDVPSS.${PV}.zip"

do_compile() {
    :
}

do_install() {
    install -d ${D}${HDVPSS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${HDVPSS_INSTALL_DIR_RECIPE}
}

