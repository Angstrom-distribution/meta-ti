require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for AM180x devices"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

COMPATIBLE_MACHINE = "am180x-evm"

PR = "r0"

SRC_URI = "git://arago-project.org/git/projects/u-boot-davinci.git;protocol=git;branch=${BRANCH}"

# For the am180x we want to enable all the memory on the EVM, but for other
# devices that use the DSP we do not want this change because that memory
# is used for the DSP
SRC_URI_append_am180x-evm = " file://0001-da850evm-change-default-memory-to-not-limit-at-32MB.patch"

BRANCH = "03.21.00.03"

# v2010.12_DAVINCIPSP_03.21.00.04
SRCREV = "1254a0b58d900b7035cfb36bf4e1b05dfbf09997"

UBOOT_SUFFIX = "bin"
