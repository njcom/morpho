# Do not use make's built-in rules and variables (this increases performance and avoids hard-to-debug behaviour)
MAKEFLAGS += -rR
# Suppress "Entering directory ..." unless we are changing the work directory.
MAKEFLAGS += --no-print-directory
# Warning on undefined variables.
MAKEFLAGS += --warn-undefined-variables

distros := {debian,ubuntu,archlinux,alpine,centos,amazon-linux,fedora,rhel,suse,open-suse,nix-os,common}

init:
	mkdir -vp src/$(distros) rc/$(distros)/{home/user,etc} dst

test:
	for filePath in $$(echo $(CURDIR)/test/*); do $$filePath; done

.PHONY: init test
.SILENT:
