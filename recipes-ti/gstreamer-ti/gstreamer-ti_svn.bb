require gstreamer-ti.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=c8a292be1d17ba07ecbf7b49049cbf22"

PV = "svnr${SRCREV}"

S = "${WORKDIR}/gstreamer_ti/ti_build/ticodecplugin"

SRCREV = "962"

# apply patches from tracker 1208 to get zero copy support.
# https://gstreamer.ti.com/gf/project/gstreamer_ti/tracker/?action=TrackerItemEdit&tracker_item_id=1208&start=175

SRC_URI = "svn://gforge.ti.com/svn/gstreamer_ti/trunk;module=gstreamer_ti;protocol=https;user=anonymous;pswd='' \
           file://gstreamer-ti-rc.sh \
           file://r962-remove-include-videodev.diff \
           file://gstti-init.service \
"

# use local loadmodules.sh for these platform
# TODO: must be removed onces these loadmodules goes in gstreamer.ti.com
SRC_URI_append_dm365 = " file://loadmodules.sh"
SRC_URI_append_omapl137 = " file://loadmodules.sh"
SRC_URI_append_omapl138 = " file://loadmodules.sh "
SRC_URI_append_omap3 = " file://loadmodules.sh "

