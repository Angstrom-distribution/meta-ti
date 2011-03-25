require x-load.inc

#FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.5.0+${PR}+gitr${SRCREV}"
PR ="r22"
PE = "1"

SRCREV_pn-${PN} = "b6bbfe7848de547b64edf1c363c86cec4921b517"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
          "

S = "${WORKDIR}/git"

XLOAD_MACHINE_beagleboard = "omap3530beagle_config"
XLOAD_MACHINE_omap3-touchbook = "omap3530beagle_config"

PACKAGE_ARCH = "${MACHINE_ARCH}"
