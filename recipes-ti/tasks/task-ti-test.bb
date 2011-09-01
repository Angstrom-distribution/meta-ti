DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit task

# those ones can be set in machine config to supply packages needed to get machine booting
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

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
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    "

RRECOMMENDS_${PN} = "\
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    "

