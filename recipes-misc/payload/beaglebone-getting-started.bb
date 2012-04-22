DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r20"

inherit allarch

LICENSE = "GPLv2+ & MIT & PD & others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "7d1f070ab2e981a89db302b1b61e85562b949dac"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
