include $(CURDIR)/../../prelude.mk

ci-cd-build:
.PHONY: ci-cd-build

ci-cd-test:
.PHONY: ci-cd-test

ci-cd-deploy:
.PHONY: ci-cd-deploy

ci-cd-cron-daily:
.PHONY: ci-cd-cron-daily

ci-cd-cron-daily: pull-meta
.PHONY: ci-cd-cron-daily

pull-meta:
	cd pull-meta && composer --ignore-platform-reqs --no-ansi --no-interaction install
	php pull-meta/index
.PHONY: pull-meta