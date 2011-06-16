require u-boot.inc
PR ="r66"

DEFAULT_PREFERENCE_ti814x = "-1"
DEFAULT_PREFERENCE_ti816x = "-1"

FILESPATHPKG =. "u-boot-git:"

SRC_URI_beagleboard = "git://www.denx.de/git/u-boot.git;protocol=git \
                       file://0001-OMAP3-Beagle-Pin-Mux-initialization-glitch-fix.patch \
                       file://0002-OMAP-Remove-omapfb.debug-y-from-Beagle-and-Overo-env.patch \
                       file://0003-omap3_beagle-enable-the-use-of-a-plain-text-file-nam.patch \
                       file://0004-OMAP3-BeagleBoard-Enable-pullups-on-i2c2.patch \
                       file://0005-ARMV7-OMAP3-BeagleBoard-add-xM-rev-B-to-ID-table.patch \
                       file://0006-OMAP3-BeagleBoard-add-more-expansionboard-IDs.patch \
                       file://0007-OMAP3-Add-DSS-driver-for-OMAP3.patch \
                       file://0008-BeagleBoard-Added-userbutton-command.patch \
                       file://0009-OMAP3-beagle-pass-expansionboard-name-in-bootargs.patch \
                       file://0010-Enable-DSS-driver-for-Beagle.patch \
                       file://0011-Add-led-command.patch \
                       file://0012-BeagleBoard-Added-LED-driver.patch \
                       file://0013-OMAP3-BeagleBoard-updated-default-configuration.patch \
                       file://0014-Corrected-LED-name-match-finding-avoiding-extraneous.patch \
                       file://0015-omap3_beagle-Switch-default-console-from-ttyS2-to-tt.patch \
                       file://0016-BeagleBoard-Load-kernel-via-MMC-ext2-not-fat.patch \
                       file://fw_env.config \
                      "

SRCREV_pn-${PN}_beagleboard = "c7977858dcf1f656cbe91ea0dc3cb9139c6a8cc8"
PV_pn-${PN}_beagleboard = "2011.02+${PR}+gitr${SRCREV}"
LIC_FILES_CHKSUM_pn-${PN}_beagleboard = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

# ~ TI PSP v2009.11_OMAPPSP_03.00.01.06 (+ couple of commits)
SRC_URI_omap3evm = "git://arago-project.org/git/projects/u-boot-omap3.git;protocol=git \
    file://0001-omap3evm-Change-default-console-serial-port-from.patch \
"
SRCREV_${PN}_omap3evm = "c0a8fb217fdca7888d89f9a3dee74a4cec865620"
PV_omap3evm = "2009.11+${PR}+gitr${SRCREV}"

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


# hawkboard - master branch (hawk still .07beta)
SRC_URI_hawkboard          = "git://arago-project.org/git/people/sekhar/u-boot-omapl1.git;protocol=git;branch=master"
SRC_URI_hawkboard         += "file://dont-inline-weak-symbols2.patch"
SRCREV_pn-${PN}_hawkboard           = "0d291f2f255e6d66a78b3dc2445362a96ae39a57"
PV_hawkboard               = "2009.08+gitr${SRCREV}"


S = "${WORKDIR}/git"
