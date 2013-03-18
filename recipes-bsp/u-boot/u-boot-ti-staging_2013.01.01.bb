require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

PR = "r1"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "ti-u-boot-2013.01.01"

SRCREV = "2309e3268c52c844f8924711b4fd7a9693f5b747"

SPL_BINARY = "MLO"
