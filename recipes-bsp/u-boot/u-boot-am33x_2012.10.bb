require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

COMPATIBLE_MACHINE = "ti33x|omap3"

DEFAULT_PREFERENCE = "-1"

PR = "r7+gitr${SRCPV}"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=${BRANCH}"

BRANCH = "amsdk-05.06.00.00"

SRCREV = "6536bfa6b7f16bb49fdea8c72959e3ed54e77a82"

SPL_BINARY = "MLO"
