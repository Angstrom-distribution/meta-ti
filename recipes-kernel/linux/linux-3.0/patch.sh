#!/bin/bash
# (c) 2009 - 2011 Koen Kooi <koen@dominion.thruhere.net>
# This script will take a set of directories with patches and make a git tree out of it
# After all the patches are applied it will output a SRC_URI fragment you can copy/paste into a recipe

TAG="v3.0.4"
EXTRATAG="-3.0"
PATCHPATH=$(dirname $0)

git am --abort
git reset --hard ${TAG}
rm export -rf

previous=${TAG}
PATCHSET="pm-wip/voltdm pm-wip/cpufreq bias beagle madc sakoman sgx ulcd omap4"

# apply patches
for patchset in ${PATCHSET} ; do
	git am $PATCHPATH/$patchset/* && git tag "${patchset}${EXTRATAG}" -f
done

# export patches and output SRC_URI for them
for patchset in ${PATCHSET} ; do
	mkdir export/$patchset -p
	( cd export/$patchset && git format-patch ${previous}..${patchset}${EXTRATAG} >& /dev/null && for i in *.patch ; do echo "            file://${patchset}/$i \\" ; done )
	previous=${patchset}${EXTRATAG}
done
