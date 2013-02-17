SOC_FAMILY = "omap3"
require conf/machine/include/soc-family.inc

require conf/machine/include/tune-cortexa8.inc

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r123"

KERNEL_IMAGETYPE = "uImage"

PREFERRED_PROVIDER_virtual/kernel = "linux-omap"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

EXTRA_IMAGEDEPENDS += "u-boot x-load"
