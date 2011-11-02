DESCRIPTION = "Submenu packages for Matrix GUI v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"
LIC_FILES_CHKSUM = "file://settings/settings.desktop;md5=a447e92dfe653e63e5b91b305e969d6c"

PR = "r7"

require matrix-gui-paths.inc

# These packages make submenus in matrix and are not architecture specific
inherit allarch

# List of submenu tarballs to use.  Each tarball contains a desktop file
# and PNG graphic file for the submenu.
SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/699/5133/arm_1.1.tar.gz;name=armtarball \
           https://gforge.ti.com/gf/download/frsrelease/698/5134/3d_1.1.tar.gz;name=3dtarball \
           https://gforge.ti.com/gf/download/frsrelease/700/5135/cryptos_1.1.tar.gz;name=cryptostarball \
           https://gforge.ti.com/gf/download/frsrelease/693/5120/display_1.2.tar.gz;name=displaytarball \
           https://gforge.ti.com/gf/download/frsrelease/692/5119/ethernet_1.4.tar.gz;name=ethernettarball \
           https://gforge.ti.com/gf/download/frsrelease/701/5136/multimedia_1.1.tar.gz;name=multimediatarball \
           https://gforge.ti.com/gf/download/frsrelease/702/5137/power_1.1.tar.gz;name=powertarball \
           https://gforge.ti.com/gf/download/frsrelease/704/5139/pru_1.1.tar.gz;name=prutarball \
           https://gforge.ti.com/gf/download/frsrelease/705/5140/qt4_1.1.tar.gz;name=qt4tarball \
           https://gforge.ti.com/gf/download/frsrelease/694/5121/settings_1.2.tar.gz;name=settingstarball \
           https://gforge.ti.com/gf/download/frsrelease/695/5122/usb_1.2.tar.gz;name=usbtarball \
           https://gforge.ti.com/gf/download/frsrelease/697/5124/wifi_1.2.tar.gz;name=wifitarball \
           https://gforge.ti.com/gf/download/frsrelease/703/5138/oprofile_1.1.tar.gz;name=oprofiletarball \
"

S = ${WORKDIR}

# List of submenus to build packages for
SUBMENUS = "arm 3d cryptos display ethernet multimedia power pru qt4 settings usb wifi oprofile"

do_install(){
	install -d ${D}${MATRIX_APP_DIR}

    for x in ${SUBMENUS}
    do
        cp -rf ${S}/$x ${D}${MATRIX_APP_DIR}/
    done
}

PACKAGES += "${PN}-arm ${PN}-3d ${PN}-cryptos ${PN}-display ${PN}-ethernet ${PN}-multimedia ${PN}-power ${PN}-pru ${PN}-qt4 ${PN}-settings ${PN}-usb ${PN}-wifi ${PN}-oprofile"

# This should be automatic, but isn't :(
PROVIDES += "${PACKAGES}"

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
FILES_${PN}-oprofile = "${MATRIX_APP_DIR}/oprofile/*"

# checksums for the submenu tarballs
SRC_URI[armtarball.md5sum] = "e43585674dac2d6d6860a26c2de5332c"
SRC_URI[armtarball.sha256um] = "270f82b09fcdc3d1a08570d30ff2a9085e7b61a0f6890f734c658cd6408de155"

SRC_URI[3dtarball.md5sum] = "1cabbb75849e892a5fc7322159750f8a"
SRC_URI[3dtarball.sha256um] = "df4983c0722a9427584497f737af57c8401a6b3898f71c994a0cfe97e5ade01a"

SRC_URI[cryptostarball.md5sum] = "88d4ece28e75eb28358b43729022c91a"
SRC_URI[cryptostarball.sha256um] = "7999b2e06d27c30294c104418db79a1f9652a07a066242120cb32d3f86706538"

SRC_URI[displaytarball.md5sum] = "eff9c5ab6667525ab0c452a6319cc5d8"
SRC_URI[displaytarball.sha256sum] = "834f22c4439bdd97c04160b9e002abcddf22188a01488476b604259324ea09af"

SRC_URI[ethernettarball.md5sum] = "ff82b9a0ce5bbf7b7672073147f415c9"
SRC_URI[ethernettarball.sha256sum] = "28e74cd7e30fff3c7cb6ac284fb39b98e73ecefa0182ab900f64d293845d51eb"

SRC_URI[multimediatarball.md5sum] = "21064503fc26611cfedf093e478440b3"
SRC_URI[multimediatarball.sha256sum] = "039d2f7fbbd29b31601cf6596268a5a43f9dd7e86ff888a9ef45515479797d3d"

SRC_URI[powertarball.md5sum] = "406a838e12d7f83bc5a004e748ceb660"
SRC_URI[powertarball.sha256sum] = "d6c0bc690c1f45cc81fa1673dad08bea03f799adb929e5a3ec3fe4ebda60fca8"

SRC_URI[prutarball.md5sum] = "b0eca67cdc45db2b9aa14987b4761068"
SRC_URI[prutarball.sha256sum] = "06d3acf5ba2e4d5ff796625b07b470e5cea945700c9571878b8f4ba6f171d2de"

SRC_URI[qt4tarball.md5sum] = "3576ad6bc96fceb18d4d8b0850bf559d"
SRC_URI[qt4tarball.sha256sum] = "11fd5ca37d72b7129035b7f6101b4b06ac2b69d53abcd6a2751d3e9c7000dec0"

SRC_URI[settingstarball.md5sum] = "f2634670768860954cc63309d1f4f37e"
SRC_URI[settingstarball.sha256sum] = "fb96e6e4107445e4d5d65e2475513a62e0cf5b52734c9f93e918715abcc09265"

SRC_URI[usbtarball.md5sum] = "63cebc3422af0f09f3eaa0a65b25bcde"
SRC_URI[usbtarball.sha256sum] = "7178afea3b5b2926ddbf80766f1d457d7a31704869bce62ffc8db4b3d6e063e7"

SRC_URI[wifitarball.md5sum] = "c8ae4df2521276b5b83294153825acf4"
SRC_URI[wifitarball.sha256sum] = "430f4c161eaf5dc28d524fbf4903274817023414154b2074a0b948e50724a6ff"

SRC_URI[oprofiletarball.md5sum] = "02d0c9eb9fed014170f57ad30f2a5c85"
SRC_URI[oprofiletarball.sha256sum] = "ebad9018c0bd37f075a248d60e6e5520824d09afd03e71395cfc9949747e33ac"
