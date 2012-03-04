DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r14"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=659ee0c98db2664403c769d6b9ab50eb"

SRC_URI = "http://dominion.thruhere.net/koen/angstrom/beaglebone/bonescript-ca0f663083cea4e434864aa276d46ff79d471dff.tar.bz2 \
           file://bonescript-git \
           file://bone101.service \
          "
SRC_URI[md5sum] = "2b7edd83a752eaf0be0c7488d32c7e72"
SRC_URI[sha256sum] = "839ee1147b83924f259dc5e373d73eb0eaa6ece76322dc156a6b04113fa89a91"

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
