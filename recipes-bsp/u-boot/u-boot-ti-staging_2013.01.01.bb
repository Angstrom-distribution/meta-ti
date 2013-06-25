require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

PR = "r5+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.01.01"

# This commit corresponds to ti2013.04.00 release tag
SRCREV = "7552b4c906b0a50fbc5225dc43ed0192618e9d5d"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
