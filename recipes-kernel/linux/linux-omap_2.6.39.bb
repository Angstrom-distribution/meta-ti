require multi-kernel.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
SRCREV_pn-${PN} = "v2.6.39"
MACHINE_KERNEL_PR_append = "a"

FILESPATHPKG_prepend = "linux-omap-2.6.39:"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/tmlind/linux-omap-2.6.git;protocol=git \
            file://defconfig"

SRC_URI_append = " \
           file://sakoman/0001-OMAP-DSS2-DSI-fix-use_sys_clk-highfreq.patch \
           file://sakoman/0002-OMAP-DSS2-DSI-fix-dsi_dump_clocks.patch \
           file://sakoman/0003-OMAP2PLUS-DSS2-Fix-Return-correct-lcd-clock-source-f.patch \
           file://sakoman/0004-OMAP-DSS-DSI-Fix-DSI-PLL-power-bug.patch \
           file://sakoman/0005-OMAP-DSS2-fix-panel-Kconfig-dependencies.patch \
           file://sakoman/0006-OMAP-DSS2-add-bootarg-for-selecting-svideo-or-compos.patch \
           file://sakoman/0007-video-add-timings-for-hd720.patch \
           file://sakoman/0008-drivers-net-smsc911x-return-ENODEV-if-device-is-not-.patch \
           file://sakoman/0009-drivers-input-touchscreen-ads7846-return-ENODEV-if-d.patch \
           file://sakoman/0010-Revert-omap2_mcspi-Flush-posted-writes.patch \
           file://sakoman/0011-Revert-omap_hsmmc-improve-interrupt-synchronisation.patch \
           file://sakoman/0012-Don-t-turn-SDIO-cards-off-to-save-power.-Doing-so-wi.patch \
           file://sakoman/0013-Enable-the-use-of-SDIO-card-interrupts.patch \
           file://sakoman/0014-soc-codecs-Enable-audio-capture-by-default-for-twl40.patch \
           file://sakoman/0015-soc-codecs-twl4030-Turn-on-mic-bias-by-default.patch \
           file://sakoman/0016-RTC-add-support-for-backup-battery-recharge.patch \
           file://sakoman/0017-ARM-OMAP2-mmc-twl4030-move-clock-input-selection-pri.patch \
           file://sakoman/0018-Add-power-off-support-for-the-TWL4030-companion.patch \
           file://sakoman/0019-ARM-OMAP-Add-twl4030-madc-support-to-Overo.patch \
           file://sakoman/0020-Enabling-Hwmon-driver-for-twl4030-madc.patch \
           file://sakoman/0021-mfd-twl-core-enable-madc-clock.patch \
           file://sakoman/0022-rtc-twl-Switch-to-using-threaded-irq.patch \
           file://sakoman/0023-ARM-OMAP-automatically-set-musb-mode-in-platform-dat.patch \
           file://sakoman/0024-omap-mmc-Adjust-dto-to-eliminate-timeout-errors.patch \
           file://sakoman/0025-omap-Fix-mtd-subpage-read-alignment.patch \
           file://sakoman/0026-mtd-nand-omap2-Force-all-buffer-reads-to-u32-alignme.patch \
           file://sakoman/0027-omap-nand-fix-subpage-ecc-issue-with-prefetch.patch \
           file://sakoman/0028-OMAP-Overo-Add-support-for-spidev.patch \
           file://sakoman/0029-unionfs-Add-support-for-unionfs-2.5.9.patch \
           file://sakoman/0030-omap-Change-omap_device-activate-latency-messages-fr.patch \
           \
           file://beagle/0001-OMAP3-beagle-add-support-for-beagleboard-xM-revision.patch \
           file://beagle/0002-OMAP3-beagle-add-support-for-expansionboards.patch \
           file://beagle/0003-OMAP3-beagle-add-MADC-support.patch \
           \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0001-OMAP-CPUfreq-ensure-driver-initializes-after-cpufreq.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0002-OMAP-CPUfreq-ensure-policy-is-fully-initialized.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0003-OMAP3-PM-CPUFreq-driver-for-OMAP3.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0004-OMAP-PM-CPUFREQ-Fix-conditional-compilation.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0005-cpufreq-fixup-after-new-OPP-layer-merged.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0006-OMAP-cpufreq-Split-OMAP1-and-OMAP2PLUS-CPUfreq-drive.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0007-OMAP2PLUS-cpufreq-Add-SMP-support-to-cater-OMAP4430.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq/0008-OMAP2PLUS-cpufreq-Fix-typo-when-attempting-to-set-mp.patch \
           \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-hotplug/0001-cpufreq-helpers-for-walking-the-frequency-table.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-hotplug/0002-cpufreq-introduce-hotplug-governor.patch \
           \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0001-OMAP2-cpufreq-free-up-table-on-exit.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0002-OMAP2-cpufreq-handle-invalid-cpufreq-table.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0003-OMAP2-cpufreq-minor-comment-cleanup.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0004-OMAP2-cpufreq-use-clk_init_cpufreq_table-if-OPPs-not.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0005-OMAP2-cpufreq-use-cpufreq_frequency_table_target.patch \
           file://pm/linux-omap-2.6.39-ti-pm-wip-cpufreq-fixes/0006-OMAP2-cpufreq-fix-freq_table-leak.patch \
           "

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

