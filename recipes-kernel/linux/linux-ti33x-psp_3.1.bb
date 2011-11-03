SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI33x EVM from PSP, based on am335x-kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"

require multi-kernel.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""

BRANCH = "v3.1-staging"
SRCREV = "1d84d8853fa30cf3db2571a5aec572accca4e29d"
MACHINE_KERNEL_PR_append = "p+gitr${SRCREV}"

COMPATIBLE_MACHINE = "(ti33x)"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
CONFIGS_PSP = "${@base_set_filespath(["${THISDIR}/${PN}-${PV}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/${PN}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/files/tipspkernel"], d)}:"
FILESPATH =. "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "${CONFIGS_PSP}", "", d)}"

SRC_URI += "git://arago-project.org/git/projects/linux-am33x.git;protocol=git;branch=${BRANCH} \
	file://defconfig"

PATCHES_OVER_PSP = " \
	file://0001-f_rndis-HACK-around-undefined-variables.patch \
	file://0001-ARM-omap-am335x-BeagleBone-version-detection-and-sup.patch \
	file://0002-ARM-OMAP2-beaglebone-add-LED-support.patch \
	file://0003-ARM-OMAP2-beaglebone-add-DVI-support-needs-cleanup.patch \
	file://0004-da8xx-fb-add-DVI-support-for-beaglebone.patch \
	"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "", "${PATCHES_OVER_PSP}", d)}"
