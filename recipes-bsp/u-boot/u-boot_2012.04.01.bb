# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "am37x-evm|beagleboard"

PACKAGE_ARCH = "${MACHINE_ARCH}"

BRANCH ?= "master"

SRCREV = "v2012.04.01"

S = "${WORKDIR}/git"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=${BRANCH}"

# Add patches for the AMSDK
#  - 0001-omap3-beagle-add-usbethaddr....Not for Upstream
#  - 0001-OMAP3-Beagle-Set-BOOTDELAY....Pending Upstream
#  - 0002-am335x-am3517evm-beagleboard....Pending Upstream
#  - 0003-beagleboard-Load-uImage-from....Not for Upstream
#  - 0004-beagleboard-Load-uImage-to....Pending Upstream
#  - 0001-omap3_evm-Added-function....Pending Upstream
#  - 0002-omap3evm-Make-the-board....Pending Upstream
#  - 0003-beagleboard-Make-xM-rev....Pending Upstream
#  - 0001-ARM-omap3-Set-SPL-stack-size-to-8KB-image-to-54KB.patch....Upstreamed

# Add a patch to set a default usbethaddr address to enable the out of box
# experience.
SRC_URI += "file://0001-omap3_beagle-add-usbethaddr-setting-to-enable-networ.patch \
            file://0001-OMAP3-Beagle-Set-BOOTDELAY-to-3.patch \
            file://0002-am335x-am3517evm-beagleboard-am37x-Add-CONFIG_CMD_AS.patch \
            file://0003-beagleboard-Load-uImage-from-VFAT-by-default.patch \
            file://0004-beagleboard-Load-uImage-to-the-default-kernel-linux-.patch \
            file://0001-omap3_evm-Added-function-calls-to-set-volts-speed-on.patch \
            file://0002-omap3evm-Make-the-board-start-at-800MHz.patch \
            file://0003-beagleboard-Make-xM-rev-C-go-to-800MHz.patch \
            file://0001-ARM-omap3-Set-SPL-stack-size-to-8KB-image-to-54KB.patch \
            "

UBOOT_SUFFIX = "img"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
