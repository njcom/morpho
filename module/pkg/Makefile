include $(CURDIR)/../../common.mk

all:
	echo todo

lint:
	find $(CURDIR) -name '*.sh' -type f -exec shellcheck --norc --enable=all --shell=bash --severity=style {} \;

ci-test:

.PHONY: lint all
