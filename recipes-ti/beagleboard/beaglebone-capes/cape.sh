#!/bin/sh
for eeprom in /sys/bus/i2c/devices/3-005*/eeprom ; do
	PARTNUMBER=$(hexdump -e '8/1 "%c"' $eeprom -s 58 -n16)
	case $PARTNUMBER in
		"BB-BONE-LCD3-01.")
				echo "Turning on backlight for LCD3 cape"
				i2cset -f -y 1 0x24 0x07 0x09
				i2cset -f -y 1 0x24 0x08 0x60;;
		"BB-BONE-LCD4"*)
				echo "Turning on backlight for LCD4 cape"
				i2cset -f -y 1 0x24 0x07 0x09
				i2cset -f -y 1 0x24 0x08 0x60;;
		"BB-BONE-WTHR-01.")
				echo "Initializing I2C devices"
				echo sht21 0x40 > /sys/class/i2c-adapter/i2c-3/new_device
				echo bmp085 0x77 > /sys/class/i2c-adapter/i2c-3/new_device
				echo tsl2550 0x39 > /sys/class/i2c-adapter/i2c-3/new_device
				echo 1 > /sys/bus/i2c/devices/3-0039/operating_mode;;
		*)
				echo "unknown cape: $PARTNUMBER";;
	esac
done
