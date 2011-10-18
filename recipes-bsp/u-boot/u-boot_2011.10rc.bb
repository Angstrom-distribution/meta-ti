require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "(ti33x)"
DEFAULT_PREFERENCE_ti33x = "99"
PV = "2011.09+git"
PR = "r11"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://arago-project.org/git/projects/u-boot-am33x.git;protocol=git;branch=int_am335xpsp_04.06.00.01-v2011.09-for-sdk-05.03.00.00 \
           file://2011.09git/0001-am335x_evm-boot-kernel-from-ext2-3-filesystem.patch \
           file://2011.09git/0002-am335x_evm-set-bootdelay-to-0.patch \
           file://2011.09git/0003-am335x-evm-make-rootfs-RO-on-boot.patch \
           file://2011.09git/0001-mach-types-Add-new-beaglebone-machine-type.patch \
           file://2011.09git/0002-evm-If-beaglebone-is-detected-pass-the-MACH_TYPE_BEA.patch \
           file://2011.09git/0003-am335x_evm-single-byte-address-EEPROM-for-board-iden.patch \
           file://2011.09git/0004-am335x-evm-fall-back-to-bone-if-header.config-is-emp.patch \
          "

SRCREV = "4b41772ae4ef8fbea0b3e93af169a115e3ad6d12"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_deploy_append () {
    install ${S}/MLO ${DEPLOY_DIR_IMAGE}/MLO
}
