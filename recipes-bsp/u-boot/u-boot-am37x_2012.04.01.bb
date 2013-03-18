require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

COMPATIBLE_MACHINE = "am37x-evm|beagleboard"

BRANCH ?= "master"

# v2012.04.01
SRCREV = "415d386877df49eb051b85ef74fa59a16dc17c7d"

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

SPL_BINARY = "MLO"
