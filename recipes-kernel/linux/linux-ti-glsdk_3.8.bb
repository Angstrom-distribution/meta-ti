SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices supported by the GLSDK product"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "uImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

KERNEL_DEVICETREE_omap5-evm = "omap5-uevm.dtb"
KERNEL_DEVICETREE_dra7xx-evm = "dra7-evm.dtb"

COMPATIBLE_MACHINE = "omap-a15"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

BRANCH ?= "p-ti-glsdk-3.8.y"

SRCREV ?= "cc16f99176bf083829c028f9af5b8eb560debcc1"
PV = "3.8.13"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "d+gitr${SRCPV}"
PR = "${MACHINE_KERNEL_PR}"

SRC_URI = "git://git.omapzoom.org/kernel/omap.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
          "
