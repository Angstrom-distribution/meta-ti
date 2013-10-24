DESCRIPTION = "Userspace libraries for omap5 sgx"
HOMEPAGE = "http://downloads.ti.com/dsps/dsps_public_sw/gfxsdk"
LICENSE = "TSPA"
LIC_FILES_CHKSUM = "file://OMAP5-Linux-Graphics-DDK-UM-Manifest.doc;md5=d280df8e94bb2e7b9251c8526078eeb8"

COMPATIBLE_MACHINE = "omap-a15"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/OMAP5_1_09_00_10//exports/${PN}-${PV}.tar.gz;protocol=http"

PR = "r0"

SRC_URI[md5sum] = "3cfb875de031098a4c1eeeaf4e442367"
SRC_URI[sha256sum] = "20b849088c0fd3ee5dd6bad8ddf16fb2b3267aa053cf3488c762fbc72f22489a"

S = "${WORKDIR}/${PN}-${PV}"

do_install () {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} += "${libdir}/gbm/"

INSANE_SKIP_${PN} = "useless-rpaths"
INSANE_SKIP_${PN}-dev = "useless-rpaths"
