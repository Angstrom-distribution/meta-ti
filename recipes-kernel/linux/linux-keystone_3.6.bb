COMPATIBLE_MACHINE = "keystone"

require linux.inc

MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

PV = "3.5+3.6-rc6"

SRCREV = "2f2db618fe4dd8f37539e527480c88f6dd093e78"

SRC_URI = "git://arago-project.org/git/projects/linux-keystone.git;protocol=git \
           file://defconfig \
           "

S = "${WORKDIR}/git"
