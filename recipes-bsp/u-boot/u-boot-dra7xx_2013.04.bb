require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

COMPATIBLE_MACHINE = "dra7xx-evm"

PR = "r0+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.04+"

# This commit corresponds to ti2013.04.02 release tag
SRCREV = "e2315adf674b60132f0c5c8fe6eac5d109b81688"

SPL_BINARY = "MLO"
