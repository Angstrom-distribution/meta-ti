require ti-dmai.inc

# Need to descend one level more to find source
S = "${WORKDIR}/${DMAIBRANCH}/davinci_multimedia_application_interface/dmai_${PV}/dmai"

# Hack to be able to use recent kernel headers from userspace
TARGET_CC_ARCH += " -D__EXPORTED_HEADERS__"

PV = "2_10_00_01+svnr${SRCPV}"

LIC_FILES_CHKSUM = "file://dmai_${PV}_License.html;md5=3302f728a5a42f97cabc26a54d7fa607"

# This package has high dependence on kernel, use kernel PR as base and append a local version
PR = "${MACHINE_KERNEL_PR}"
PR_append = "o"

DMAIBRANCH_dm6446     = "trunk"
DMAIBRANCH_dm6467     = "branches/GITPSP_INT_101009"
DMAIBRANCH_omap3      = "trunk"
DMAIBRANCH_dm355      = "branches/GITPSP_INT_101009"
DMAIBRANCH_dm365      = "trunk"
DMAIBRANCH_omapl137   = "trunk"
DMAIBRANCH_omapl138   = "trunk"
DMAIBRANCH           ?= "UNDEFINED_DMAIBRANCH"

SRCREV_dm6446         = "482"
SRCREV_dm6467         = "441"
SRCREV_omap3          = "642"
SRCREV_dm355          = "424"
SRCREV_dm365          = "570"
SRCREV_omapl137       = "482"
SRCREV_omapl138       = "570"
SRCREV               ?= "UNDEFINED_SRCREV"

SRC_URI_append = " file://omap3530-r642-remove-include-videodev.diff;striplevel=3 \
                   file://r642-fix-config-bld.diff;striplevel=3 \
                 "

