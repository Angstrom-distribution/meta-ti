require recipes-graphics/drm/libdrm.inc

COMPATIBLE_MACHINE = "omap-a15"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += "--enable-omap-experimental-api --enable-kms"

SRC_URI = "git://git.ti.com/glsdk/libdrm.git;protocol=git"
SRCREV = "3cb5405084111193cedb8796d259b56560b088f0"

PR = "${INC_PR}.0"

S = "${WORKDIR}/git"
