ci-test:
	make -C module/parser ci-test

pull-meta:
	php task/pull-meta/index

.PHONY: ci-test pull-meta
.SILENT:
