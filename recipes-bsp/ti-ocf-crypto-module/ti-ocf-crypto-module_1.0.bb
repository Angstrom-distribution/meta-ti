DESCRIPTION = "Builds Crypto module used by OCF-Linux driver in OpenSSL example applications"
HOMEPAGE = "https://gforge.ti.com/gf/project/arm_crypto/"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=16;md5=acc0590f80e72fd64ad5c16cad8f4f76 \
                    file://ocf_omap3_crypto.c;beginline=436;endline=438;md5=a52cad5c37c3aa3f27c6391552967304"

COMPATIBLE_MACHINE = "am37x-evm|am3517-evm"

DEPENDS += "virtual/kernel"

SRC_URI = "svn://gforge.ti.com/svn/arm_crypto/;module=trunk;protocol=https;user=anonymous;pswd=''"

#gforge source revision
SRCREV = "17"

INHIBIT_PACKAGE_STRIP = "1"

S = "${WORKDIR}/trunk"

inherit module

MACHINE_KERNEL_PR_append = "a+svnr${SRCPV}"
PR = "${MACHINE_KERNEL_PR}"

EXTRA_OEMAKE += "KERNEL_DIR=${STAGING_KERNEL_DIR}"

do_compile_prepend () {
    sed -i "s/arm-none-linux-gnueabi-/${TARGET_PREFIX}/g" ${S}/Makefile
}

do_install () {
        install -d ${D}/lib/modules/${KERNEL_VERSION}/crypto/ocf/
        install -m 0755 ${S}/ocf_omap3_cryptok.ko ${D}/lib/modules/${KERNEL_VERSION}/crypto/ocf/
}

FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/crypto/ocf/ocf_omap3_cryptok.ko"
