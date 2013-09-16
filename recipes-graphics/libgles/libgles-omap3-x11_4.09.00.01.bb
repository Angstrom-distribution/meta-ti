require libgles-omap3-x11.inc

LICENSE = "TSPA"

PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"

BINLOCATION_omap3 = "${S}/gfx_rel_es3.x"
BINLOCATION_ti816x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti814x = "${S}/gfx_rel_es6.x"
BINLOCATION_ti33x = "${S}/gfx_rel_es8.x"

PLATFORM = "LinuxARMV7"
PVR_INIT = "pvrsrvctl"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

SGXPV = "4_09_00_01"
IMGPV = "1.9.2188537"

TI_BIN_UNPK_WDEXT := "/Graphics_SDK_${SGXPV}"

# Select the corresponding hardfp/softfp filename and checksums based on tune flags
BINFILE_SOFTFP = "Graphics_SDK_setuplinux_${SGXPV}_minimal_demos.bin"
MD5SUM_SOFTFP = "bd35e9d8843aff3a2aca9d41e7db1c7d"
SHA256SUM_SOFTFP = "eb37f75ddde4640b09e760fa86e689beb394330ecdf68786188c34f249247647"

BINFILE_HARDFP = "Graphics_SDK_setuplinux_${SGXPV}_hardfp_minimal_demos.bin"
MD5SUM_HARDFP = "c9f656dce062d1ab10afffd4dfb71b67"
SHA256SUM_HARDFP = "dbfeba8e1298f139495816334edec1455e6b49b1e11bd1b2aa0a888e5788bb6b"

BINFILE = "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${BINFILE_HARDFP}', '${BINFILE_SOFTFP}', d)}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
           file://cputype \
           file://rc.pvr \
           file://rc_dri.pvr \
           file://sample.desktop \
           file://99-bufferclass.rules  \
"

SRC_URI[md5sum] := "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${MD5SUM_HARDFP}', '${MD5SUM_SOFTFP}', d)}"
SRC_URI[sha256sum] := "${@base_contains('TUNE_FEATURES', 'callconvention-hard', '${SHA256SUM_HARDFP}', '${SHA256SUM_SOFTFP}', d)}"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

LIBGLESWINDOWSYSTEM ?= "libpvrPVR2D_DRIWSEGL.so"

do_configure_append() {

    # Change PVR server's user mode library to point to DRI
    for drifile in $(find ${S} -name "libsrv_um_dri.so"); do
    if [ "$drifile" != "" ]
    then
        dir=$(dirname ${drifile})
        if [ "$SUPPORT_XORG" = "1" ]
        then
            mv ${dir}/libsrv_um_dri.so ${dir}/libsrv_um.so
        else
            rm -rf ${dir}/libsrv_um_dri.so
        fi
    fi

    done
}

do_install_append() {

    # In this version of the graphics SDK the following directories do not exist:
    #    /GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/pvr2d.h (doesn't exist)
    #    /GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/GLES/egltypes.h (doesn't exist)
    # Therefore, need to copy these files manually at the only location that they do exist
    cp -pPr ${S}/include/pvr2d/*.h ${D}${includedir}
    cp -pPr ${S}/include/OGLES/GLES ${D}${includedir}/

    rm -f ${D}${sysconfdir}/init.d/pvr-init

    if [ "$SUPPORT_XORG" = "1" ]; then
        cp -pP ${WORKDIR}/rc_dri.pvr ${D}${sysconfdir}/init.d/pvr-init
    else
        cp -pP ${WORKDIR}/rc.pvr ${D}${sysconfdir}/init.d/pvr-init
    fi

}

RRECOMMENDS_${PN}-x11demos = "${PN}-driwsegl"
RRECOMMENDS_${PN}-x11trainingcourses = "${PN}-driwsegl"
