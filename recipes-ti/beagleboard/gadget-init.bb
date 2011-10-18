DESCRIPTION = "Units to initialize usb gadgets"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "(ti33x)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://storage-gadget-init.service \
           file://hokey-pokey.service \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system/basic.target.wants
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system
	for i in ${WORKDIR}/*.service ; do
		install -m 0644 $i ${D}${base_libdir}/systemd/system
		ln -sf ../$(basename $i) ${D}${base_libdir}/systemd/system/basic.target.wants/
	done
}

FILES_${PN} = "${base_libdir}/systemd"
