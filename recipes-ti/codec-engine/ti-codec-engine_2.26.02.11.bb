require ti-codec-engine.inc

LIC_FILES_CHKSUM = "file://codec_engine_${PV}_manifest.html;md5=912535f1b02ecf329a3979bf313f91e0"
PV = "2_26_02_11"
PR_append = "b"

SRC_URI += "file://bypass-GCArmv5T-used-is-sealed.patch"

SRC_URI[cetarball.md5sum] = "4f755f77119e4da19ab5cc7ae7ccfdb4"
SRC_URI[cetarball.sha256sum] = "17fa053719265e0901fe3c3f90c9204957c6d0f5351d6b3ba4900df58cb7300f"
