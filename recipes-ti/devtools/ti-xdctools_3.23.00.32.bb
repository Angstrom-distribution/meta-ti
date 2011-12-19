require ti-xdctools.inc

PV = "3_23_00_32"
LIC_FILES_CHKSUM = "file://docs/license/xdc/shelf/package.html;md5=49b2dfbf48860a0da844709c3ce63a9c"

SRC_URI += "file://fix-hardcoded-paths.diff"

SRC_URI[xdcbin.md5sum] = "263aa11795670265551d36a8c77ad27d"
SRC_URI[xdcbin.sha256sum] = "880b4e263850f2a3c0ea7352c5b6e0a86692361e26634c3b70dddc42c71231a5"

S = "${WORKDIR}/ti/xdctools_${PV}"
