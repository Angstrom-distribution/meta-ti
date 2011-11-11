DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r6"

inherit allarch

# Ask Jason
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRCREV = "0b264f3144cb6385e33346dec02692d71844898d"
SRC_URI = "git://github.com/jadonk/bonescript.git \
           file://bonescript-git \
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
}

RDEPENDS_${PN} = "nodejs cloud9"
RRECOMMENDS_${PN} = "git"
FILES_${PN} += "${localstatedir}"
