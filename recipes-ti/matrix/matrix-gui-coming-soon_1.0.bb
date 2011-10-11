DESCRIPTION = "coming soon descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://comingsoon/comingsoon.desktop;md5=01ebad171fad40705288fcabccc770a2"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/616/5029/comingsoon_1.0.tar.gz"

S = "${WORKDIR}"

require matrix-gui-apps.inc

FILES_${PN} += "${MATRIX_BASE_DIR}/*"

SRC_URI[md5sum] = "04076ed62be226ffee3f3960237c47f8"
SRC_URI[sha256sum] = "f00d24a506f39b92ba335479f902bdb97680df3502f81343be5baab45fd2bc95"
