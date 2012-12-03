COMPATIBLE_MACHINE = "keystone"

require linux.inc

MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

# The tree tends to rebase, use literal stable tags
SRCREV = "DEV.MCSDK-03.00.00.05"

SRC_URI = "git://arago-project.org/git/projects/linux-keystone.git;protocol=git \
           file://defconfig \
           "

S = "${WORKDIR}/git"
