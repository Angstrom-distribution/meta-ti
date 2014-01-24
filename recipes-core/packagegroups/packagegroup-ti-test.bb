DESCRIPTION = "Extended task to get System Test specific apps"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

TEST = "\
    bonnie++ \
    hdparm \
    iozone3 \
    iperf \
    lmbench \
    rt-tests \
    evtest \
    bc \
    memtester \
    "

TI_TEST = "\
    "

RDEPENDS_${PN} = "\
    ${TEST} \
    ${TI_TEST} \
    "
