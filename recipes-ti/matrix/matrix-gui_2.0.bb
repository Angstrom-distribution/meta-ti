DESCRIPTION = "Matrix GUI Application launcher"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix-gui-v2/"

LICENSE = "BSD MIT Apache"
LIC_FILES_CHKSUM = "file://scripts/jquery-1.6.2.min.js;md5=a1a8cb16a060f6280a767187fd22e037"

SECTION = "multimedia"

PR = "r3"

inherit allarch

BRANCH ?= "master"
SRCREV = "8e2bd5ffdded23bb662476fcd2490fa1526801f8"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2.git;protocol=git;branch=${BRANCH} \
           file://matrix-gui.service"

require matrix-gui-paths.inc

S = "${WORKDIR}/git"

do_install(){
	install -d ${D}${MATRIX_BASE_DIR}
	install -d ${D}${MATRIX_WEB_DIR}
	cp -rf ${S}/* ${D}${MATRIX_WEB_DIR}

    # Install our php.ini file
    install -m 0644 ${WORKDIR}/php.ini ${D}${MATRIX_BASE_DIR}/

    # Set the proper path in the init script
    sed -i -e s=__MATRIX_WEB_DIR__=${MATRIX_WEB_DIR}=g ${WORKDIR}/matrix-gui.service

	install -d ${D}${base_libdir}/systemd/system/
    install -m 0755 ${WORKDIR}/matrix-gui.service ${D}${base_libdir}/systemd/system/

	# activate it on first boot
	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants
	ln -sf ../matrix-gui.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/
}

RDEPENDS_${PN} += "lighttpd lighttpd-module-cgi lighttpd-module-compress lighttpd-module-expire php php-cgi php-cli matrix-gui-browser"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
