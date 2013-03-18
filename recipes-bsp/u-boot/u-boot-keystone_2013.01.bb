require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for Multi-Core BU devices"

COMPATIBLE_MACHINE = "keystone"

PR = "r2+gitr${SRCPV}"

SRC_URI = "git://arago-project.org/git/projects/u-boot-keystone.git;protocol=git;branch=${BRANCH}"

BRANCH = "master"

# DEV.MCSDK-03.00.00.07
SRCREV = "82f40e857d853165310d0753e79235aefb65d7ba"

UBOOT_SUFFIX = "bin"
