include prelude.mk

define make-for-modules
	for module_dir_path in $(shell find module -mindepth 1 -maxdepth 1 -type d); do echo Running $1 in $$module_dir_path; make -C $$module_dir_path $(1); echo ---; done
endef

ci-cd-build:
	$(call make-for-modules,$@)

ci-cd-test:
	$(call make-for-modules,$@)

ci-cd-deploy:
	$(call make-for-modules,$@)

.PHONY: ci-cd-build ci-cd-test ci-cd-deploy
