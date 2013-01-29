DESCRIPTION = "Cortex-M3 binary blob for suspend-resume"

LICENSE = "TI-BSD"
LIC_FILES_CHKSUM = "file://License.txt;md5=858099c817e47ea63559fc6b67ae8d91"

PV = "04.06.00.09"
SRCREV = "c110752cfefa1f3d75403755a3680c8742f4d88d"

SRC_URI = "git://arago-project.org/git/projects/am33x-cm3.git"

S = "${WORKDIR}/git"

do_compile() {
	make CC="${TARGET_CC}" CROSS_COMPILE="${TARGET_PREFIX}"
}

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 bin/am335x-pm-firmware.bin ${D}${base_libdir}/firmware/
}

FILES_${PN} = "${base_libdir}/firmware"

