DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r15"

inherit allarch

LICENSE = "GPLv2+ && MIT && PD && others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "46c58edffaca856fbe5efa8126af7b1e933a1c9b"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
