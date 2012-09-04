PRINC := "${@int(PRINC) + 1}"

# avoid providing conflicts for libgles-omap3 compatibles
PROVIDES_omap3 = "virtual/libgl"
PROVIDES_ti814x = "virtual/libgl"
PROVIDES_ti816x = "virtual/libgl"
PROVIDES_ti33x = "virtual/libgl"
