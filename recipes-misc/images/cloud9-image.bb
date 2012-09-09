# Image with cloud9 ide and hw tools installed

require ti-hw-bringup-image.bb

FATPAYLOAD = "${datadir}/beaglebone-getting-started/*"

ROOTFSTYPE_beaglebone = "ext4"

IMAGE_INSTALL += " \
	systemd-analyze \
	cloud9 \
	packagegroup-sdk-target \
	vim vim-vimrc \
	procps \
	beaglebone-tester \
	screen minicom \
	git \
	beaglebone-getting-started bonescript \
	led-config \
	opencv-dev \
	cronie-systemd ntpdate \
	nano \
	minicom \
	hicolor-icon-theme \
	gateone \
	tar \
	gdb gdbserver \
	nodejs-dev \
	mplayer2 \
	tslib-tests tslib-calibrate \
	iproute2 canutils \
	connman-tests \
	rsync \
"

export IMAGE_BASENAME = "Cloud9-IDE"

