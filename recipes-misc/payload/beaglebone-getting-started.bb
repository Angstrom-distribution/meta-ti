DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r23"

inherit allarch

LICENSE = "GPLv2+ & MIT & PD & others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4040d560ed8da9b0873348b25b3f45b4"

SRCREV = "1e5d54c25581fbf9819763af7f40c88950e64e1b"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}
}

FILES_${PN} += "${datadir}/${PN}"
