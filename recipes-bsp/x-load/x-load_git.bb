require x-load.inc

#FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.5.1"
PR ="r0"
PE = "1"

SRCREV_pn-${PN} = "fca7cd29b6821df3e7d8c4369522f2a3d01a5d7b"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
"

S = "${WORKDIR}/git"

XLOAD_MACHINE_beagleboard = "omap3530beagle_config"
XLOAD_MACHINE_omap3-touchbook = "omap3530beagle_config"

PACKAGE_ARCH = "${MACHINE_ARCH}"
