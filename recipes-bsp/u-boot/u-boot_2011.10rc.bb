require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "beaglebone"
DEFAULT_PREFERENCE_beaglebone = "99"
PV = "2011.09+git"
PR = "r2"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://github.com/joelagnel/u-boot.git;protocol=git;branch=bone-bringup \
           file://0001-am335x-evm-hack-in-ethernet-rmii-clock.patch \
          "
SRCREV = "d643e691ab2055ef64f73dd70300a73e0443d1ef"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

do_deploy_append () {
    install ${S}/MLO ${DEPLOY_DIR_IMAGE}/MLO
}
