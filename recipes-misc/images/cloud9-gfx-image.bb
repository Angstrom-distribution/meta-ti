# Image with cloud9 ide, gfx and hw tools installed

require cloud9-image.bb

IMAGE_INSTALL += " \
                  packagegroup-core-x11-xserver \
                  angstrom-gnome-icon-theme-enable gtk-engine-clearlooks gtk-theme-clearlooks angstrom-clearlooks-theme-enable \
                  e-wm-config-default e-wm-config-standard e-wm-config-illume2 \
                  xserver-nodm-init \
                  xserver-common \
                  ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common \
                 "

export IMAGE_BASENAME = "Cloud9-IDE-gfx"

