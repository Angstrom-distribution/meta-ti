DESCRIPTION = "Display control descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/611/5034/displaycontrol_1.0.tar.gz"

S = ${WORKDIR}/displaycontrol

require matrix-gui-apps.inc

# Make sure display submenu has been installed
RDEPENDS +=  matrix-gui-submenus-display

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "65b45c9a55395c6a574ca720fc47c628"
SRC_URI[sha256sum] = "e8b8dee2ddf66f96b0420988e7cd3220306168887f78043e5aa4497388e77798"
