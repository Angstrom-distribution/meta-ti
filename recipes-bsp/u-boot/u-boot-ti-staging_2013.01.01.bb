require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

PR = "r2"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.01.01"

SRCREV = "9aab8612f643ab90df837e743f5435bba2ae68cf"

SPL_BINARY = "MLO"
