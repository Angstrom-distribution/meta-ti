require u-boot-ti.inc

SPL_BINARY = "MLO"

PR = "r8"

COMPATIBLE_MACHINE = "(beagleboard|pandaboard|am3517-evm|am37x-evm|omap3evm)"

# Non-omap4 platforms need outer cache turned on
CACHEFIX = "file://2011.12/0008-Revert-armv7-disable-L2-cache-in-cleanup_before_linu.patch"
CACHEFIX_omap4 = ""

# File is board-specific, only copy when it will be correct.
FWENV_beagleboard = "file://fw_env.config"
FWENV = ""

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git \
           file://2011.12/0001-beagleboard-mount-rootfs-RO-instead-of-RW-at-boot.patch \
           file://2011.12/0002-beagleboard-add-support-for-TCT-Beacon-board.patch \
           file://2011.12/0003-beagleboard-add-support-for-scanning-loop-through-ex.patch \
           file://2011.12/0004-omap4-common-mount-root-RO.patch \
           file://2011.12/0005-omap4-common-use-ext4-by-default.patch \
           file://2011.12/0006-OMAP-MMC-Add-delay-before-waiting-for-status.patch \
           file://2011.12/0007-config-Always-use-GNU-ld.patch \
           ${CACHEFIX} \
           file://2011.12/0009-Beagleboard-Correct-memory-size-on-rev-C4.patch \
           file://2011.12/0010-OMAP3-Correct-get_sdr_cs_offset-mask.patch \
           file://2011.12/0011-ext2load-increase-read-speed.patch \
           file://2011.12/0012-ext4fs-ls-load-support.patch \
           file://2011.12/0013-beagleboard-switch-mmcroots-to-ext4.patch \
           ${FWENV} \
          "

# v2011.12 tag
SRCREV = "cba9a894fdb1cb49b60fcd1d1d6919cbd7995dd5"

RRECOMMENDS_${PN}_beagleboard = "u-boot-fw-utils"
