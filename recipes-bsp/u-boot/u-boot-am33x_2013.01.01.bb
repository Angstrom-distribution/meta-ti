require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

COMPATIBLE_MACHINE = "ti33x"

DEFAULT_PREFERENCE = "-1"

PR = "r5+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

# This version of u-boot is meant for 3.2 kernel which doesn't support device tree.
BRANCH = "ti-u-boot-2013.01.01-amsdk-05.07.00.00"

# Commit corresponds to tag "v2013.01.01_amsdk-05.07.00.00"
SRCREV = "8eb15a787c558fee98b0fa2a66ff0849c732edcc"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
