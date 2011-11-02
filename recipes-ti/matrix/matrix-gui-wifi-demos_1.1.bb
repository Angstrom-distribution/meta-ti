DESCRIPTION = "Wifi demo descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/678/5101/wifidemos_1.1.tar.gz"

S = ${WORKDIR}/wifidemos

require matrix-gui-apps.inc

# Make sure wifi submenu has been installed
RDEPENDS +=  matrix-gui-submenus-wifi

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "60d85261bcad85da7ecd024613343068"
SRC_URI[sha256sum] = "36fe8bbc461e157b00ebf8f9deab1e5c83eef2f618bc98f2956d974e76534c56"
