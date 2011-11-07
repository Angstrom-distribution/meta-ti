# Image with cloud9 ide, gfx and hw tools installed

require cloud9-image.bb

IMAGE_INSTALL += " \
                  task-xserver \
                  angstrom-gnome-icon-theme-enable gtk-engine-clearlooks gtk-theme-clearlooks angstrom-clearlooks-theme-enable \
                  elsa \
                 "

export IMAGE_BASENAME = "Cloud9-IDE-gfx"

