DESCRIPTION = "Qt4 demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/608/5036/qt4demos_1.0.tar.gz"

S = ${WORKDIR}/qt4demos

require matrix-gui-apps.inc

# Make sure qt4 submenu has been installed
RDEPENDS +=  matrix-gui-submenus-qt4

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "49b65c4af67117ba70e0ddabfe486abe"
SRC_URI[sha256sum] = "8367c539caf6902961db4b8f38b0fb1f05b7b105d5e7fd143c9503ca0c8a1df2"
