DESCRIPTION = "Matrix GUI Application launcher"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix-gui-v2/"

LICENSE = "BSD MIT Apache"
LIC_FILES_CHKSUM = "file://javascript/jquery-latest.js;md5=9118381924c51c89d9414a311ec9c97f"

SECTION = "multimedia"

PR = "r5"

inherit allarch

BRANCH ?= "master"
SRCREV = "8e2bd5ffdded23bb662476fcd2490fa1526801f8"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2.git;protocol=git;branch=${BRANCH} \
           file://php.ini"

require matrix-gui-paths.inc

S = "${WORKDIR}/git"

do_install(){
	install -d ${D}${MATRIX_BASE_DIR}
	install -d ${D}${MATRIX_WEB_DIR}
	cp -rf ${S}/* ${D}${MATRIX_WEB_DIR}

    # Install our php.ini file
    install -m 0644 ${WORKDIR}/php.ini ${D}${MATRIX_BASE_DIR}/
}

RDEPENDS_${PN} += "lighttpd lighttpd-module-cgi lighttpd-module-compress lighttpd-module-expire php php-cgi php-cli"

FILES_${PN} += "${MATRIX_BASE_DIR}/*"
