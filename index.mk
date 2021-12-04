# Common code for the all Makefiles.

# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour).
MAKEFLAGS += -rR
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory

unexport _JAVA_OPTIONS

srcDirName := src
dstDirName := dst
