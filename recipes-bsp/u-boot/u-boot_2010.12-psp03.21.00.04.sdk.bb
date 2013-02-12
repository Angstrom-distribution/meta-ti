# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "u-boot bootloader for DaVinci devices"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

COMPATIBLE_MACHINE = "am180x-evm"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0"

SRC_URI = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=${BRANCH}"

# For the am180x we want to enable all the memory on the EVM, but for other
# devices that use the DSP we do not want this change because that memory
# is used for the DSP
SRC_URI_append_am180x-evm = " file://0001-da850evm-change-default-memory-to-not-limit-at-32MB.patch"

BRANCH = "03.21.00.03"

# Use literal tags in SRCREV, when available, instead of commit IDs
SRCREV = "v2010.12_DAVINCIPSP_03.21.00.04"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "bin"
