# Image with cloud9 ide and hw tools installed

require ti-hw-bringup-image.bb

FATPAYLOAD = "${datadir}/beaglebone-getting-started/"

IMAGE_INSTALL += " \
	cloud9 \
	task-sdk-target \
	matrix-gui \
	matrix-gui-coming-soon \
	matrix-gui-submenus-arm \
	matrix-gui-submenus-cryptos \
	matrix-gui-submenus-ethernet \
	matrix-gui-submenus-settings \
	matrix-gui-submenus-usb \
	vim vim-vimrc \
	procps \
	beaglebone-tester \
	screen minicom \
	git \
	beaglebone-getting-started bonescript \
	led-config \
"

export IMAGE_BASENAME = "Cloud9-IDE"

