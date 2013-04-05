DESCRIPTION = "Scripting tools for the BeagleBoard and BeagleBone"

PR = "r18"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=659ee0c98db2664403c769d6b9ab50eb"

SRCREV = "dcc2cc5703ad52eaed3b13b4593c4ef90ff0f79b"

SRC_URI = "git://github.com/jadonk/bonescript.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${libdir}/node_modules/bonescript
	cp -a ${S}/node_modules/bonescript/* ${D}${libdir}/node_modules/bonescript

	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${S}/systemd/bonescript.service ${D}${base_libdir}/systemd/system
	install -m 0644 ${S}/systemd/bonescript.socket ${D}${base_libdir}/systemd/system

	install -d ${D}${sysconfdir}/profile.d
	install -m 0755 ${S}/profile.d/node.sh ${D}${sysconfdir}/profile.d
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "bonescript.service bonescript.socket"

FILES_${PN} += "${libdir}/node_modules/bonescript ${base_libdir}/systemd/system ${sysconfdir}/profile.d"
RDEPENDS_${PN} = "nodejs beaglebone-getting-started"

FILES_${PN}-dbg += "${libdir}/node_modules/bonescript/build/Release/.debug"
