DESCRIPTION = "Cortex-M3 binary blob for suspend-resume"

LICENSE = "TI-BSD"
LIC_FILES_CHKSUM = "file://License.txt;md5=858099c817e47ea63559fc6b67ae8d91"

PV = "05.00.00.01"
PR = "r1"

# Make package machine specific due to different init scripts
PACKAGE_ARCH = "${MACHINE_ARCH}"

# SRCREV corresponds to tag v05.00.00.01
SRCREV = "40cb75b9dd9ba15c6de1c15cbb7cce8f1a6588b8"
BRANCH ?= "master"

# This init script is only used for older kernels that do not support
# hotplug of the firmware.  Newer kernels do not require the initscript
# package.
INITSCRIPT_NAME = "am335x-pm-firmware-load"
INITSCRIPT_PARAMS = "defaults 96"

inherit update-rc.d

UPDATERCPN = "${PN}-initscript"

RDEPENDS_${PN}-initscript = "am33x-cm3"

SRC_URI = "git://arago-project.org/git/projects/am33x-cm3.git;protocol=git;branch=${BRANCH} \
           file://init-am33x-cm3 \
           file://init-am43x-cm3 \
          "

SCRIPT_ti33x = "init-am33x-cm3"
SCRIPT_ti43x = "init-am43x-cm3"

S = "${WORKDIR}/git"

do_compile() {
	make CC="${TARGET_CC}" CROSS_COMPILE="${TARGET_PREFIX}"
}

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 bin/am335x-pm-firmware.bin ${D}${base_libdir}/firmware/

	# Install the init script to load the PM firmware at boot
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/${SCRIPT} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

PACKAGES =+ "${PN}-initscript"

FILES_${PN} += "${base_libdir}/firmware"

FILES_${PN}-initscript = "${sysconfdir}/*"
