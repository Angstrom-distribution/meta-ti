# Include this file for kernel recipes that need to handle different defconfigs
# and apply patches based on "tipspkernel" DISTRO_FEATURES

def get_major_pv(p):
	import re
	r = re.compile("([0-9]+\.[0-9]+).*")
	m = r.match(p);
	if m:
		return m.group(1)
	return None

PMV = "${@get_major_pv(d.getVar('PV', True))}"

# First of all, set own FILESPATH avoiding unnecessary BP and BPN, but adding
# extra level of major version
FILESPATH = "${@base_set_filespath([ "${FILE_DIRNAME}/${PF}", "${FILE_DIRNAME}/${P}", "${FILE_DIRNAME}/${PN}-${PMV}", \
"${FILE_DIRNAME}/${PN}", "${FILE_DIRNAME}/files", "${FILE_DIRNAME}" ], d)}"

# We don't want "tipspkernel" to be another OVERRIDE, but rather a new level of
# FILESPATH with all the OVERRIDES applied to it
CONFIGS_PSP = "${@base_set_filespath(["${FILE_DIRNAME}/${PF}/tipspkernel", "${FILE_DIRNAME}/${P}/tipspkernel", \
"${FILE_DIRNAME}/${PN}-${PMV}/tipspkernel", "${FILE_DIRNAME}/${PN}/tipspkernel", "${FILE_DIRNAME}/files/tipspkernel", \
"${FILE_DIRNAME}/tipspkernel"], d)}:"

# When "tipspkernel" is ENABLED, prepend additional set of directories to FILESPATH
FILESPATH =. "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "${CONFIGS_PSP}", "", d)}"

# When "tipspkernel" is NOT ENABLED, append additional list of PATCHES_OVER_PSP to SRC_URI
SRC_URI_append = "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "", "${PATCHES_OVER_PSP}", d)}"

# List additional patches to apply on top of PSP kernel, start with a space
PATCHES_OVER_PSP = ""
