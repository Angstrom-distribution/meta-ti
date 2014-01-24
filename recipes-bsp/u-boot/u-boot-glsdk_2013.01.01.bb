require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices supported by the GLSDK product"

PR = "r1+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.omapzoom.org/repo/u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "p-ti-u-boot-2013.04"

SRCREV = "76447484441a4b8e00840a2bde74e66dbac9e631"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
