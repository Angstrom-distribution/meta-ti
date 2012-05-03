DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r15"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=659ee0c98db2664403c769d6b9ab50eb"

SRC_URI = "http://dominion.thruhere.net/koen/angstrom/beaglebone/bonescript-6af82b41178c37644399b19039ea7e80c1dbf8ee.tar.bz2 \
           file://bonescript-git \
           file://bone101.service \
          "
SRC_URI[md5sum] = "e5e214857afbd2e59b52171e60810be2"
SRC_URI[sha256sum] = "e703416a63406c8b6c89fb1079406833ce6a9eb0ae1ba0a55fe3802b83186c50"

S = "${WORKDIR}/bonescript"

do_install() {
	install -d ${D}${localstatedir}/lib/cloud9/
	cp -a ${S}/* ${D}${localstatedir}/lib/cloud9/
	cp -a ${S}/.git ${D}${localstatedir}/lib/cloud9/

	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/bone101.service ${D}${base_libdir}/systemd/system

	rm -f ${D}${localstatedir}/lib/cloud9/node_modules/binary/node_modules/put/test/c/itof
	rm -f ${D}${localstatedir}/lib/cloud9/node_modules/binary/node_modules/put/test/c/ftoi
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bone101.service"

FILES_${PN} += "${localstatedir} ${base_libdir}/systemd/system"
CONFFILES_${PN} += "${localstatedir}/lib/cloud9/.git/config"
RDEPENDS_${PN} = "nodejs cloud9"
RRECOMMENDS_${PN} = "git"
