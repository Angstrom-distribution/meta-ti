#!/bin/sh
for eeprom in /sys/bus/i2c/devices/3-005*/eeprom ; do
	PARTNUMBER=$(hexdump -e '8/1 "%c"' $eeprom -s 58 -n16)
	case $PARTNUMBER in
		"BB-BONE-LCD3-01.")
				echo "Turning off backlight for LCD3 cape"
				i2cset -f -y 1 0x24 0x07 0x00;;
		"BB-BONE-LCD4"*)
				echo "Turning off backlight for LCD4 cape"
				i2cset -f -y 1 0x24 0x07 0x00;;
		*)
				echo "unknown cape: $PARTNUMBER";;
	esac
done
