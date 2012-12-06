require linux.inc

DESCRIPTION = "Linux kernel for TI processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"

PV = "3.2.28"
# v3.2.28 tag
SRCREV_pn-${PN} = "1f873aca1c7aa7a574b276c040d304d16f1dbfa4"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "b"

FILESPATH =. "${FILE_DIRNAME}/linux-mainline-3.2:${FILE_DIRNAME}/linux-mainline-3.2/${MACHINE}:"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.2.y;protocol=git \
            file://distro/0001-kbuild-deb-pkg-set-host-machine-after-dpkg-gencontro.patch \
            file://omap_cpufreq/0001-cpufreq-OMAP-cleanup-for-multi-SoC-support-move-into.patch \
            file://omap_cpufreq/0002-cpufreq-OMAP-Add-SMP-support-for-OMAP4.patch \
            file://omap_cpufreq/0003-cpufreq-OMAP-Enable-all-CPUs-in-shared-policy-mask.patch \
            file://omap_cpufreq/0004-cpufreq-OMAP-notify-even-with-bad-boot-frequency.patch \
            file://omap_cpufreq/0005-cpufreq-OMAP-move-clk-name-decision-to-init.patch \
            file://omap_cpufreq/0006-cpufreq-OMAP-deny-initialization-if-no-mpudev.patch \
            file://omap_cpufreq/0007-cpufreq-OMAP-dont-support-freq_table.patch \
            file://omap_cpufreq/0008-cpufreq-OMAP-only-supports-OPP-library.patch \
            file://omap_cpufreq/0009-cpufreq-OMAP-put-clk-if-cpu_init-failed.patch \
            file://omap_cpufreq/0010-cpufreq-OMAP-fix-freq_table-leak.patch \
            file://omap_cpufreq/0011-cpufreq-OMAP-fixup-for-omap_device-changes-include-l.patch \
            file://micrel_zippy2/0001-ksz8851-eeprom-93cx6-add-drive_data.patch \
            file://micrel_zippy2/0002-ksz8851-eeprom-93cx6-add-eeprom_93cx6_write.patch \
            file://micrel_zippy2/0003-ksz8851-read_mac_addr.patch \
            file://micrel_zippy2/0004-ksz8851-93cx6-eeprom-access.patch \
            file://micrel_zippy2/0005-ks8851.h-it-helps-to-include-the-include-file.patch \
            file://micrel_zippy2/0006-ksz8851-move-to-header.patch \
            file://micrel_zippy2/0007-ksz8851-move-more-to-header.patch \
            file://micrel_zippy2/0008-ksz8851-share-ks8851_tx_hdr-union.patch \
            file://micrel_zippy2/0009-ksz8851-add-is_level_irq.patch \
            file://micrel_zippy2/0010-ksz8851-turn-off-hardware-interrupt-druing-receive-p.patch \
            file://micrel_zippy2/0011-ksz8851-make-sure-is-awake-before-writing-mac.patch \
            file://micrel_zippy2/0012-ksz8851-add-mutex-lock-unlock-to-ks.patch \
            file://micrel_zippy2/0013-ksz8851-add-ks8851_tx_check.patch \
            file://micrel_zippy2/0014-ksz8851-move-ks8851_set_powermode.patch \
            file://sakoman/0001-OMAP-DSS2-add-bootarg-for-selecting-svideo.patch \
            file://sakoman/0002-video-add-timings-for-hd720.patch \
            file://sakoman/0003-omap-mmc-Adjust-dto-to-eliminate-timeout-errors.patch \
            file://beagle/0001-expansion-add-buddy-param-for-expansionboard-names.patch \
            file://beagle/0002-expansion-add-mmc-regulator-and-ds1307-rtc.patch \
            file://beagle/0003-expansion-add-zippy.patch \
            file://beagle/0004-expansion-add-zippy2.patch \
            file://beagle/0005-expansion-add-trainer.patch \
            file://beagle/0006-expansion-add-ulcd.patch \
            file://beagle/0007-beagleboard-reinstate-usage-of-hi-speed-PLL-divider.patch \
            file://beagle/0008-Turn-on-the-USB-regulator-on-Beagle-xM-explicitly.patch \
            file://beagle/0009-meego-modedb-add-Toshiba-LTA070B220F-800x480-support.patch \
            file://beagle/0010-beagleboard-fix-uLCD7-support.patch \
            file://beagle/0011-default-to-fifo-mode-5-for-old-musb-beagles.patch \
            file://beagle/0012-backlight-Add-TLC59108-backlight-control-driver.patch \
            file://beagle/0013-tlc59108-adjust-for-beagleboard-uLCD7.patch \
            file://beagle/0014-expansion-add-wifi.patch \
            file://beagle/0015-ASoC-omap-add-MODULE_ALIAS-to-mcbsp-and-pcm-drivers.patch \
            file://beagle/0016-ASoC-omap-convert-per-board-modules-to-platform-driv.patch \
            file://devkit8000/0001-arm-omap-devkit8000-for-lcd-use-samsung_lte_panel.patch \
            file://touchbook/0001-omap3-touchbook-remove-mmc-gpio_wp.patch \
            file://touchbook/0002-omap3-touchbook-drop-u-boot-readonly.patch \
            file://panda/0001-panda-fix-wl12xx-regulator.patch \
            file://panda/0002-panda-enable-bluetooth.patch \
            file://panda/0003-ti-st-st-kim-fixing-firmware-path.patch \
            file://omap_fixes/0001-omap3-Increase-limit-on-bootarg-mpurate.patch \
            file://omap_fixes/0002-ARM-OMAP-AM3517-3505-fix-crash-on-boot-due-to-incorr.patch \
            file://omap_fixes/0003-ARM-OMAP4-hwmod-Don-t-wait-for-the-idle-status-if-mo.patch \
            file://omap_fixes/0004-ARM-OMAP4-clock-Add-CPU-local-timer-clock-node.patch \
            file://omap_fixes/0005-ARM-OMAP3-hwmod-data-disable-multiblock-reads-on-MMC.patch \
            file://omap_fixes/0006-OMAP-HWMOD-add-es3plus-to-am36xx-am35xx.patch \
            file://sgx/0001-Revert-OMAP-DSS2-remove-update_mode-from-omapdss-v3.2.patch \
            file://led/0001-leds-heartbeat-stop-on-shutdown-reboot-or-panic.patch \
            file://libertas/0001-USB-convert-drivers-net-to-use-module_usb_driver.patch \
            file://libertas/0002-net-fix-assignment-of-0-1-to-bool-variables.patch \
            file://libertas/0003-switch-debugfs-to-umode_t.patch \
            file://libertas/0004-drivers-net-Remove-unnecessary-k.alloc-v.alloc-OOM-m.patch \
            file://libertas/0005-libertas-remove-dump_survey-implementation.patch \
            file://libertas/0007-wireless-libertas-remove-redundant-NULL-tests-before.patch \
            file://libertas/0008-libertas-fix-signedness-bug-in-lbs_auth_to_authtype.patch \
            file://libertas/0009-drivers-net-wireless-libertas-if_usb.c-add-missing-d.patch \
            file://libertas/0010-libertas-Firmware-loading-simplifications.patch \
            file://libertas/0011-libertas-harden-up-exit-paths.patch \
            file://libertas/0012-libertas-add-asynchronous-firmware-loading-capabilit.patch \
            file://libertas/0013-libertas-SDIO-convert-to-asynchronous-firmware-loadi.patch \
            file://libertas/0014-libertas-USB-convert-to-asynchronous-firmware-loadin.patch \
            file://libertas/0015-libertas-CS-convert-to-asynchronous-firmware-loading.patch \
            file://libertas/0016-libertas-add-missing-include.patch \
            file://libertas/0017-remove-debug-msgs-due-to-missing-in_interrupt.patch \
           \
            file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

# Sadly perf is broken:
#| util/hist.c: In function '__hists__add_entry':
#| util/hist.c:240:27: error: invalid type argument of '->' (have 'struct hist_entry')
#| util/hist.c:241:23: error: invalid type argument of '->' (have 'struct hist_entry')
do_compile_perf() {
	:
}

do_install_perf() {
	:
}
