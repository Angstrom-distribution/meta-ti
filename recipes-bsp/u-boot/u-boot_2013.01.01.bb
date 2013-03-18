require u-boot-ti.inc

DESCRIPTION = "Mainline u-boot bootloader"

DEFAULT_PREFERENCE = "-1"

PR = "r1"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "u-boot-2013.01.y"

SRCREV = "e8ae0fa5edd152b2b29c470b88429be4cdcd2c46"

SPL_BINARY = "MLO"
