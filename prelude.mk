###############################################################################
# `make` tweaks

unexport _JAVA_OPTIONS

.PHONY: all test unit-test integration-test frontend-test lint assets js watch-js css watch-css clean clean-css clean-js clean-assets run-nginx run-php run-mariadb run clean-images clean-containers update-peg setup init help targets
.SILENT:
# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour).
MAKEFLAGS += -rR
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Use bash as SHELL in recipes
SHELL := /bin/bash -eu
#.DEFAULT_GOAL = all
.DEFAULT_GOAL = targets

###############################################################################
# Help

## todo: merge `targets` logic with the `help` logic into the `help` target

# `help` taken from [containerd](https://github.com/containerd/containerd/blob/master/Makefile)
help: ## This help
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

targets: ## Show available targets
	echo Targets:
	grep -oP '^[A-Za-z0-9_-]+:' $(MAKEFILE_LIST) | awk -F':' '{print $$(NF-1)}' | perl -WpE 's/^/    /g'

###############################################################################

define dl
	curl -sSfL $(1) -o $(2)
endef
