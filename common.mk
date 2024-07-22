# Common code for the all Makefiles.

.DEFAULT_GOAL := show-targets

show-targets: ## Show available targets
	echo Targets:
	grep -oP '^[A-Za-z0-9_-]+:' $(MAKEFILE_LIST) | awk -F':' '{print $$(NF-1)}' | perl -WpE 's/^/    /g'

# `help` taken from [containerd](https://github.com/containerd/containerd/blob/master/Makefile)
help: ## This help
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

unexport _JAVA_OPTIONS

.PHONY: help show-targets
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