SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI33x EVM from PSP, based on am335x-kernel"
LICENSE = "GPLv2"
KERNEL_IMAGETYPE = "uImage"

require multi-kernel.inc

S = "${WORKDIR}/git"

MULTI_CONFIG_BASE_SUFFIX = ""

BRANCH = "v3.2-staging"
SRCREV = "21ef5e1fa530eb8f23bfe18650e3915d7c291ca9"
MACHINE_KERNEL_PR_append = "e+gitr${SRCREV}"

COMPATIBLE_MACHINE = "(ti33x)"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
CONFIGS_PSP = "${@base_set_filespath(["${THISDIR}/${PN}-${PV}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/${PN}/tipspkernel"], d)}:\
${@base_set_filespath(["${THISDIR}/files/tipspkernel"], d)}:"
FILESPATH =. "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "${CONFIGS_PSP}", "", d)}"

SRC_URI += "git://arago-project.org/git/projects/linux-am33x.git;protocol=http;branch=${BRANCH} \
	file://defconfig"

PATCHES_OVER_PSP = " \
	file://0002-f_rndis-HACK-around-undefined-variables.patch \
	file://0003-da8xx-fb-add-DVI-support-for-beaglebone.patch \
	file://0004-beaglebone-rebase-everything-onto-3.2-WARNING-MEGAPA.patch \
	file://0005-more-beaglebone-merges.patch \
	file://0006-beaglebone-disable-tsadc.patch \
	file://0007-tscadc-Add-general-purpose-mode-untested-with-touchs.patch \
	file://0008-tscadc-Add-board-file-mfd-support-fix-warning.patch \
	file://0009-AM335X-init-tsc-bone-style-for-new-boards.patch \
	file://0010-tscadc-make-stepconfig-channel-configurable.patch \
	file://0011-tscadc-Trigger-through-sysfs.patch \
	file://0012-meta-ti-Remove-debug-messages-for-meta-ti.patch \
	file://0013-tscadc-switch-to-polling-instead-of-interrupts.patch \
	file://0014-beaglebone-fix-ADC-init.patch \
	file://0015-AM335x-MUX-add-ehrpwm1A.patch \
	file://0016-beaglebone-enable-PWM-for-lcd-backlight-backlight-is.patch \
	file://0017-omap_hsmmc-Set-dto-to-max-value-of-14-to-avoid-SD-Ca.patch \
	file://0018-beaglebone-set-default-brightness-to-50-for-pwm-back.patch \
	file://0019-st7735fb-WIP-framebuffer-driver-supporting-Adafruit-.patch \
	file://0020-beaglebone-use-P8_6-gpio1_3-as-w1-bus.patch \
	file://0021-beaglebone-add-support-for-Towertech-TT3201-CAN-cape.patch \
"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "", "${PATCHES_OVER_PSP}", d)}"
SRC_URI_append_beaglebone = " file://logo_linux_clut224.ppm"

