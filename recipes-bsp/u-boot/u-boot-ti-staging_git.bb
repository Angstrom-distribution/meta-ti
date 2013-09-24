require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=6bc50ecab884fce80cd3ef3da8852b08"

PV = "2013.07+2013.10-rc2"
PR = "r0+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "master"

SRCREV = "fb18fa95a14ae875ef0a5421cd9fecc00c7c3a4c"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
