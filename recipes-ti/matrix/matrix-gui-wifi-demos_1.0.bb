DESCRIPTION = "Wifi demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

PACKAGE_ARCH = "all"

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/617/5049/wifi_1.0.tar.gz"

S = ${WORKDIR}/wifi

require matrix-gui-apps.inc

# Make sure wifi submenu has been installed
RDEPENDS +=  matrix-gui-submenus-wifi

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "10a57c18f0c6dcadb0371778a0959bbc"
SRC_URI[sha256sum] = "91de898d12a2f980a454a8c3f14b8165fcbd15da3cf565ea5dc80f04ad982159"
