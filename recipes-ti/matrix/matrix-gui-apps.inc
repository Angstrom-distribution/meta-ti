require matrix-gui-paths.inc

MATRIX_FILES_DIR ?= ${S}

# Append a generic function to the do_install step that will look in the
# MATRIX_FILES_DIR for .desktop files and then:
#   1.  Install all non-script files into the MATRIX_APP_DIR
#   2.  Install all script files into ${bindir}
do_install_append(){
    cd ${MATRIX_FILES_DIR}
    applist=`find . -name "*.desktop"`

    for app in $applist
    do
        appdir=`dirname $app`
        install -d ${D}${MATRIX_APP_DIR}/$appdir

        # Get the non-script files which are the matrix metadata
        matrix_apps=`find $appdir -type f ! -name "*\.sh"`
        for m in $matrix_apps
        do
            install -m 0644 ${MATRIX_FILES_DIR}/$m ${D}${MATRIX_APP_DIR}/$appdir/
        done

        # Put the script files as executables in ${bindir}
        scripts=`find $appdir -type f -name "*\.sh"`
        for s in $scripts
        do
            if [ ! -d ${D}/${bindir} ]
            then
                install -d ${D}${bindir}
            fi
            install -m 0755 ${MATRIX_FILES_DIR}/$s ${D}${bindir}/
        done
    done

    # Go back to the directory we started from in case there are
    # other appends.
    cd -
}
