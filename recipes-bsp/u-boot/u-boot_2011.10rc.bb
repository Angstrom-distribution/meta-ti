require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "beaglebone"
DEFAULT_PREFERENCE_beaglebone = "99"
PV = "2011.09+git"
PR = "r4"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://github.com/joelagnel/u-boot.git;protocol=git;branch=bone-bringup \
           file://2011.09git/0003-am335x_evm-boot-kernel-from-ext2-filesystem.patch \
           file://2011.09git/0001-am335x_evm-reduced-bootdelay-to-1.patch \
           file://2011.09git/0002-am335x_evm-read-uEnv.txt-instead-of-boot.scr.patch \
          "
SRCREV = "fb3043c07bc05df83d38bfd2b303f2c9a96779c6"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_deploy_append () {
    install ${S}/MLO ${DEPLOY_DIR_IMAGE}/MLO
}
