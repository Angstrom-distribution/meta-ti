require u-boot-ti.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "(ti33x)"

DEFAULT_PREFERENCE_ti33x = "99"

PV = "2011.09+git"
PR = "r30"

SPL_BINARY = "MLO"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=master \
           file://2011.09git/0001-am335x_evm-add-option-to-boot-kernel-from-boot-in-ex.patch \
           file://2011.09git/0002-am335x_evm-set-bootdelay-to-1.patch \
           file://2011.09git/0003-am335x-evm-make-MMC-rootfs-RO-on-boot-so-fsck-works.patch \
           file://2011.09git/0004-am335x_evm-switch-to-ext4.patch \
           file://2011.09git/0005-am335x-evm-enable-i2c2-pinmux-for-beaglebone.patch \
           file://2011.09git/0006-ext2load-increase-read-speed.patch \
           file://2011.09git/0007-am335x-evm-fix-ext2load-and-specify-partition-for-bo.patch \
           file://2011.09git/0008-am335x-evm-load-uImage-from-boot-instead-of-VFAT.patch \
           file://2011.09git/0009-ext4fs-ls-load-support.patch \
           file://2011.09git/0010-am335x-switch-to-ext4-mode.patch \
           file://0001-config-Always-use-GNU-ld.patch \
          "

SRCREV = "dc52533ccff00a12761f793d66b39e4f6a4a3bba"
