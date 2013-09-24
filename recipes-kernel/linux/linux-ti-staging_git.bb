SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_ti33x += "am33x-cm3 am33x-cm3-initscript"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "am335x-evm.dtb am335x-evmsk.dtb am335x-bone.dtb"
KERNEL_DEVICETREE_am437x-evm = "am43x-epos-evm.dtb"
KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb"
KERNEL_DEVICETREE_omap5-evm = "omap5-sevm.dtb omap5-uevm.dtb"
KERNEL_DEVICETREE_dra7xx-evm = "dra7-evm.dtb"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

BRANCH = "ti-linux-3.12.y"

SRCREV = "351da8b4c2ff277b2d816a2108ada357a63fadbe"
PV = "3.11+3.12-rc1"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
          "
