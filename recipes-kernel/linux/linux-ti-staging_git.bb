SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "uImage"

inherit kernel

# This function must be here BEFORE the require of linux-dtb.inc below.
# There is a "bug" in the base kernel.bbclass that after it's do_deploy
# step it does not return back to the ${S} directory but stays in the
# DEPLOY_DIR.  However, the do_deploy_append defined in linux-dtb.inc
# assumes that it is being run in the ${S} directory.  A patch is
# being submitted to fix this issue by either changing the do_deploy
# in the kernel.bbclass to do "cd -" as the last step or to add
# "cd ${S}" as the first line of do_deploy in linux-dtb.inc and this
# function can be removed once that change is available.
# If the function is not placed BEFORE the require then the change
# directory is not appended before the linux-dtb.inc changes.
do_deploy_append() {
    cd ${S}
}

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Stage the power management firmware before building the kernel
# for ti33x SOC_FAMILY devices
DEPENDS_ti33x += "am33x-cm3"

# Default is to package all dts files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "arch/arm/boot/dts/am335x-evm.dts arch/arm/boot/dts/am335x-evmsk.dts arch/arm/boot/dts/am335x-bone.dts"
KERNEL_DEVICETREE_beaglebone = "arch/arm/boot/dts/am335x-bone.dts"

COMPATIBLE_MACHINE = "ti33x"

S = "${WORKDIR}/git"

BRANCH = "ti-linux-3.8.y"

SRCREV = "ed93a28fb0b1dc28cc252ee87f6fce3e07bf23fe"
PV = "3.8.3"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-linux-kernel/ti-linux-kernel.git;protocol=git;branch=${BRANCH} \
           file://defconfig \
          "

# Copy the am33x-cm3 firmware if it is available for ti33x SOC_FAMILY devices
do_compile_prepend_ti33x() {
    if [ -e "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" ]
    then
        cp "${STAGING_DIR_HOST}/${base_libdir}/firmware/am335x-pm-firmware.bin" "${S}/firmware"
    fi
}
