DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r2"

inherit allarch

LICENSE = "GPLv2+ && MIT && PD && others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "bb2fdff7d7bed1bddddc0e5e05da4e03916d88a8"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
