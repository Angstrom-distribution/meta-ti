DESCRIPTION = "BeagleBone tester scripts"
HOMEPAGE = "http://beagleboard.org/support"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://gpl.txt;md5=5b122a36d0f6dc55279a0ebc69f3c60b"

# only scripts and data
inherit allarch

PR = "r20"

SRC_URI = "git://github.com/koenkooi/validation-scripts.git;protocol=git \
          "
SRCREV = "487a13e2e4faaafa40ba5430600e6aeecf9581a8"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${localstatedir}/lib/bone-tester/component/data/
	install -d ${D}${localstatedir}/lib/bone-tester/init-scripts/
	install -d ${D}${localstatedir}/lib/bone-tester/lib
	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants/
	install -d ${D}/boot/
	install -m 0755 ${S}/bone-tester/init-scripts/uEnv.txt ${D}/boot/uEnv.txt

	# systemd configuration
	ln -s ../bone-tester.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/bone-tester.service
	install -m 0755 ${S}/bone-tester/init-scripts/bone-tester.service ${D}${base_libdir}/systemd/system/bone-tester.service
	install -m 0755 ${S}/bone-tester/init-scripts/init.sh ${D}${localstatedir}/lib/bone-tester/init-scripts/init.sh

	for i in $(find ${S}/bone-tester/component/ -maxdepth 1 -type f) ; do
		install -m 0755 ${i} ${D}${localstatedir}/lib/bone-tester/component/
	done
	for i in ${S}/bone-tester/component/data/* ; do
		install -m 0755 ${i} ${D}${localstatedir}/lib/bone-tester/component/data/
	done
	for i in ${S}/bone-tester/lib/* ; do
		install -m 0755 ${i} ${D}${localstatedir}/lib/bone-tester/lib/
	done

	install -d ${D}${bindir}
	install -m 0755 ${S}/testaudio ${D}${bindir}

}


FILES_${PN} += "${base_libdir}/systemd \
                /boot \
               "

RDEPENDS_${PN} = "alsa-utils-aplay sox iputils memtester"
RRECOMMENDS_${PN} = "kernel-module-g-zero \
                     kernel-module-g-mass-storage \
                     kernel-module-g-file-storage \
                     kernel-module-smsc95xx"

