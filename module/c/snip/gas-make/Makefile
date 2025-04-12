# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour)
MAKEFLAGS += -rR
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables

prog := main
srcDirPath := $(CURDIR)/src
dstDirPath := $(CURDIR)/dst
exeFilePath := $(dstDirPath)/$(prog)

all: $(exeFilePath)
	$^

disasm: $(prog)
	objdump -D $(prog)

$(exeFilePath): $(prog).S
	mkdir $(dstDirPath)
	@cc -nostdlib -no-pie "$^" -o "$@"

clean:
	rm -fv $(dstDirPath)/*

.SILENT:
.PHONY: all disasm clean
