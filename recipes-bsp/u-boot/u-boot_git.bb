require u-boot.inc
PR ="r65"

FILESPATHPKG =. "u-boot-git:"

SRC_URI_beagleboard = "git://www.denx.de/git/u-boot.git;protocol=git \
                       file://0001-OMAP3-enable-i2c-bus-switching-for-Beagle-and-Overo.patch \
                       file://0002-OMAP3-add-board-revision-detection-for-Overo.patch \
                       file://0003-OMAP3-update-Beagle-revision-detection-to-recognize-.patch \
                       file://0004-OMAP3-Set-VAUX2-to-1.8V-for-EHCI-PHY-on-Beagle-Rev-C.patch \
                       file://0005-OMAP3-add-entry-for-rev-3.1.2-check-and-display-max-.patch \
                       file://0006-OMAP3-add-mpurate-boot-arg-for-overo-and-beagle.patch \
                       file://0007-OMAP3-detect-expansion-board-type-version-using-eepr.patch \
                       file://0008-OMAP3-Overo-enable-config-eeprom-to-set-u-boot-env-v.patch \
                       file://0009-OMAP3-Overo-enable-input-on-MMC1_CLK-and-MMC3_CLK-pi.patch \
                       file://0010-OMAP3-Overo-set-CONFIG_SYS_I2C_SPEED-to-400Khz.patch \
                       file://0011-OMAP3-trim-excessively-long-delays-in-i2c-driver.patch \
                       file://0012-OMAP3-Overo-allow-expansion-boards-with-any-vendor-I.patch \
                       file://0013-OMAP3-Overo-change-address-of-expansion-eeprom-to-0x.patch \
                       file://0014-OMAP3-board.c-don-t-attempt-to-set-up-second-RAM-ban.patch \
                       file://0015-OMAP3-mem.c-enhance-the-RAM-test.patch \
                       file://0016-env_nand.c-fail-gracefully-if-no-nand-is-present.patch \
                       file://0017-OMAP3-add-definitions-to-support-sysinfo-cpu-and-cpu.patch \
                       file://0018-OMAP3-sys_info-update-cpu-detection-for-36XX-37XX.patch \
                       file://0019-OMAP3-clocks-update-clock-setup-for-36XX-37XX.patch \
                       file://0020-OMAP3-beagle-add-support-for-Beagle-xM.patch \
                       file://0021-OMAP3-Beagle-Overo-remove-omapfb.debug-y-from-defaul.patch \
                       file://0022-OMAP3-beagle-implement-expansionboard-detection-base.patch \
                       file://0023-beagleboard-display-message-about-I2C-errors-being-e.patch \
                       file://0024-beagleboard-fix-TCT-expansionboard-IDs.patch \
                       file://0025-Add-DSS-driver-for-OMAP3.patch \
                       file://0026-Enable-DSS-driver-for-Beagle.patch \
                       file://0027-beagleboardXM-don-t-set-mpurate-on-xM-in-bootargs.patch \
                       file://0028-OMAP3-fix-and-clean-up-L2-cache-enable-disable-funct.patch \
                       file://0029-OMAP3-convert-setup_auxcr-to-pure-asm.patch \
                       file://0030-OMAP3-apply-Cortex-A8-errata-workarounds-only-on-aff.patch \
                       file://0031-OMAP3-beagle-add-more-expansionboards-based-on-http-.patch \
                       file://0032-OMAP3-beagle-set-mpurate-to-600-for-revB-and-revC1-3.patch \
                       file://0033-OMAP3-beagle-prettify-expansionboard-message-a-bit.patch \
                       file://0034-OMAP3-beagle-add-pinmux-for-Tincantools-Trainer-expa.patch \
                       file://0035-OMAP3-Beagle-set-mpurate-to-1000-for-xM.patch \
                       file://0036-OMAP3-Beagle-decrease-bootdelay-to-3-use-VGA-for-def.patch \
                       file://0037-OMAP3-beagle-pass-expansionboard-name-in-bootargs.patch \
                       file://0038-Added-configurations-for-xM-Rev-A-board.patch \
                       file://0039-OMAP3-beagle-setenv-beaglerev-for-AxBx-Cx-xMA-for-be.patch \
                       file://0001-OMAP-mmc-add-support-for-second-and-third-mmc-chan.patch \
                       file://0001-OMAP3-Beagle-enable-support-for-second-and-third-m.patch \
                       file://0038-BeagleBoard-Added-LED-driver.patch \
                       file://0039-Add-led-command.patch \
                       file://0041-BeagleBoard-Enabled-LEDs.patch \
                       file://0042-BeagleBoard-New-command-for-status-of-USER-button.patch \
                       file://0043-BeagleBoard-Add-CONFIG_SYS_MEMTEST_SCRATCH.patch \
                       file://0044-Beagleboard-Adjust-boot.patch \
                       file://0045-BeagleBoard-Enable-pullups-on-i2c2.patch \
                       file://0046-BeagleBoard-Add-camera-to-default-bootargs.patch \
                       file://0001-BeagleBoard-move-ramdisk-parameters.patch \
                       file://fw_env.config \
"
SRCREV_beagleboard = "ca6e1c136ddb720c3bb2cc043b99f7f06bc46c55"
PV_beagleboard = "2010.03+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_omap3evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
    file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_omap3evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_omap3evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_am37x-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
    file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_am37x-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_am37x-evm = "2009.11+${PR}+gitr${SRCREV}"

SRC_URI_omap3-touchbook = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw_env.config \
                 file://dss2.patch \
                 file://600mhz.patch \
                 file://new-pinmux.patch \
                 file://spi3.patch \
                 file://spi4.patch \
                 file://headphone.patch \
                 file://power.patch \
                 file://ai-logo.patch \
                 file://mmcinit.patch \
                 file://touchbook-config.patch \
                 file://dont-inline-weak-symbols.patch \
"
SRCREV_omap3-touchbook = "d363f9cb0918a1b6b92e2e20d01543d0c4f53274"
PV_omap3-touchbook = "2009.05+${PR}+gitr${SRCREV}"


# hawkboard - master branch (hawk still .07beta)
SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRC_URI_hawkboard         += "file://dont-inline-weak-symbols.patch"
SRCREV_hawkboard           = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_hawkboard               = "2009.08+gitr${SRCREV}"


S = "${WORKDIR}/git"
