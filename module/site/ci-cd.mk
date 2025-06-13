include $(CURDIR)/../../prelude.mk

ci-cd-build:
	$(CURDIR)/bin/build

ci-cd-test:
	$(CURDIR)/bin/lint
	MORPHO_CI=1 MORPHO_TEST_DB_HOST=127.0.0.1 MORPHO_TEST_DB_USER=$${MORPHO_TEST_DB_USER-root} MORPHO_TEST_DB_PASSWORD=$${MORPHO_TEST_DB_PASSWORD-root} MORPHO_TEST_DB_NAME=$${MORPHO_TEST_DB_NAME-test} $(CURDIR)/bin/test

ci-cd-deploy:
	$(CURDIR)/bin/deploy

ci-cd-cron-daily:
	#composer --ignore-platform-reqs --no-ansi --no-interaction install
	#$(MAKE) update-peg
.PHONY: ci-cd-cron-daily