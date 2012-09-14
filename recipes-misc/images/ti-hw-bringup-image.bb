# Image for assisting in hardware bringup

include recipes-images/angstrom/systemd-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

# Hokey-pokey workaround for MUSB bugs
EXTRA_MACHINE_IMAGE_INSTALL_ti33x = "gadget-init"

IMAGE_INSTALL += " \
	usbutils \
	i2c-tools \
	alsa-utils \
	devmem2 \
	iw \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	lmbench \
	rt-tests \
	evtest \
	bc \
	packagegroup-ti-test \
	kernel-modules \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
"

export IMAGE_BASENAME = "TI-hw-bringup"

# This doesn't work with the current genext2fs in oe-core
# inherit sdcard_image
