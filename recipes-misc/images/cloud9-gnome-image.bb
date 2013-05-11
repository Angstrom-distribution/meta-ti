# Image with cloud9 ide, gfx and hw tools installed

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-systemd connman-gnome"

require cloud9-image.bb

# SoC specific packages, mostly 3D or multimedia related
SOCSUPPORT = ""
SOCSUPPORT_omap3 = "xbmc libgles-omap3-x11demos gstreamer-ti omapfbplay"
SOCSUPPORT_ti33x = "gst-ffmpeg mplayer2"

IMAGE_INSTALL += " \
                  angstrom-packagegroup-gnome gimp abiword gedit epiphany chromium xfce-terminal \
                  ${SOCSUPPORT} \
                  ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common \
                  xinput-calibrator \
                  xterm \
                  cheese \
                  florence \
                  evince \
                  man \
                  x11vnc \
                 "

export IMAGE_BASENAME = "Cloud9-IDE-GNOME"

# Add 'doc-pkgs' for man pages
EXTRA_IMAGE_FEATURES += "package-management"

