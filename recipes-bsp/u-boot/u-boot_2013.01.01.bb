require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "Mainline u-boot bootloader"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

DEFAULT_PREFERENCE = "-1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r1"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "u-boot-2013.01.y"

SRCREV = "e8ae0fa5edd152b2b29c470b88429be4cdcd2c46"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"
SPL_BINARY = "MLO"
