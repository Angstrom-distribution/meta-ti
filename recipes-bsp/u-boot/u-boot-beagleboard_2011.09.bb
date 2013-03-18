require u-boot-ti.inc

PR = "r7"

SPL_BINARY = "MLO"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard)"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git \
           file://2011.09/0001-omap3-mem-Comment-enable_gpmc_cs_config-more.patch \
           file://2011.09/0002-OMAP3-Update-SDRC-dram_init-to-always-call-make_cs1_.patch \
           file://2011.09/0003-OMAP3-Add-a-helper-function-to-set-timings-in-SDRC.patch \
           file://2011.09/0004-OMAP3-Change-mem_ok-to-clear-again-after-reading-bac.patch \
           file://2011.09/0005-OMAP3-Remove-get_mem_type-prototype.patch \
           file://2011.09/0006-omap3-mem-Add-MCFG-helper-macro.patch \
           file://2011.09/0007-OMAP3-Add-optimal-SDRC-autorefresh-control-values.patch \
           file://2011.09/0008-OMAP3-Suffix-all-Micron-memory-timing-parts-with-the.patch \
           file://2011.09/0009-OMAP3-SPL-Rework-memory-initalization-and-devkit8000.patch \
           file://2011.09/0010-OMAP3-SPL-Add-identify_nand_chip-function.patch \
           file://2011.09/0011-OMAP3-Add-SPL-support-to-Beagleboard.patch \
           file://2011.09/0012-OMAP3-Add-SPL-support-to-omap3_evm.patch \
           file://2011.09/0013-AM3517-Add-SPL-support.patch \
           file://2011.09/0014-AM3517-CraneBoard-Add-SPL-support.patch \
           file://2011.09/0015-HACK-beagleboard-config-disable-cache-for-USB.patch \
           file://2011.09/0016-beagleboard-config-enable-gpio-command.patch \
           file://2011.09/0017-Increased-some-timeout-durations-for-MMC-and-EHCI.patch \
           file://2011.09/0018-beagleboard-mount-rootfs-RO-instead-of-RW-at-boot.patch \
           file://2011.09/0019-BeagleBoard-config-Really-switch-to-ttyO2.patch \
           file://2011.09/0020-beagleboard-add-support-for-TCT-Beacon-board.patch \
           file://2011.09/0021-beagleboard-add-support-for-scanning-loop-through-ex.patch \
           file://0001-config-Always-use-GNU-ld.patch \
           file://fw_env.config \
          "

SRCREV = "fdbe8b9a2d1858ba35dd6214315563ad44d4a0e3"
