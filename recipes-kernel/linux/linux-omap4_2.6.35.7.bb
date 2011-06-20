COMPATIBLE_MACHINE = "omap4430-panda"

# Backport for L27.x, needs loads of testing
DEFAULT_PREFERENCE = "-1"

require linux.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
MACHINE_KERNEL_PR_append = "b"

CORTEXA8FIXUP = "no"

SRCREV = "da1fad8254e6950e8b3a2fb2d610f11a5443b536"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-L24.13 \
           file://0001-ARM-6329-1-wire-up-sys_accept4-on-ARM.patch \
           file://0002-cgroupfs-create-sys-fs-cgroup-to-mount-cgroupfs-on.patch \
           file://defconfig \
           "

S = "${WORKDIR}/git"
