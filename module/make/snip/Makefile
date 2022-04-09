all: targets

targets:
	echo Targets:
	grep -oP '^[A-Za-z0-9_-]+:' $(CURDIR)/$(word $(words $(MAKEFILE_LIST)),$(MAKEFILE_LIST)) | tr -d : | perl -WpE 's/^/  /g'

.PHONY: all targets
.SILENT:
# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour).
MAKEFLAGS += -rR
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables
# Enable Bash features like brace expansion
SHELL := /bin/bash
