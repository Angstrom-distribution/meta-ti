require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=6bc50ecab884fce80cd3ef3da8852b08"

PV = "2013.07+2013.10-rc1"
PR = "r0+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "master"

SRCREV = "39bc12ddc36c9e30199471da0f3a929b178a04b2"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
