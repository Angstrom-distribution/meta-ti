require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

COMPATIBLE_MACHINE = "dra7xx-evm"

PR = "r1+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.04+"

# This commit corresponds to ti2013.04.02 release tag
SRCREV = "ca435c914e069f5b74f05f667e2064784943a0ac"

SPL_BINARY = "MLO"
