DESCRIPTION = "Boot Monitor - TI ARM Boot monitor code"
EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"

LICENSE = "BSD"

BOOT_MONITOR_BINARY ?= "skern.bin"
BOOT_MONITOR_IMAGE  ?= "skern-${MACHINE}.bin"
BOOT_MONITOR_MAKE_TARGET  ?= "all"

LIC_FILES_CHKSUM = "file://COPYING;md5=b676661788f8c0f8cdeafd2a39467cae"

COMPATIBLE_MACHINE = "keystone-evm"

SRC_URI = "git://gtgit01.gt.design.ti.com/git/projects/boot-monitor.git;protocol=git;branch=${BRANCH}"

PV = "1.0"
PR = "r0+gitr${SRCPV}"

BRANCH = "master"

S = "${WORKDIR}/git"

SRCREV = "b8014b69e8c7e981e8bc3e067a9d990e2bb603ba"

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
