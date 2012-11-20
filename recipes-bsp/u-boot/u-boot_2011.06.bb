require u-boot.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "(beagleboard)"

SRC_URI = "git://git.denx.de/u-boot.git;protocol=git \
           file://2011.06/0001-OMAP3-Beagle-Pin-Mux-initialization-glitch-fix.patch \
           file://2011.06/0002-OMAP-Remove-omapfb.debug-y-from-Beagle-and-Overo-env.patch \
           file://2011.06/0003-OMAP3-beagle-pass-expansionboard-name-in-bootargs.patch \
           file://2011.06/0004-beagleboard-add-support-for-xM-revision-C.patch \
           file://2011.06/0005-Add-support-for-SMSC95XX-USB-2.0-10-100MBit-Ethernet.patch \
           file://2011.06/0006-Add-Ethernet-hardware-MAC-address-framework-to-usbne.patch \
           file://2011.06/0007-Add-documentation-for-USB-Host-Networking.patch \
           file://2011.06/0008-dm3730-enable-dpll5.patch \
           file://2011.06/0009-beagleboard-enable-HUB-power-on-XM-boards.patch \
           file://2011.06/0010-beagleboard-turn-off-clocks-in-ehci_stop.patch \
           file://2011.06/0011-beagleboard-enable-networking.patch \
           file://2011.06/0012-beagleboard-switch-to-ttyO2-as-console.patch \
           file://2011.06/0013-beagleboard-load-kernel-from-MMC-ext-not-FAT.patch \
           file://2011.06/0014-beagleboard-enable-asix-driver-and-dhcp.patch \
           file://2011.06/0015-beagleboard-hardcode-MAC-for-onboard-SMSC-and-use-uI.patch \
           file://2011.06/0016-beagleboard-decrease-bootdelay-to-2-seconds.patch \
           file://2011.06/0017-USB-Remove-__attribute__-packed-for-struct-ehci_hccr.patch \
           file://2011.06/0018-usb-Some-EHCI-chipsets-are-slow-to-respond.patch \
           file://2011.06/0019-OMAP3-Add-DSS-driver-for-OMAP3.patch \
           file://2011.06/0020-video-DSS-makefile-update.patch \
           file://2011.06/0021-BeagleBoard-Configure-DVI-S-video.patch \
           file://2011.06/0022-BeagleBoard-config-enable-DSS.patch \
           file://2011.06/0023-BeagleBoard-Added-userbutton-command.patch \
           file://2011.06/0024-Corrected-LED-name-match-finding-avoiding-extraneous.patch \
           file://2011.06/0025-BeagleBoard-fix-LED-0-1-in-driver.patch \
           file://2011.06/0026-led-added-cmd_led-to-Makefile.patch \
           file://2011.06/0027-led-correct-off-on-locations-in-structure.patch \
           file://2011.06/0028-BeagleBoard-config-make-mtest-run.patch \
           file://2011.06/0029-BeagleBoard-config-increase-command-line-functionali.patch \
           file://2011.06/0030-BeagleBoard-config-add-optargs-buddy-camera.patch \
           file://2011.06/0031-omap4-add-support-for-gpios.patch \
           file://2011.06/0032-omap4-add-support-for-EHCI.patch \
           file://2011.06/0033-omap4_panda-add-support-for-EHCI.patch \
           file://2011.06/0034-omap4_panda-adding-support-for-smsc-and-tftp-boot.patch \
           file://2011.06/0035-omap4_panda-use-uImage.panda-for-tftp.patch \
           file://fw_env.config \
          "
# v2011.06 tag -> b1af6f532e0d348b153d5c148369229d24af361a
SRCREV = "b1af6f532e0d348b153d5c148369229d24af361a"
PV = "2011.06"
PR = "r1"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"
