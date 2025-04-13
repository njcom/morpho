include $(CURDIR)/../../prelude.mk

ci-cd-build:
	$(CURDIR)/bin/build

ci-cd-test:
	$(CURDIR)/bin/lint
	MORPHO_CI=1 MORPHO_TEST_DB_HOST=127.0.0.1 MORPHO_TEST_DB_USER=root MORPHO_TEST_DB_PASSWORD=root MORPHO_TEST_DB_NAME=test $(CURDIR)/bin/test

ci-cd-deploy:
	$(CURDIR)/bin/deploy

ci-cd-cron-daily:
	composer --ignore-platform-reqs --no-ansi --no-interaction install
	$(MAKE) update-peg
.PHONY: ci-cd-cron-daily

update-peg:
	curl -sSfLo $(CURDIR)/lib/Tool/Python/python.token 'https://raw.githubusercontent.com/python/cpython/refs/heads/3.12/Grammar/Tokens'
	echo "Written file $(CURDIR)/lib/Tool/Python/python.token"
	curl -sSfLo $(CURDIR)/lib/Tool/Python/python.gram 'https://raw.githubusercontent.com/python/cpython/refs/heads/3.12/Grammar/python.gram'
	echo "Written file $(CURDIR)/lib/Tool/Python/python.gram"
	curl -sSfLo $(CURDIR)/lib/Tool/Python/meta.gram 'https://raw.githubusercontent.com/python/cpython/refs/heads/3.12/Tools/peg_generator/pegen/metagrammar.gram'
	echo "Written file $(CURDIR)/lib/Tool/Python/meta.gram"
	target_file_path=$(CURDIR)/test/Unit/Compiler/Frontend/Peg/test-data/PythonTokenizerTest/meta-token \
		&& cat $(CURDIR)/lib/Tool/Python/meta.gram | $(CURDIR)/bin/peg gen-py-tokens > "$$target_file_path" \
		&& echo "Written file $$target_file_path"
.PHONY: update-peg