all:
	make -C nftables-parser parser
	make -C make-parser parser

ci-test:
	make -C nftables-parser ci-test
	make -C make-parser ci-test

.PHONY: ci-test
.SILENT:
