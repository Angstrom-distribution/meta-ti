# Image with cloud9 ide, gfx and hw tools installed

CONMANPKGS ?= "connman connman-angstrom-settings connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-systemd connman-gnome"

require cloud9-image.bb

# SoC specific packages, mostly 3D or multimedia related
SOCSUPPORT = ""
SOCSUPPORT_omap3 = "xbmc libgles-omap3-x11demos gstreamer-ti omapfbplay"
SOCSUPPORT_ti33x = ""

IMAGE_INSTALL += " \
                  angstrom-packagegroup-gnome packagegroup-gnome-apps epiphany chromium gnome-terminal \
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

