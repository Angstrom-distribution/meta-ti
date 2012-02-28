DESCRIPTION = "x-load bootloader loader"
SECTION = "bootloaders"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://common/cmd_load.c;beginline=4;endline=22;md5=14420d7cc8dfb427d17ad407ddf8dc89"

PARALLEL_MAKE = ""

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} CONFIG_HEADER=${CONFIG_HEADER}"

XLOAD_MACHINE ?= "${MACHINE}_config"

XLOAD_IMAGE ?= "x-load-${MACHINE}-${PV}-${PR}.bin.ift"
XLOAD_SYMLINK ?= "x-load-${MACHINE}.bin.ift"
XLOAD_USB_IMAGE ?= "x-load-usb-${MACHINE}-${PV}-${PR}.bin"
XLOAD_USB_SYMLINK ?= "x-load-usb-${MACHINE}.bin"
MLO_IMAGE ?= "MLO-${MACHINE}-${PV}-${PR}"
MLO_SYMLINK ?= "MLO-${MACHINE}"
MLO_SYMLINK_NOMACHINE ?= "MLO"
XLOAD_LOAD_ADDRESS ?= "0x40200800"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake distclean
	oe_runmake ${XLOAD_MACHINE}
	oe_runmake ift
}

do_install () {
	install -d ${D}/boot
	install ${S}/x-load.bin.ift ${D}/boot/${MLO_IMAGE}
	ln -sf ${MLO_IMAGE} ${D}/boot/${MLO_SYMLINK_NOMACHINE} 
}

FILES_${PN} = "/boot"

inherit deploy

addtask deploy before do_package after do_install

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	install ${S}/x-load.bin.ift ${DEPLOY_DIR_IMAGE}/${XLOAD_IMAGE}
	install ${S}/x-load.bin ${DEPLOY_DIR_IMAGE}/${XLOAD_USB_IMAGE}	
	install ${S}/x-load.bin.ift ${DEPLOY_DIR_IMAGE}/${MLO_IMAGE}

	cd ${DEPLOY_DIR_IMAGE}
	rm -f ${XLOAD_SYMLINK}
	ln -sf ${XLOAD_IMAGE} ${XLOAD_SYMLINK}
	rm -f ${XLOAD_USB_SYMLINK}
	ln -sf ${XLOAD_USB_IMAGE} ${XLOAD_USB_SYMLINK}	
	rm -f ${MLO_SYMLINK}
	ln -sf ${MLO_IMAGE} ${MLO_SYMLINK}
	rm -f ${MLO_SYMLINK_NOMACHINE}
	ln -sf ${MLO_IMAGE} ${MLO_SYMLINK_NOMACHINE}
}
