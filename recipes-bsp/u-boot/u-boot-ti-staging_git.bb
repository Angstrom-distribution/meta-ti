require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=bc069111b5e5b1ed8bed98ae73b596ec"

PV = "2013.07+2013.10-rc4"
PR = "r0+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "master"

SRCREV = "0c5274e6f3231a3a28dafc1204b3f71a3534c520"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"
