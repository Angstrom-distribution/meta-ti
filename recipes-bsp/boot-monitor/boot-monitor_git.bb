DESCRIPTION = "Boot Monitor - TI ARM Boot monitor code"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

LICENSE = "BSD"

BOOT_MONITOR_BINARY ?= "skern.bin"
BOOT_MONITOR_IMAGE  ?= "skern-${MACHINE}.bin"
BOOT_MONITOR_MAKE_TARGET  ?= "all"

LIC_FILES_CHKSUM = "file://COPYING;md5=25fe219a6febf6e5bb45beda1b2eb315"

COMPATIBLE_MACHINE = "keystone-evm"

SRC_URI = "git://arago-project.org/git/projects/boot-monitor.git;protocol=git;branch=${BRANCH}"

PV = "1.0"
PR = "r2+gitr${SRCREV}"

BRANCH = "master"

S = "${WORKDIR}/git"

SRCREV = "94cab20c4a4725a014d6f815704557d28fec9610"

do_compile () {
	unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
	oe_runmake ${BOOT_MONITOR_MAKE_TARGET}
}

inherit deploy

addtask deploy before do_build after do_compile

do_deploy () {
	install -d ${DEPLOYDIR}
	install ${S}/${BOOT_MONITOR_BINARY} ${DEPLOYDIR}/${BOOT_MONITOR_IMAGE}
}
