DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r6"

inherit allarch

LICENSE = "GPLv2+ && MIT && PD && others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "cd615e7c31171bfb8c71f5d19ed34d8912b932b8"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
