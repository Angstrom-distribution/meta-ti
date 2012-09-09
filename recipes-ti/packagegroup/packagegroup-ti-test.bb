DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit allarch packagegroup

TEST = "\
    bonnie++ \
    hdparm \
    iozone3 \
    iperf \
    lmbench \
    rt-tests \
    "

TI_TEST = "\
    ltp-ddt \
    "

RDEPENDS_${PN} = "\
    ${TEST} \
    ${TI_TEST} \
    "

