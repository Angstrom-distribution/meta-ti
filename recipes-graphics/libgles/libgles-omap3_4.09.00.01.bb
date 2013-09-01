require libgles-omap3-no-x.inc

LICENSE = "TSPA"

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

BINLOCATION_omap3  = "${S}/gfx_rel_es3.x"
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
BINFILE = "Graphics_SDK_setuplinux_${SGXPV}_minimal_demos.bin"
TI_BIN_UNPK_WDEXT := "/Graphics_SDK_${SGXPV}"
SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/${BINFILE} \
           file://cputype \
           file://rc.pvr \
           file://99-bufferclass.rules  \
"
SRC_URI[md5sum] = "bd35e9d8843aff3a2aca9d41e7db1c7d"
SRC_URI[sha256sum] = "eb37f75ddde4640b09e760fa86e689beb394330ecdf68786188c34f249247647"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"

LIBGLESWINDOWSYSTEM ?= "libpvrPVR2D_FRONTWSEGL.so.1"
