DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r16"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f02920251cbdc9b014dc1cbdb2bb95c4"

SRC_URI = "http://dominion.thruhere.net/koen/angstrom/beaglebone/bonescript-debd593b47b85cab58f69a8b526160e3754e5bb5.tar.bz2 \
           file://bonescript-git \
           file://bone101.service \
          "
SRC_URI[md5sum] = "de5b8fa0f081725a69406293dc5423d8"
SRC_URI[sha256sum] = "bd12f3aff0063f61520b9e210f0a552eb6b63ca2a86beef1d88ac60d766a6b9b"

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

FILES_${PN}-dbg += "${localstatedir}/lib/cloud9/node_modules/bonescript/build/Release/.debug"
