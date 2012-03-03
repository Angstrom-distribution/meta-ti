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
	task-ti-test \
	kernel-modules \
	timestamp-service \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
"

export IMAGE_BASENAME = "TI-hw-bringup"

inherit sdcard_image
