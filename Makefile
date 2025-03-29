include prelude.mk

build:

test:
	for module_dir_path in $(shell find module -mindepth 1 -maxdepth 1 -type d); do make -C $$module_dir_path $@; done

deploy:

.PHONY: build test deploy
