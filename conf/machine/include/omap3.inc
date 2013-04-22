SOC_FAMILY = "omap3"
require conf/machine/include/soc-family.inc

require conf/machine/include/tune-cortexa8.inc

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"

# For built-in LCD, add xf86-input-tslib
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-omapfb \
           xf86-input-keyboard"

# Default to external video, change to smallscreen for built-in LCD
GUI_MACHINE_CLASS = "bigscreen"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r125"

KERNEL_IMAGETYPE = "uImage"

# Default providers, may need to override for specific machines
PREFERRED_PROVIDER_virtual/kernel = "linux-omap"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

UBOOT_ARCH = "arm"
UBOOT_MACHINE = "omap3_evm_config"
XLOAD_MACHINE = "omap3evm_config"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

# If SPL is not used, may need to add x-load
EXTRA_IMAGEDEPENDS += "u-boot"

# List common SoC features, may need to add touchscreen/ethernet for specific machines
MACHINE_FEATURES = "kernel26 apm usbgadget usbhost vfat ext2 screen alsa sgx"
