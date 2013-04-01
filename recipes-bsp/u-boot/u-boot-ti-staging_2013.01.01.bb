require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

PR = "r1"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.01.01"

SRCREV = "24043d3b0b6d54b4f73263903499fd3e63980830"

SPL_BINARY = "MLO"
