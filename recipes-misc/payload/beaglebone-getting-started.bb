DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r26"

inherit allarch

LICENSE = "GPLv2+ & MIT & PD & others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4040d560ed8da9b0873348b25b3f45b4"

SRCREV = "f21138f80afad60c4721874ec41474bbd58ea970"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
