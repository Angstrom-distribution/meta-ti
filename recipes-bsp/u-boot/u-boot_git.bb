require u-boot.inc
PR ="r68"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_ti814x = "-1"
DEFAULT_PREFERENCE_ti816x = "-1"

FILESPATHPKG =. "u-boot-git:"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_omap3evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
    file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_${PN}_omap3evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_omap3evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_pn-${PN}_am3517-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git"
SRCREV_pn-${PN}_am3517-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_pn-${PN}_am3517-evm = "2009.11+${PR}+gitr${SRCREV}"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_am37x-evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
    file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_pn-${PN}_am37x-evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_am37x-evm = "2009.11+${PR}+gitr${SRCREV}"

SRC_URI_omap3-touchbook = "git://gitorious.org/u-boot-omap3/mainline.git;branch=omap3-dev;protocol=git \
                 file://fw_env.config \
                 file://dss2.patch \
                 file://600mhz.patch \
                 file://new-pinmux.patch \
                 file://spi3.patch \
                 file://spi4.patch \
                 file://headphone.patch \
                 file://power.patch \
                 file://ai-logo.patch \
                 file://mmcinit.patch \
                 file://touchbook-config.patch \
                 file://dont-inline-weak-symbols.patch \
"
SRCREV_pn-${PN}_omap3-touchbook = "d363f9cb0918a1b6b92e2e20d01543d0c4f53274"
PV_omap3-touchbook = "2009.05+${PR}+gitr${SRCREV}"

# OMAPL1 omapl137/omapl138 - PSP 3.20.0.11

SRC_URI_omapl138 = "git://arago-project.org/git/projects/u-boot-omapl1.git;protocol=http"
SRCREV_pn-${PN}_omapl138  = "5f16b8551b125f16cd8d58f278cb25b94272fd9f"
PV_omapl138      = "2009.11+${PR}+gitr${SRCREV}"

# hawkboard - master branch (hawk still .07beta)
SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRC_URI_hawkboard         += "file://dont-inline-weak-symbols2.patch"
SRCREV_pn-${PN}_hawkboard           = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_hawkboard               = "2009.08+gitr${SRCREV}"


S = "${WORKDIR}/git"

RRECOMMENDS_${PN}_omap3-touchbook = "u-boot-fw-utils"
