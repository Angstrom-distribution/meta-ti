require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

COMPATIBLE_MACHINE = "ti33x"

DEFAULT_PREFERENCE = "-1"

PR = "r6+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH}"

# This version of u-boot is meant for 3.2 kernel which doesn't support device tree.
BRANCH = "ti-u-boot-2013.01.01-amsdk-06.00.00.00"

SRCREV = "540aa6fbb0c9274bda598f7e8819ed28259cad6b"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
