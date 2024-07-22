include $(CURDIR)/common.mk

ci-test:
	for module in gcc make meta pkg; do \
		echo Running ci-test for the $$module...; \
		make -C module/$$module ci-test; \
	done

pull-meta:
	module/meta/task/pull-meta/index

index:
	mkdir -p $(CURDIR)/index/tech
	for tech in make; do \
		ln -vsrfn $(CURDIR)/module/$$tech $(CURDIR)/index/tech/$$tech; \
	done

.PHONY: ci-test pull-meta index