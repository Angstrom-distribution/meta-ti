require linux.inc

DESCRIPTION = "Linux kernel for AM335x processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "beaglebone"

SRCREV = "d3a2a2a1426ec59fcba80bf400e3261b2a3108c2"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "e+gitr${SRCREV}"

SRC_URI = "git://github.com/joelagnel/linux-omap-2.6.git;branch=kernel-3.1-psp \
           file://0001-f_rndis-HACK-around-undefined-variables.patch \
           file://0002-Enable-bit15-in-the-maccontrol-register-for-100Mbps.patch \
           file://0001-Add-minimal-hacked-beaglebone-support-to-the-board-f.patch \
           file://0001-am335x-evm-hack-in-LED-support-for-beaglebone.patch \
           file://defconfig"

S = "${WORKDIR}/git"


