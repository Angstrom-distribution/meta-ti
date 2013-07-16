# Image with cloud9 ide and hw tools installed

require ti-hw-bringup-image.bb

FATPAYLOAD = "${datadir}/beaglebone-getting-started/*"

ROOTFSTYPE_beaglebone = "ext4"

IMAGE_INSTALL += " \
	systemd-analyze \
	cloud9 \
	mpd \
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
	e2fsprogs-mke2fs \
	cpufreq-tweaks \
	dosfstools \
	parted \
	linux-firmware-ar3k \
	linux-firmware-ar9170 \
	linux-firmware-ath6k \
	linux-firmware-ath9k \
	linux-firmware-bcm4329 \
	linux-firmware-bcm4330 \
	linux-firmware-bcm4334 \
	linux-firmware-iwlwifi-6000g2a-5 \
	linux-firmware-iwlwifi-6000g2b-6 \
	linux-firmware-ralink \
	linux-firmware-rtl8192ce \
	linux-firmware-rtl8192cu \
	linux-firmware-rtl8192su \
	linux-firmware-sd8686 \
	linux-firmware-vt6656 \
	linux-firmware-wl12xx \
"

export IMAGE_BASENAME = "Cloud9-IDE"

