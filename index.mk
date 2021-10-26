# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour)
MAKEFLAGS += -rR
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables

unexport _JAVA_OPTIONS

srcDirName := src
dstDirName := dst
