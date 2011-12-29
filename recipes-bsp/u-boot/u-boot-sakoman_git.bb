require u-boot.inc

COMPATIBLE_MACHINE = "omap4430-panda"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/u-boot-sakoman-git/"

SRCREV = "261733408a27d14590cf3ec6b596461808050e32"

PV = "2010.12+${PR}+git${SRCREV}"

SRC_URI = "git://www.sakoman.com/git/u-boot.git;branch=omap4-exp;protocol=git \
          "
S = "${WORKDIR}/git"

do_compile () {
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS
    oe_runmake all
}
