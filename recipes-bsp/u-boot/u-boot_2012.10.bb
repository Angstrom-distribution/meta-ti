# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# Reset OEMAKE. Current u-boot.inc sets -02 which breaks this version of u-boot's build.
# This issue was fixed in oe-core master by removing the -02 statement.
EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "ti33x|omap3"

DEFAULT_PREFERENCE = "-1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r7+gitr${SRCPV}"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=${BRANCH} \
"

BRANCH = "amsdk-05.06.00.00"

SRCREV = "6536bfa6b7f16bb49fdea8c72959e3ed54e77a82"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
