SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI33x EVM from PSP, based on am335x-kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"

require multi-kernel.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""

BRANCH = "v3.1-meta-ti-r1r+gitr1d84d8853fa30cf3db2571a5aec572accca4e29d"
SRCREV = "1d84d8853fa30cf3db2571a5aec572accca4e29d"
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"

COMPATIBLE_MACHINE = "(ti33x)"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
CONFIGS_PSP = "${@base_set_filespath(["${THISDIR}/${PN}-${PV}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/${PN}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/files/tipspkernel"], d)}:"
FILESPATH =. "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "${CONFIGS_PSP}", "", d)}"

SRC_URI += "git://github.com/beagleboard/linux.git;branch=${BRANCH} \
	file://defconfig"

PATCHES_OVER_PSP = " \
	file://0001-f_rndis-HACK-around-undefined-variables.patch \
	file://0001-ARM-omap-am335x-BeagleBone-version-detection-and-sup.patch \
	file://0002-ARM-OMAP2-beaglebone-add-LED-support.patch \
	file://0003-ARM-OMAP2-beaglebone-add-DVI-support-needs-cleanup.patch \
	file://0004-da8xx-fb-add-DVI-support-for-beaglebone.patch \
	file://0001-usb-musb_core-kill-all-global-and-static-variables.patch \
	file://0002-arm-omap-am335x-correct-32KHz-clk-rate.patch \
	file://0003-arm-omap-mcspi-correct-memory-range-when-requesting-.patch \
	file://0004-arm-omap-mcspi-follow-proper-pm_runtime-enable-disab.patch \
	file://0005-arm-omap-mcspi-follow-proper-probe-remove-steps.patch \
	file://0006-usb-musb-cppi41_dma-Check-if-scheduling-is-required-.patch \
	file://can/0001-can-d_can-Added-support-for-Bosch-D_CAN-controller.patch \
	file://can/0002-can-d_can-Added-platform-data-for-am33xx-device.patch \
	file://can/0003-can-d_can-DCAN-config-added-to-am335x_evm_defconfig.patch \
	file://can/0004-can-d_can-fix-for-cansend-loop-issue.patch \
	file://can/0005-can-d_can-fixes-the-rmmod-crash.patch \
	"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "", "${PATCHES_OVER_PSP}", d)}"
SRC_URI_append_beaglebone = " file://logo_linux_clut224.ppm"

