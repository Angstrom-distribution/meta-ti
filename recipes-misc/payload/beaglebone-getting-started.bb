DESCRIPTION = "BeagleBone Getting Started Guide"

inherit allarch

# Ask Jason
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRCREV = "d775cc0e517b2df667da04fba081a995c7a4947d"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
