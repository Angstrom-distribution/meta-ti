COMPATIBLE_MACHINE = "omap4430-panda"

DEFAULT_PREFERENCE = "-1"

require linux.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
#MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

#glp 1.5.4
SRCREV = "3adddccb1e296027873df5999b5917cafd62b3db"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-glp1.5.2 \
           file://defconfig \
           "

S = "${WORKDIR}/git"
