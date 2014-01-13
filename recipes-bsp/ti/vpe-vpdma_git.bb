DESCRIPTION = "VPE VPDMA firmware and test program"

DEPENDS += "virtual/kernel"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=74d2f71d8898c54e3d1c9d0058c484aa"

COMPATIBLE_MACHINE = "dra7xx-evm"

PV = "1b8"
PR = "r0"

SRCREV = "24a5487ec13bf560f0e7fb24a9d4747f9f358be2"
BRANCH ?= "master"

SRC_URI = "git://git.ti.com/vpe_tests/vpe_tests.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

# The test application needs additional include headers from the kernel
EXTRA_OEMAKE = 'KDIR="${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include"'

do_install() {
    oe_runmake DESTDIR="${D}" install
}

# Separate the firmware into it's own package.
PACKAGES =+ "${PN}-fw"
FILES_${PN}-fw += "${base_libdir}/firmware"
