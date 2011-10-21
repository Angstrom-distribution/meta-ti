LICENSE = "NewBSD"
DESCRIPTION = "Tool to sign omap3 x-loader images"
LIC_FILES_CHKSUM = "file://signGP.c;md5=960f484fea13941ca88821366f9dade0"

SRC_URI = "file://signGP.c"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/signGP.c -o signGP
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 signGP ${D}${bindir}
}

S = "${WORKDIR}"

NATIVE_INSTALL_WORKS = "1"

BBCLASSEXTEND = "native nativesdk"
