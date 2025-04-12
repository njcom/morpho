include prelude.mk

define make-for-modules
	for module_dir_path in $(shell find module -mindepth 1 -maxdepth 1 -type d); do echo Running \`make $1\` in $$module_dir_path; make -C $$module_dir_path -f ci-cd.mk $(1); echo ---; done
endef

ci-cd-build:
	$(call make-for-modules,$@)
.PHONY: ci-cd-build

ci-cd-test:
	$(call make-for-modules,$@)
.PHONY: ci-cd-test

ci-cd-deploy:
	$(call make-for-modules,$@)
.PHONY: ci-cd-deploy

ci-cd-cron-daily:
	$(call make-for-modules,$@)
.PHONY: ci-cd-cron-daily

###############################################################################

#index:
#	mkdir -p $(CURDIR)/index/toolchain
#	for tool in make; do \
#		ln -vsrfn $(CURDIR)/module/$$tool $(CURDIR)/index/toolchain/$$tool; \
#	done
#.PHONY: index

#################################################################################
## Todo

image := localhost/morpho/ci-cd

run:
	test -b /tmp/block-dev-test || sudo mknod -m 0777 /tmp/block-dev-test b 125 1
	docker run --device /tmp/block-dev-test:/tmp/block-dev-test -it $(image)
.PHONY: run

build:
	docker build -t $(image) .
.PHONY: build