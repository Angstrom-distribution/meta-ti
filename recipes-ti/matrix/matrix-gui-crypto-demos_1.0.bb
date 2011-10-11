DESCRIPTION = "Cryptography demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/609/5033/cryptodemos_1.0.tar.gz"

S = ${WORKDIR}/cryptodemos

require matrix-gui-apps.inc

# Make sure crypto submenu has been installed and openssl is available
RDEPENDS +=  "matrix-gui-submenus-cryptos openssl"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "17a640f9d8a18694a67a8c2e473d1a2d"
SRC_URI[sha256sum] = "9d1724e33dfe93a38fe70e517b3e3e0a641c993ebd5f56cc54317b351b3ba06a"
