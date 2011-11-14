DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r8"

inherit allarch systemd

# Ask Jason
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRCREV = "c6c5f3b013eea425d3f4ee64d58b993289d2530f"
SRC_URI = "git://github.com/jadonk/bonescript.git \
           file://bonescript-git \
           file://file://bone101.service \
          "
S = "${WORKDIR}/git"

do_install() {
	install -m 0644 ${WORKDIR}/bonescript-git ${S}/.git/config
	cp $(cat .git/objects/info/alternates)/pack/* .git/objects/pack
	rm -f ${S}/.git/objects/info/alternates
	echo ${SRCREV} > .git/refs/heads/master
	git checkout master || true
	install -d ${D}${localstatedir}/lib/cloud9/
	cp -a ${S}/* ${D}${localstatedir}/lib/cloud9/
	cp -a ${S}/.git ${D}${localstatedir}/lib/cloud9/

	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/bone101.service ${D}${base_libdir}/systemd/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bone101.service"

FILES_${PN} += ""${localstatedir} ${base_libdir}/systemd/system"
RDEPENDS_${PN} = "nodejs cloud9"
RRECOMMENDS_${PN} = "git"
