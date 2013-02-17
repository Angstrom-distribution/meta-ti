SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP3 EVM from PSP, based on linux-omap3 kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KERNEL_IMAGETYPE = "uImage"

inherit kernel

BRANCH ?= "master"

COMPATIBLE_MACHINE = "am37x-evm|am3517-evm"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 devices
# see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"

S = "${WORKDIR}/git"

SRCREV= "v2.6.37_OMAPPSP_04.02.00.07"

SRC_URI = "git://arago-project.org/git/projects/linux-omap3.git;protocol=git;branch=${BRANCH} \
           file://defconfig"

# The following patches below have been upstreamed to linux kernel 2.6.39 tree
# and will not be needed once we move to this kernel.
# The only exception is "0002-allow-selecting-WL12XX_PLATFROM_DATA-independently.patch"
# which is needed for building against a compat-wireless package

SRC_URI += " \
    file://0001-linux-omap3-Add-OCF-support-to-2.6.37-kernel.patch \
    file://0001-omap3evm-add-support-for-the-WL12xx-WLAN-module.patch \
    file://0002-allow-selecting-WL12XX_PLATFROM_DATA-independently.patch \
    file://0003-mmc-skip-detection-of-nonremovable-cards-on-rescan.patch \
    file://0004-mmc-sdio-don-t-reinitialize-nonremovable-powered-res.patch \
    file://0005-mmc-sdio-don-t-power-up-cards-on-system-suspend.patch \
    file://0006-wl12xx-Backport-wl12xx-platform-data.patch \
    file://0007-activate-wireless-extensions.patch \
"

# Update the kernel so support suspend/resume when the file system is located
# on the SD card.  This is also being submitted to the PSP team for inclusion
# in future releases.
SRC_URI += " \
    file://0001-Fix-matrix-suspend.patch \
"

# Update the OCF kernel patch to remove non-existing components for
# non-TI hardware.  This allows the make clean target to work.
# Update the defconfig for omap3 to enable OCF and WLAN by default
SRC_URI += " \
    file://0001-OCF-support-remove-support-for-non-TI-hardware.patch \
    file://0002-omap3_evm_defconfig-add-OCF-driver-support.patch \
    file://0003-omap3_evm_defconfig-add-WLAN-config-options.patch \
"

# Enable clock pad register in mt9t111 sensor driver. This fixes the issue where
# sensor sync pulses were not generated during first loopback after boot-up.
SRC_URI += " \
    file://0001-mt9t111-enable-clock-pad-register-in-configuration.patch \
"

# The following patches add support for wake on wlan (WoWlan)
# which is supported in nlcp R4 release
SRC_URI += "file://0001-omap3evm-add-wake-on-wlan-support.patch \
    file://0001-nlcp-sdio-fixes-for-wowlan-support.patch \
    file://0002-mmc-sdio-support-suspend-resume-while-runtime-suspen.patch \
    file://0003-mmc_card_keep_power-cleanups.patch \
    file://0004-mmc-do-not-switch-to-1-bit-mode-if-not-required.patch \
    file://0005-mmc-fix-division-by-zero-in-MMC-core.patch \
    file://0006-revert-duplicate-insertion-of-mmc_card_keep_power-fu.patch \
"

# The following patches allow for NOR to be enabled and built
# easily.
SRC_URI += " \
    file://0001-omap3-am3517evm-Allow-for-NAND-to-really-be-disabled.patch \
    file://0002-omap3-am3517evm-Update-NOR-partition-table.patch \
    file://0003-AM3517-Add-am3517_evn_nor_defconfig.patch \
"

# The following patch sets the dto timeout for SD cards to the max of 14.
# This has been found to make SD cards work more reliably in the omap3 systems
SRC_URI += " \
    file://0001-omap_hsmmc-make-default-dto-value-14.patch \
"

# Add ABB support to the Linux kernel to enable 1GHz OPP and to allow
# booting at 1GHz
SRC_URI += " \
    file://0001-am37x-Adding-ABB-Support-for-1GHz-OPP.patch \
"

# Fix USB role switching when leaving USB cable connected
SRC_URI += " \
    file://0001-usb-musb-am35x-set-default-VBUS-timeout-value.patch \
    file://0002-usb-musb-am35x-fix-role-switching-issue.patch \
"

# Updated PIO mode for MUSB help description
SRC_URI_append_am3517-evm = " file://0001-musb-update-PIO-mode-help-information-in-Kconfig.patch"
