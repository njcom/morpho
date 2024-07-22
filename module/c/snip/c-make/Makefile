# $@: target name
# $<: name of the first prerequisite.
# $^: names of all the prerequisites, with spaces between them.

prog := main
src-dir-path := $(CURDIR)/src
dst-dir-path := $(CURDIR)/dst
exe-file-path := $(dst-dir-path)/$(prog)

#CC = musl-gcc
#CC := gcc
CC := clang
C_PEDANTIC_FLAGS := -O0 -g3 -gdwarf-4 -std=gnu2x -pedantic -Wall -Wextra -Werror -pedantic-errors -funsigned-char -Wno-unused-variable -Wno-unused-parameter -Wno-unused-command-line-argument -Wno-unused-function -Wno-strict-prototypes -Wno-newline-eof -fsanitize=undefined -fsanitize=leak

#-fsanitize=thread
#-fsanitize=cfi -flto -fvisibility=hidden
#-fsanitize=memory 
#-fsanitize=leak
#-fsanitize=address
#-fsanitize=dataflow
#-fsanitize=kcfi
#-fsanitize=safe-stack

# https://gcc.gnu.org/onlinedocs/gcc/Static-Analyzer-Options.html
#-fanalyzer

#CFLAGS := $(C_PEDANTIC_FLAGS) -static -Isrc
CFLAGS := $(C_PEDANTIC_FLAGS) -I$(src-dir-path)
LDFLAGS := -L$(src-dir-path)

run: $(exe-file-path)
	$^

$(exe-file-path): $(dst-dir-path)/morpho.o $(dst-dir-path)/$(prog).o
	$(CC) $(CFLAGS) $^ $(LDFLAGS) -o $(exe-file-path)
	echo Written "$@"

$(dst-dir-path)/%.o: $(src-dir-path)/%.c
	mkdir -p $(dst-dir-path)
	$(CC) $(CFLAGS) -c -o $@ $<
	echo Written "$@"

$(src-dir-path)/%.c: $(CURDIR)/Makefile

clean:
	shopt -s dotglob && rm -fv $(dst-dir-path)/*

debug:
	gdb -x $(src-dir-path)/main.gdb --args $(exe-file-path)

format:
	clang-format --verbose -i $(src-dir-path)/*.c $(src-dir-path)/*.h

release: $(exe-file-path)
	strip $(exe-file-path)

info:
	echo "CC (C compiler): $(CC)"
	echo "CFLAGS (C compiler flags): $(CFLAGS)"
	echo "LDFLAGS (static linker flags): $(LDFLAGS)"

.PHONY: all clean debug format info run
.SILENT:

GNUMAKEFLAGS =
# Do not use make's built-in rules (-r/--no-builtin-rules) and variables (-R/--no-builtin-variables), as this increases performance and avoids hard-to-debug behaviour.
MAKEFLAGS += --no-builtin-rules
MAKEFLAGS += --no-builtin-variables
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Use bash as SHELL in recipes
SHELL := /bin/bash