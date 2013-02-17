DESCRIPTION = "Linux 3.3 stable kernel release"
SECTION = "kernel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "beagleboard"

inherit kernel

KERNEL_IMAGETYPE = "uImage"

# The main PR is now using MACHINE_KERNEL_PR, for beagleboard see
# conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "a+gitr${SRCREV}"

BRANCH = "linux-3.3.y"
SRCREV = "v3.3.7"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${BRANCH} \
           file://defconfig"

# These are patches that are making their way upstream or are pulled back
# from upstream trees to make the stable kernel work without regressions.
# These patches should clear out when moving to the next stable kernel
# minor version.  i.e. 3.y.
SRC_URI_append_beagleboard = " file://0001-ARM-OMAP-Cleanup-Beagleboard-DVI-reset-gpio.patch \
                               file://0001-ARM-OMAP2-UART-Fix-incorrect-population-of-default-u.patch \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "${PARALLEL_MAKE}"

# Create the uImage symlink in /boot since by default beagleboard looks into
# the /boot directory for the uImage file instead of the first partition.
do_install_append_beagleboard() {
    cd ${D}/${KERNEL_IMAGEDEST} && ln -sf uImage-${KERNEL_VERSION} uImage
}
