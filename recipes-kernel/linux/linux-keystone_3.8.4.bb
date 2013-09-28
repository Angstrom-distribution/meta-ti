SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI Keystone devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

KERNEL_DEVICETREE_keystone-evm = "k2hk-evm.dtb"

COMPATIBLE_MACHINE = "keystone"

S = "${WORKDIR}/git"

BRANCH = "sept-2013/master"

# This commit corresponds to K2_LINUX_03.08.04_13.09 tag
SRCREV = "20a48dc5309c4434650baef2b6072b5f1016f946"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a+gitr${SRCPV}"
PR = "${MACHINE_KERNEL_PR}"

SRC_URI = "git://arago-project.org/git/projects/linux-keystone.git;protocol=git;branch=${BRANCH}\
           file://defconfig\
          "
