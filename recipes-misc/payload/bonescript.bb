DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r17"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f02920251cbdc9b014dc1cbdb2bb95c4"

SRC_URI = "http://dominion.thruhere.net/koen/angstrom/beaglebone/bonescript-49e08eb9fb96594235cf079a319387416e1545a9.tar.bz2 \
           file://bonescript-git \
           file://bone101.service \
          "
SRC_URI[md5sum] = "11b167d5ce182188184258ec35df7653"
SRC_URI[sha256sum] = "71af7e258612c1d1728a068ff205bdd857e08eb84ea3ec9203fcd63a07d24cca"

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
