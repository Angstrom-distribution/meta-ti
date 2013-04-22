DESCRIPTION = "Cortex-M3 binary blob for suspend-resume"

LICENSE = "TI-BSD"
LIC_FILES_CHKSUM = "file://License.txt;md5=858099c817e47ea63559fc6b67ae8d91"

PV = "04.06.00.10"
PR = "r2"

# SRCREV corresponds to tag "AM335xPSP_04.06.00.10-rc1"
SRCREV = "27ca4643e422245a95723de1df0247a00eada45b"
BRANCH ?= "master"

INITSCRIPT_NAME = "am335x-pm-firmware-load"
INITSCRIPT_PARAMS = "defaults 96"

inherit update-rc.d

SRC_URI = "git://arago-project.org/git/projects/am33x-cm3.git;protocol=git;branch=${BRANCH} \
           file://init-am33x-cm3 \
          "

S = "${WORKDIR}/git"

do_compile() {
	make CC="${TARGET_CC}" CROSS_COMPILE="${TARGET_PREFIX}"
}

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 bin/am335x-pm-firmware.bin ${D}${base_libdir}/firmware/

	# Install the init script to load the PM firmware at boot
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init-am33x-cm3 ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

FILES_${PN} += "${base_libdir}/firmware"

