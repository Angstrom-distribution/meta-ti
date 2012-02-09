DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r13"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=659ee0c98db2664403c769d6b9ab50eb"

SRC_URI = "http://dominion.thruhere.net/koen/angstrom/beaglebone/bonescript-8898f4ee4ae2548642679626a03e332a4cd43331.tar.bz2 \
           file://bonescript-git \
           file://bone101.service \
          "
SRC_URI[md5sum] = "306278a2afc10b75f4fc886918fb02b7"
SRC_URI[sha256sum] = "01c87e59adcc663365c664b0731f0e5a23feeae1965a5cd5edd3e89255f8a30b"

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

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bone101.service"

FILES_${PN} += "${localstatedir} ${base_libdir}/systemd/system"
CONFFILES_${PN} += "${localstatedir}/lib/cloud9/.git/config"
RDEPENDS_${PN} = "nodejs cloud9"
RRECOMMENDS_${PN} = "git"
