require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for ARM MPU devices"

COMPATIBLE_MACHINE = "omap3"

DEFAULT_PREFERENCE = "-1"

PR = "r0+gitr${SRCPV}"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=${BRANCH}"

BRANCH = "AM335XPSP_04.06.00.08"

# Lock to the commit corresponding to tag "v2011.09_AM335xPSP_04.06.00.08"
SRCREV = "1e4626f0d5f3bb04ec974e76a5d9029875269d31"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
