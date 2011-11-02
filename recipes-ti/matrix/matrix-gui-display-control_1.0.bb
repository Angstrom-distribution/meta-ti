DESCRIPTION = "Display control descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"

PR = "r1"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/674/5097/displaycontrol_1.1.tar.gz"

S = ${WORKDIR}/displaycontrol

require matrix-gui-apps.inc

# Make sure display submenu has been installed
RDEPENDS +=  matrix-gui-submenus-display

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "1032490affff638b993367ce5a451298"
SRC_URI[sha256sum] = "78d3a6e1e74acb55a927cc7e087cd15c33767cfaf9458200aa863025cee32f2e"
