SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "uImage"

inherit kernel
require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Stage the power management firmware before building the kernel
DEPENDS += "am33x-cm3"

KERNEL_DEVICETREE_am335x-evm = "arch/arm/boot/dts/am335x-evm.dts"
KERNEL_DEVICETREE_beaglebone = "arch/arm/boot/dts/am335x-bone.dts"

COMPATIBLE_MACHINE = "ti33x"

S = "${WORKDIR}/git"

BRANCH = "ti-linux-3.8.y"

SRCREV = "d26595a42220789b81a9d243e2fc0837c7776360"
PV = "3.8.2"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "b+gitr${SRCPV}"

SRC_URI = "git://gitorious.ti.com/ti-linux-kernel/ti-linux-kernel.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
          "

# Copy the am33x-cm3 firmware if it is available
do_compile_prepend() {
    if [ -e "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" ]
    then
        cp "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" "${S}/firmware"
    fi
}
