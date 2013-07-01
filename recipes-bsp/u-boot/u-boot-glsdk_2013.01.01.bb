require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices supported by the GLSDK product"

PR = "r0+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.ti.com/glsdk/glsdk-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "master"

SRCREV = "81836e8cc84bd6523d9a4e187965dcd1633c4bc9"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
