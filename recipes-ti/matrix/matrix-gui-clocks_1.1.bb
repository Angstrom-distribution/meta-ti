DESCRIPTION = "Clock setting descriptions for Matrix v2"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrixguiv2apps/"
LICENSE = "CC-BY-SA"

inherit allarch

SRC_URI = "https://gforge.ti.com/gf/download/frsrelease/673/5096/clocks_1.1.tar.gz"

S = ${WORKDIR}/clocks

require matrix-gui-apps.inc

# Make sure power submenu has been installed
RDEPENDS +=  matrix-gui-submenus-power

# Break out the individual files into separate packages.  That way only the
# clocks supported for each device can be installed.  Prepend the list so
# that we can get the files in ${bindir} first
PACKAGES =+ "${PN}-300mhz ${PN}-600mhz ${PN}-800mhz ${PN}-1ghz"

# Split the matrix files by clock
FILES_${PN}-300mhz += "${MATRIX_APP_DIR}/power_set_300mhz/*"
FILES_${PN}-600mhz += "${MATRIX_APP_DIR}/power_set_600mhz/*"
FILES_${PN}-800mhz += "${MATRIX_APP_DIR}/power_set_800mhz/*"
FILES_${PN}-1ghz += "${MATRIX_APP_DIR}/power_set_1ghz/*"

# Split the ${bindir} files by clock
FILES_${PN}-300mhz += "${bindir}/setopp2.sh"
FILES_${PN}-600mhz += "${bindir}/setopp3.sh"
FILES_${PN}-800mhz += "${bindir}/setopp4.sh"
FILES_${PN}-1ghz += "${bindir}/setopp1.sh"

SRC_URI[md5sum] = "6d50592e364f39d7ed3b2805e6c227cb"
SRC_URI[sha256sum] = "ab51df1651a391e3f6a947faccf45354ef187508c65cb3de92cc9fef88206e65"
