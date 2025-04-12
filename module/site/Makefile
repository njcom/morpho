include $(CURDIR)/../../prelude.mk

#backend-dir-path := $(CURDIR)/backend
frontend-dir-path := $(CURDIR)/frontend

################################################################################
## Tests

#setup:
#	composer require --dev psalm/plugin-phpunit
#	vendor/bin/psalm-plugin enable psalm/plugin-phpunit
#	composer update
#	bin/js setup

test:
	bin/test

# Unit tests
unit-test:
	bin/test test/Unit/TestSuite.php

integration-test:
	bin/test test/Integration/TestSuite.php

#backend-test: module-test
#module-test:
#	bin/test $(backend-dir-path)

# todo: frontend tests
frontend-test:
	echo todo
	exit 1

lint:
	php test/lint.php

###############################################################################
## Assets

assets: js css

js:
	bin/js build

watch-js:
	bin/js watch

css:
	bin/css build

watch-css:
	sass --watch $(frontend-dir-path)/module/localhost

clean: clean-assets

clean-css:
	find $(frontend-dir-path)/module/localhost -mindepth 1 \( -name '*.css' -or -name '*.css.map' \) -not -path '*/node_modules/*' -print -delete

clean-js:
	$(CURDIR)/bin/js clean

clean-assets: clean-css clean-js

###############################################################################
## Pods and containers

run-nginx:
	-podman pod create --name nginx-pod -p 127.0.0.1:8800:80
	podman run -d -it --pod nginx-pod --name nginx-container -v $(CURDIR)/mnt/nginx docker.io/library/nginx:1.27.0

run-php:
	-podman pod create --name php-pod -p 127.0.0.1:8801:9000
	podman run -d -it --pod php-pod --name php-container docker.io/laradock/php-fpm:20240413-8.3

run-mariadb:
	-podman pod create --name mariadb-pod -p 127.0.0.1:8802:3306
	podman run -d -it --pod mariadb-pod --name mariadb-container docker.io/library/mariadb:11.4.2

run: run-nginx run-php run-mariadb

clean-images:
	podman rmi --all --force

clean-containers:
	podman pod stop -a
	podman pod rm -a

clean-container-env:
	# podman system ...

################################################################################

#clean: clean-assets
#	sudo sh -c 'rm -rf test/Integration/*.log $(backend-dir-path)/localhost/{log,cache}/*'

#clean-routes:
#	sudo sh -c 'rm -rfv $(backend-dir-path)/localhost/cache/router'

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

setup: update-peg
	composer require --dev psalm/plugin-phpunit
	vendor/bin/psalm-plugin enable psalm/plugin-phpunit
	composer update
	bin/js setup

.PHONY: test unit-test integration-test frontend-test lint assets js watch-js css watch-css clean clean-css clean-js clean-assets run-nginx run-php run-mariadb run clean-images clean-containers clean-container-env update-peg setup