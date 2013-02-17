SOC_FAMILY = "keystone"
require conf/machine/include/soc-family.inc

require conf/machine/include/tune-cortexa15.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-keystone"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"

# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r5"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

EXTRA_IMAGEDEPENDS += "u-boot"
EXTRA_IMAGEDEPENDS += "boot-monitor"
