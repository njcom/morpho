include $(CURDIR)/common.mk

ci-test:
	make -C module/* ci-test

pull-meta:
	module/meta/task/pull-meta/index

index:
	mkdir -p $(CURDIR)/index/tech
	for tech in gcc make; do \
		ln -vsrfn $(CURDIR)/module/$$tech $(CURDIR)/index/tech/$$tech; \
	done

.PHONY: ci-test pull-meta index
