require x-load.inc

DEPENDS += "signgp-native"

LIC_FILES_CHKSUM = "file://README;md5=fb7a7e60aceaa99c529b6c667dfcf474"

COMPATIBLE_MACHINE = "am3517-evm"

PV = "1.46+${PR}+gitr${SRCREV}"
PR ="r0"
PE = "1"

# TI PSP v1.46_OMAPPSP_03.00.01.06 (Tag is one commit different)
SRCREV_pn-${PN} = "fc6d5be15c703d21aef0ae0b8c02177721f0445f"
SRC_URI = "git://arago-project.org/git/projects/x-load-omap3.git;protocol=git"

S = "${WORKDIR}/git"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake distclean
	oe_runmake ${XLOAD_MACHINE}
	oe_runmake
}

do_install () {
	signGP x-load.bin ${XLOAD_LOAD_ADDRESS}

	install -d ${D}/boot
	install x-load.bin.ift ${D}/boot/${MLO_IMAGE}
	ln -sf ${MLO_IMAGE} ${D}/boot/${MLO_SYMLINK_NOMACHINE}
}

FILES_${PN} = "/boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"
