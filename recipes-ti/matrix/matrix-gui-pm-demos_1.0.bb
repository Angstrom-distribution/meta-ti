DESCRIPTION = "Power management demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"

PR = "r1"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/676/5099/pmdemos_1.1.tar.gz"

S = ${WORKDIR}/pmdemos

require matrix-gui-apps.inc

# Make sure power submenu has been installed
RDEPENDS +=  matrix-gui-submenus-power

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "f996f9754c3d140e95501d8b4134f21c"
SRC_URI[sha256sum] = "229579b71439c0ad4cff60d7ebb4065f6871db57dd5baa4a5983c9f7804655ab"
