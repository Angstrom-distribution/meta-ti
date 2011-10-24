# Image for assisting in hardware bringup

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

# Hokey-pokey workaround for MUSB bugs
EXTRA_MACHINE_IMAGE_INSTALL_ti33x = "gadget-init"

IMAGE_INSTALL += " \
	angstrom-task-boot \
	task-basic \
	${CONMANPKGS} \
	python-dbus python-pycairo \
	usbutils \
	i2c-tools \
	alsa-utils \
	devmem2 \
	iw \
	task-ti-test \
	evtest \
	bc \
	kernel-modules \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
"

CONMANPKGS = "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-systemd"
CONMANPKGS_libc-uclibc = ""

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "TI-hw-bringup"

inherit sdcard_image
