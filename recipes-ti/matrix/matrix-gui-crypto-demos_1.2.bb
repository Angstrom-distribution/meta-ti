DESCRIPTION = "Cryptography demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/688/5114/cryptodemos_1.2.tar.gz"

S = ${WORKDIR}/cryptodemos

require matrix-gui-apps.inc

# Make sure crypto submenu has been installed and openssl is available
RDEPENDS +=  "matrix-gui-submenus-cryptos openssl"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "dfab3e918fee165fb24e00cba5db8918"
SRC_URI[sha256sum] = "44fa00ce999279c10a51718298157d3006afb018f6f327f1803006b5e7068c8c"
