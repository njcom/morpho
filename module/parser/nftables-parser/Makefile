include $(CURDIR)/../../../index.mk

curDirPath := $(CURDIR)
relTestFilePath = load_balancing.nft
grammar := Nftables
targetLang := Java # PHP | Java | Python3
targetExt = java

include $(CURDIR)/../index.mk

test-nft-lexer:
	nft -d scanner -f $(inFilePath) 2>&1 | grep -v 'end of buffer or a NUL' | grep -Pv '\("\s+"\)' | less
.PHONY: test-nft-parser

