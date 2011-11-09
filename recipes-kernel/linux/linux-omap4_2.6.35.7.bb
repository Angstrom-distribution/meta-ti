COMPATIBLE_MACHINE = "omap4430-panda"

require linux.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
MACHINE_KERNEL_PR_append = "c"

CORTEXA8FIXUP = "no"

#L24.15 + glp1.4
SRCREV = "9ceafcf4e34ca25a612c7779104386a27316e962"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=glp1.4 \
           file://0001-ARM-6329-1-wire-up-sys_accept4-on-ARM.patch \
           file://0002-cgroupfs-create-sys-fs-cgroup-to-mount-cgroupfs-on.patch \
           file://defconfig \
           "

S = "${WORKDIR}/git"
