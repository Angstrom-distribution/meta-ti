require libgles-omap3-no-x.inc

LICENSE = "TSPA"

PR = "${INC_PR}.1"

BINLOCATION_omap3 = "${S}/gfx_rel_es3.x"
BINLOCATION_ti816x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti814x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti33x = "${S}/gfx_rel_es8.x"
BINLOCATION_ti43x = "${S}/gfx_rel_es9.x"

PLATFORM = "LinuxARMV7"
PVR_INIT = "pvrsrvctl"

SGXPV = "5_00_00_01"
IMGPV = "1.10.2359475"

TI_BIN_UNPK_WDEXT := "/Graphics_SDK_${SGXPV}"

BINFILE_HARDFP = "Graphics_SDK_setuplinux_${SGXPV}_alpha_hardfp_minimal_demos.bin"
MD5SUM_HARDFP = "ae6125d7f8a313ea5c02afded893052d"
SHA256SUM_HARDFP = "c2782a2f85024741722b936ec9dca66b858ae8561aa71b693f11e12d8c0385e0"

# For now we only have hardfp version
python __anonymous() {
    tunes = bb.data.getVar("TUNE_FEATURES", d, 1)
    if not tunes:
        return
    pkgn = bb.data.getVar("PN", d, 1)
    pkgv = bb.data.getVar("PV", d, 1)
    if "callconvention-hard" not in tunes:
        bb.warn("%s-%s ONLY supports hardfp mode for now" % (pkgn, pkgv))
        raise bb.parse.SkipPackage("%s-%s ONLY supports hardfp mode for now" % (pkgn, pkgv))
}

BINFILE := "${BINFILE_HARDFP}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/gfxsdk/${SGXPV}/exports/${BINFILE} \
           file://cputype \
           file://rc.pvr \
           file://99-bufferclass.rules  \
"

SRC_URI[md5sum] := "${MD5SUM_HARDFP}"
SRC_URI[sha256sum] := "${SHA256SUM_HARDFP}"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

LIBGLESWINDOWSYSTEM ?= "libpvrPVR2D_FRONTWSEGL.so.1"
