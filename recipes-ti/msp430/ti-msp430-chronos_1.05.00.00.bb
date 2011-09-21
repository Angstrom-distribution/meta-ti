DESCRIPTION = "eZ430 Chronos Tools - MSP430 Development Kit/Watch"
HOMEPAGE = "http://processors.wiki.ti.com/index.php/EZ430-Chronos"
LICENSE = "TI-BSD"
# We can't use the actualy source file, since it has space in its name :(
LIC_FILES_CHKSUM = "file://eZ430-Chronos_CC_1_1.tcl;md5=59ba6ee0a26650ec660a4e65a9462806"

SECTION = "multimedia"

inherit allarch

PV = "1_05_00_00"

SRC_URI = "http://focus.ti.com/lit/sw/slac388/slac388.zip;name=slac388zip"

SRC_URI[slac388zip.md5sum] = "22d4104a07af584222828fb377793796"
SRC_URI[slac388zip.sha256sum] = "1c9cd1e36015e8db3b36c98be41907628144b76002b3f76b27fd310f4bd35ad7"

require ../includes/ti-paths.inc
require ../includes/ti-staging.inc
require ../includes/ti-eula-unpack.inc

S = "${WORKDIR}/ti/eZ430-Chronos"

BINFILE="Chronos-Setup"
TI_BIN_UNPK_CMDS="Y:workdir:"

do_unpack_append() {
    os.system('mv "Texas Instruments" ti')
}

do_configure() {
	cp Control\ Center/Chronos\ Control\ Center/eZ430-Chronos_CC_1_1.tcl ${S}
}

do_compile() {
    echo "Do Nothing for Now"
}

do_install() {

    install -d ${D}/${installdir}/ti-msp430-chronos-apps
    cp -pPrf "${S}"/"Control Center"/* ${D}/${installdir}/ti-msp430-chronos-apps

    # Remove dos formatting
    dos2unix "${D}/${installdir}/ti-msp430-chronos-apps/Chronos Data Logger"/*
    dos2unix "${D}/${installdir}/ti-msp430-chronos-apps/Chronos Control Center"/*

    # Should probably also remove hardcoded script reference to tcl8.5
}

PACKAGES += "ti-msp430-chronos-apps"
FILES_ti-msp430-chronos-apps = "${installdir}/ti-msp430-chronos-apps/*"

RDEPENDS_ti-msp430-chronos-apps += " tcl tk xdotool"
RRECOMMENDS_ti-msp430-chronos-apps = "kernel-module-cdc-acm"
