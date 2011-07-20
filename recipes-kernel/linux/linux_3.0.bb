require linux.inc

DESCRIPTION = "Linux kernel for TI processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(beagleboard)"

# Somewhere after 3.0rc7
SRCREV_pn-${PN} = "e6625fa48e6580a74b7e700efd7e6463e282810b"


# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "a"

FILESPATHPKG_prepend = "linux-3.0:"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git \
            file://beagle/0001-OMAP3-beagle-add-support-for-beagleboard-xM-revision.patch \
            file://pm-wip/cpufreq/0001-PM-OPP-introduce-function-to-free-cpufreq-table.patch \
            file://pm-wip/cpufreq/0002-OMAP-CPUfreq-ensure-driver-initializes-after-cpufreq.patch \
            file://pm-wip/cpufreq/0003-OMAP-CPUfreq-ensure-policy-is-fully-initialized.patch \
            file://pm-wip/cpufreq/0004-OMAP3-PM-CPUFreq-driver-for-OMAP3.patch \
            file://pm-wip/cpufreq/0005-OMAP-PM-CPUFREQ-Fix-conditional-compilation.patch \
            file://pm-wip/cpufreq/0006-cpufreq-fixup-after-new-OPP-layer-merged.patch \
            file://pm-wip/cpufreq/0007-OMAP-cpufreq-Split-OMAP1-and-OMAP2PLUS-CPUfreq-drive.patch \
            file://pm-wip/cpufreq/0008-OMAP2PLUS-cpufreq-Add-SMP-support-to-cater-OMAP4430.patch \
            file://pm-wip/cpufreq/0009-OMAP2PLUS-cpufreq-Fix-typo-when-attempting-to-set-mp.patch \
            file://pm-wip/cpufreq/0010-OMAP2-cpufreq-move-clk-name-decision-to-init.patch \
            file://pm-wip/cpufreq/0011-OMAP2-cpufreq-deny-initialization-if-no-mpudev.patch \
            file://pm-wip/cpufreq/0012-OMAP2-cpufreq-dont-support-freq_table.patch \
            file://pm-wip/cpufreq/0013-OMAP2-cpufreq-only-supports-OPP-library.patch \
            file://pm-wip/cpufreq/0014-OMAP2-cpufreq-put-clk-if-cpu_init-failed.patch \
            file://pm-wip/cpufreq/0015-OMAP2-cpufreq-fix-freq_table-leak.patch \
            file://pm-wip/cpufreq/0016-OMAP2-CPUfreq-Remove-superfluous-check-in-target-for.patch \
            file://pm-wip/cpufreq/0017-OMAP2-cpufreq-notify-even-with-bad-boot-frequency.patch \
            file://pm-wip/cpufreq/0018-OMAP2-cpufreq-Enable-all-CPUs-in-shared-policy-mask.patch \
            file://pm-wip/cpufreq/0019-OMAP2-CPUfreq-update-lpj-with-reference-value-to-avo.patch \
            file://for_3.1/pm-misc/0001-OMAP3-SR-disable-interrupt-by-default.patch \
            file://for_3.1/pm-misc/0002-OMAP3-SR-enable-disable-SR-only-on-need.patch \
            file://for_3.1/pm-misc/0003-OMAP3-SR-fix-cosmetic-indentation.patch \
            file://for_3.1/pm-misc/0004-OMAP3-PM-debug-remove-sleep_while_idle-feature.patch \
            file://for_3.1/pm-misc/0005-OMAP2-PM-debug-remove-register-dumping.patch \
            file://for_3.1/pm-misc/0006-OMAP3-PM-debug-remove-register-dumping.patch \
            file://for_3.1/pm-misc/0007-OMAP2-PM-fix-section-mismatch-in-pm_dbg_init.patch \
            file://defconfig"

SRC_URI_append_beagleboard = " file://logo_linux_clut224.ppm \
"

S = "${WORKDIR}/git"

