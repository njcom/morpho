# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour)
MAKEFLAGS += -rR
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables

prog = main
srcDirPath := $(CURDIR)/src
dstDirPath := $(CURDIR)/dst
exeFilePath := $(dstDirPath)/$(prog)

#CC = musl-gcc
CC := gcc
CFLAGS := -O0 -g3 -gdwarf-4 -static -std=gnu17 -pedantic -Wall -Wextra -Werror -pedantic-errors -funsigned-char -Wno-unused-variable -Wno-unused-parameter -Wno-unused-function -fanalyzer -Isrc
LDFLAGS := -Lsrc

all: $(exeFilePath)
	$^

$(exeFilePath): $(dstDirPath)/morpho.o $(dstDirPath)/$(prog).o
	# $^: names of all the prerequisites, with spaces between them
	# $@: target
	$(CC) $(LDFLAGS) $(CFLAGS) $^ -o $(exeFilePath)
	echo Written "$@"

$(dstDirPath)/%.o : $(srcDirPath)/%.c
	mkdir -p $(dstDirPath)
	# $<: name of the first prerequisite.
	$(CC) $(CFLAGS) -c -o $@ $<
	echo Written "$@"

$(srcDirPath)/%.c: $(CURDIR)/Makefile

clean:
	rm -fv $(dstDirPath)/*

debug:
	gdb -ex start -ex 'i li' --args $(exeFilePath)

format:
	clang-format --verbose -i $(srcDirPath)/*.c $(srcDirPath)/*.h

info:
	echo "CC (C compiler): $(CC)"
	echo "CFLAGS (C compiler flags): $(CFLAGS)"
	echo "LDFLAGS (static linker flags): $(LDFLAGS)"

.PHONY: all clean debug format info
.SILENT:
