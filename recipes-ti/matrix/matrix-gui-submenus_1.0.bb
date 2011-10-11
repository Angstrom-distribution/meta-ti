DESCRIPTION = "Submenu packages for Matrix GUI v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
PRIORITY = "optional"

PR = "r0"

require matrix-gui-paths.inc

# These packages make submenus in matrix and are not architecture specific
PACKAGE_ARCH = "all"

# List of submenu tarballs to use.  Each tarball contains a desktop file
# and PNG graphic file for the submenu.
SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/589/5037/arm.tar.gz;name=armtarball \
           https://gforge.ti.com/gf/download/frsrelease/588/5038/3d.tar.gz;name=3dtarball \
           https://gforge.ti.com/gf/download/frsrelease/591/5039/cryptos.tar.gz;name=cryptostarball \
           https://gforge.ti.com/gf/download/frsrelease/592/5040/display.tar.gz;name=displaytarball \
           https://gforge.ti.com/gf/download/frsrelease/593/5041/ethernet.tar.gz;name=ethernettarball \
           https://gforge.ti.com/gf/download/frsrelease/594/5042/multimedia.tar.gz;name=multimediatarball \
           https://gforge.ti.com/gf/download/frsrelease/595/5043/power.tar.gz;name=powertarball \
           https://gforge.ti.com/gf/download/frsrelease/596/5044/pru.tar.gz;name=prutarball \
           https://gforge.ti.com/gf/download/frsrelease/597/5045/qt4.tar.gz;name=qt4tarball \
           https://gforge.ti.com/gf/download/frsrelease/598/5046/settings.tar.gz;name=settingstarball \
           https://gforge.ti.com/gf/download/frsrelease/599/5047/usb.tar.gz;name=usbtarball \
           https://gforge.ti.com/gf/download/frsrelease/600/5048/wifi.tar.gz;name=wifitarball \
"

S = ${WORKDIR}

# List of submenus to build packages for
SUBMENUS = "arm 3d cryptos display ethernet multimedia power pru qt4 settings usb wifi"

do_install(){
	install -d ${D}${MATRIX_APP_DIR}

    for x in ${SUBMENUS}
    do
        cp -rf ${S}/$x ${D}${MATRIX_APP_DIR}/
    done
}

PACKAGES += "${PN}-arm ${PN}-3d ${PN}-cryptos ${PN}-display ${PN}-ethernet ${PN}-multimedia ${PN}-power ${PN}-pru ${PN}-qt4 ${PN}-settings ${PN}-usb ${PN}-wifi"

# All submenu packages should depend on matrix-gui being installed
RDEPENDS +=  matrix-gui

# Add the files for each submenu package
FILES_${PN}-arm = "${MATRIX_APP_DIR}/arm/*"
FILES_${PN}-3d = "${MATRIX_APP_DIR}/3d/*"
FILES_${PN}-cryptos = "${MATRIX_APP_DIR}/cryptos/*"
FILES_${PN}-display = "${MATRIX_APP_DIR}/display/*"
FILES_${PN}-ethernet = "${MATRIX_APP_DIR}/ethernet/*"
FILES_${PN}-multimedia = "${MATRIX_APP_DIR}/multimedia/*"
FILES_${PN}-power = "${MATRIX_APP_DIR}/power/*"
FILES_${PN}-pru = "${MATRIX_APP_DIR}/pru/*"
FILES_${PN}-qt4 = "${MATRIX_APP_DIR}/qt4/*"
FILES_${PN}-settings = "${MATRIX_APP_DIR}/settings/*"
FILES_${PN}-usb = "${MATRIX_APP_DIR}/usb/*"
FILES_${PN}-wifi = "${MATRIX_APP_DIR}/wifi/*"

# checksums for the submenu tarballs
SRC_URI[armtarball.md5sum] = "ed7d73441e0d85e84aa6df06d86e9d72"
SRC_URI[armtarball.sha256um] = "99f9ccba0df1d8f1bfb78cf90eec8e64e961651ba6079e9c4bb21f8243d33ece"

SRC_URI[3dtarball.md5sum] = "8aa161e1836e0efcf3db657f94137a34"
SRC_URI[3dtarball.sha256um] = "b522065d288e49f50cbf1ee2c9deb76683161d82eb0429635bc66c4f26f235f1"

SRC_URI[cryptostarball.md5sum] = "d1fbc3b575775557e3e150818d86373a"
SRC_URI[cryptostarball.sha256um] = "f4c1645bf858dc157d4efae3ca66e437310294bfd564bdeb89c6609ae65cadf9"

SRC_URI[displaytarball.md5sum] = "aa72fc22aa550b48ab32e28b2f8cbbcf"
SRC_URI[displaytarball.sha256sum] = "593a7f91226b10b1f37fdf85c0d70c8aaf4a690df50ae364c422dbc2c586352b"

SRC_URI[ethernettarball.md5sum] = "2a8afa6b2666d210eb9ac3c48dd173c0"
SRC_URI[ethernettarball.sha256sum] = "1f78b81b043f4ed75b89697ad4609b5752a804300a094b279bc0391464c8af8d"

SRC_URI[multimediatarball.md5sum] = "8ef64f7b252633d6b2f74561f047f874"
SRC_URI[multimediatarball.sha256sum] = "e093c06b7bb40e51ab42ef1d896008d3ba3463629532bd0dcc1417368b73054b"

SRC_URI[powertarball.md5sum] = "26ef7b4e83386a5a16a08fdb04e20047"
SRC_URI[powertarball.sha256sum] = "87b3381cffeb2951ad7ffdff8df2661ad845303ffc850fa10caf8a9b35c09da5"

SRC_URI[prutarball.md5sum] = "6f28ee2bc5de2bb9db035e4736f6e205"
SRC_URI[prutarball.sha256sum] = "872fc89905fab81007274aa86cd43d822c71cf799bf7de92ac9e0394ced158d1"

SRC_URI[qt4tarball.md5sum] = "f724ca0c58de81477583294078f8666e"
SRC_URI[qt4tarball.sha256sum] = "75758cf90981c73603e728fd835f91b250978fb8141634f16b6e7b4ec62c08b1"

SRC_URI[settingstarball.md5sum] = "a9de5dfa9cf007f7401d5768655fef15"
SRC_URI[settingstarball.sha256sum] = "611f19671a2403f1d4f86ac46981d9297851572d867f4049d34b25c4831d2a0a"

SRC_URI[usbtarball.md5sum] = "c03096c816724a3f3ae34a92b0c8729e"
SRC_URI[usbtarball.sha256sum] = "384f733ef1b6808a29a0cfd102ab1ec766913fc88bfa587ee9fb46028835190a"

SRC_URI[wifitarball.md5sum] = "f6ee538c77ac1ea7a502955e7e3cc624"
SRC_URI[wifitarball.sha256sum] = "83edd8cf1c6efbfaa8c2e25b4a984ff6587aa7e379b833810452cb47ff5a6200"
