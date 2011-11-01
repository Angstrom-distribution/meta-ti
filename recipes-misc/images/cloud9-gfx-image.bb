# Image with cloud9 ide, gfx and hw tools installed

require cloud9-image.bb

IMAGE_INSTALL += " \
                  task-gnome-xserver-base \
                  task-xserver \
                  task-gnome-fonts \
                  angstrom-gdm-autologin-hack angstrom-gdm-xfce-hack gdm gdm-systemd \ 
                  angstrom-gnome-icon-theme-enable gtk-engine-clearlooks gtk-theme-clearlooks angstrom-clearlooks-theme-enable \
                 "

export IMAGE_BASENAME = "Cloud9-IDE-gfx"

