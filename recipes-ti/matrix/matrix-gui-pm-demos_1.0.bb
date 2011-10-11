DESCRIPTION = "Power management demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/610/5035/pmdemos_1.0.tar.gz"

S = ${WORKDIR}/pmdemos

require matrix-gui-apps.inc

# Make sure power submenu has been installed
RDEPENDS +=  matrix-gui-submenus-power

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "81ee5495fe155bad88a4ba3510bb18b9"
SRC_URI[sha256sum] = "14c36da61466b384fd196769cf4a4344a9e62440fe3389f94d27575f29c319b3"
