# Image with cloud9 ide and hw tools installed

require ti-hw-bringup-image.bb

FATPAYLOAD = "${datadir}/beaglebone-getting-started/*"

ROOTFSTYPE_beaglebone = "ext4"

IMAGE_INSTALL += " \
	cloud9 \
	task-sdk-target \
	vim vim-vimrc \
	procps \
	beaglebone-tester \
	screen minicom \
	git \
	beaglebone-getting-started bonescript \
	led-config \
	opencv-dev \
	ntp \
"

export IMAGE_BASENAME = "Cloud9-IDE"

