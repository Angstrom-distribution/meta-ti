require x-load.inc

#FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.5.0+${PR}+gitr${SRCREV}"
PR ="r23"
PE = "1"

SRCREV_pn-${PN} = "04b1732220078d47c18a84cbafc52e45db71f13d"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
          "

S = "${WORKDIR}/git"

XLOAD_MACHINE_beagleboard = "omap3530beagle_config"
XLOAD_MACHINE_omap3-touchbook = "omap3530beagle_config"

PACKAGE_ARCH = "${MACHINE_ARCH}"
