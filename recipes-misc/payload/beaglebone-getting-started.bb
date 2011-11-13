DESCRIPTION = "BeagleBone Getting Started Guide"

PR = "r9"

inherit allarch systemd

LICENSE = "GPLv2+ && MIT && PD && others"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=603591dea023c3c75b48e07cb47ce639"

SRCREV = "ee3af61403b087c2882ba539d3358ba25c5b8dc7"
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
