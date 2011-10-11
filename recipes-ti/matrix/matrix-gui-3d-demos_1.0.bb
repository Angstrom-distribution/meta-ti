DESCRIPTION = "3D demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/603/5030/3ddemos_1.0.tar.gz"

S = ${WORKDIR}/3ddemos

require matrix-gui-apps.inc

# Make sure 3D submenu has been installed
RDEPENDS +=  matrix-gui-submenus-3d

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "998363dbabea3724c4c3283a480cdb60"
SRC_URI[sha256sum] = "aab5890dffe4e9f36f78a64ec16e7221649bb61ef1ceee2e1246cd666d197268"
