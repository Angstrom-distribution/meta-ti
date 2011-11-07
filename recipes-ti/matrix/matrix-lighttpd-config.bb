DESCRIPTION = "ligHTTPD config for matrix"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://../lighttpd.conf.matrix;md5=58caecbd847bcc4d5141dea2ee4c42ec"

inherit allarch

SRC_URI = "file://lighttpd.conf.matrix"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/lighttpd.conf.matrix ${D}${sysconfdir}/lighttpd.conf.matrix
}

FILES_${PN} = "${sysconfdir}/lighttpd.conf.matrix"
RDEPENDS_${PN} = "lighttpd"

pkg_postinst_${PN} () {
if [ -f $D${sysconfdir}/lighttpd.conf ] ; then
	cp $D${sysconfdir}/lighttpd.conf.matrix $D${sysconfdir}/lighttpd.conf
else
	echo "No lighttpd.conf found, aborting"
	exit 1
fi
}

