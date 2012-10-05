COMPATIBLE_MACHINE = "omap4"

require linux.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

# ti-ubuntu-3.4-1487.6
SRCREV = "c34a43ec74168b892a948b45695486f1a3d700af"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-3.4-1487 \
           file://defconfig \
           "

S = "${WORKDIR}/git"
