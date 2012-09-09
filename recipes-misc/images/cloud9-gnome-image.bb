# Image with cloud9 ide, gfx and hw tools installed

require cloud9-image.bb

# SoC specific packages, mostly 3D or multimedia related
SOCSUPPORT = ""
SOCSUPPORT_omap3 = "xbmc libgles-omap3-x11demos gstreamer-ti omapfbplay"
SOCSUPPORT_ti33x = "xbmc libgles-omap3-x11demos gst-ffmpeg mplayer2 beaglebone-capes"

IMAGE_INSTALL += " \
                  angstrom-packagegroup-gnome gimp abiword gedit midori epiphany firefox matchbox-terminal \
                  ${SOCSUPPORT} \
                  ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common \
                  xinput-calibrator \
                  xterm \
                 "

export IMAGE_BASENAME = "Cloud9-IDE-GNOME"

