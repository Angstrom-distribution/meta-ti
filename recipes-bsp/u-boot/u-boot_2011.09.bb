require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard)"

SRC_URI = "git://www.denx.de/git/u-boot.git;protocol=git \
           file://2011.09/0001-HACK-beagleboard-config-disable-cache-for-USB.patch \
           file://2011.09/0002-beagleboard-config-enable-gpio-command.patch \
           file://2011.09/0003-Increased-some-timeout-durations-for-MMC-and-EHCI.patch \
           file://fw_env.config \
          "
# v2011.09 tag -> 6ceb0135f96d73063ffbaab5be7ce23933367388
# The tag below is from the master tree, but 21 patches after.
# $ git log 6ceb0135f..56fa45d58 | grep commit | wc -l
# 21
SRCREV = "56fa45d58116f86f343a9c45ce6d1110f50b8d70"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"
