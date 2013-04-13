DESCRIPTION = "BeagleBone 101"

LICENSE = "MIT & LGPLv3 & others"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f02920251cbdc9b014dc1cbdb2bb95c4"

PV = "1.0"
PR = "r3"

SRCREV = "5987527486853119a1411c8774f3b58a91fae2f7"
SRC_URI = "git://github.com/jadonk/bone101.git"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
