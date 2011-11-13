DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r11"

inherit allarch

LICENSE = "GPLv2+ && MIT && PD && others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "70ff0ec0e2d44de35824577ab7b6da443dcc0e9a"
SRC_URI = "git://github.com/jadonk/beaglebone-getting-started.git \
           file://bone101.service"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${datadir}/${PN}
	cp -a ${S}/* ${D}${datadir}/${PN}

	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/bone101.service ${D}${base_libdir}/systemd/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bone101.service"

FILES_${PN} += "${datadir}/${PN} ${base_libdir}/systemd/system"
