require x-load.inc

DEFAULT_PREFERENCE_omap3-pandora = "-1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-git"

SRCREV_pn-${PN} = "1c9276af4d6a5b7014a7630a1abeddf3b3177563"

PV = "1.44+${PR}+gitr${SRCREV}"
PR ="r16"
PE = "1"

SRC_URI = "git://gitorious.org/x-load-omap3/mainline.git;branch=master;protocol=git"

SRC_URI_append_beagleboard = " \
                              file://name.patch \
                              file://bb8547fcbc54ecc7a75f9ad45a31042a04d8a2ce.patch \
                              file://xm-mem.patch \
                             "
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
