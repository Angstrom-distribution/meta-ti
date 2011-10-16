require u-boot.inc

PR = "r4"

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard)"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git \
           file://2011.09/0001-HACK-beagleboard-config-disable-cache-for-USB.patch \
           file://2011.09/0002-beagleboard-config-enable-gpio-command.patch \
           file://2011.09/0003-Increased-some-timeout-durations-for-MMC-and-EHCI.patch \
           file://2011.09/0001-beagleboard-add-support-for-TCT-Beacon-board.patch \
           file://2011.09/0001-beagleboard-add-support-for-scanning-loop-through-ex.patch \
           file://2011.09/0002-beagleboard-switch-to-ttyO2.patch \
           file://2011.09/0003-beagleboard-mount-rootfs-RO-instead-of-RW-at-boot.patch \
           file://fw_env.config \
          "

SRCREV = "1d5e7fb403257d62f0f2419cb83fdf6b0f02f215"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"
