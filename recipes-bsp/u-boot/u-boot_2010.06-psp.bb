require u-boot.inc

FILESPATHPKG =. "u-boot-psp-git:"

COMPATIBLE_MACHINE = "am387x-evm|am389x-evm|c6a814x-evm|c6a816x-evm|dm814x-evm"

SRC_URI = "git://arago-project.org/git/projects/u-boot-omap3.git;branch=${BRANCH};protocol=git"

BRANCH_ti814x = "ti81xx-master"
SRCREV_pn-${PN}_ti814x = "5fcf46a405fe8e8a59a04d3cebdafd39ac0c4bd0"
LIC_FILES_CHKSUM_pn-${PN}_ti814x = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

BRANCH_ti816x = "ti81xx-master"
SRCREV_pn-${PN}_ti816x = "5fcf46a405fe8e8a59a04d3cebdafd39ac0c4bd0"
LIC_FILES_CHKSUM_pn-${PN}_ti816x = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

S = "${WORKDIR}/git"
