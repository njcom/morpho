# nftables-parser (nft-parser)

nftables (nft) parser and ANTLR v4 grammar.

## About

This project contains nftables/nft ANTLR v4 grammar and generated Java parser. It is a port of the Flex and Bison grammars from the [nftables project](https://wiki.nftables.org/wiki-nftables/index.php/Main_Page) to ANTLR v4.

It can be used to parse .nft files used by the [`nft`](https://wiki.archlinux.org/title/nftables) command line tool, which is user space tool to manage the Linux kernel's firewall.

The project already contains generated parser for the Java, it can be found in the [dst](dst) directory.

ANTLR can generate parser for the following target languages:
* Java
* C#
* Python 2 and 3
* JavaScript
* Go
* C++
* Swift
* PHP
* Dart

In order to generate parser for other target language, change the `targetLang` in the [Makefile](Makefile) and run `make parser`.

The generated lexer and parser rely on a separate runtime library. To use the generated parser, the runtime library has to be installed. Each target language uses own runtime library. More information about the target languages can be found [here](https://github.com/antlr/antlr4/blob/master/doc/targets.md).

## Usage example for the Java target language

Here is an example of parsing file using the [already generated .java files](https://github.com/njcom/nftables-parser/tree/main/dst) for the Java:
```bash
#!/usr/bin/env bash

set -eu

[[ -d nftables-parser ]] || git clone --depth 1 https://github.com/njcom/nftables-parser.git

cat > ParserUsageSample.java <<'OUT'
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ParserUsageSample {
    public static void main(String[] args) throws IOException {
        String cwdDirPath = Paths.get(".").toAbsolutePath().normalize().toString();
        CharStream input = CharStreams.fromStream(System.in);
        NftablesLexer lexer = new NftablesLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NftablesParser parser = new NftablesParser(tokens);

        // Get root node
        ParseTree tree = parser.program();
        //System.out.println(tree.toStringTree(parser)); // print Lisp-style tree
        System.out.println(printSyntaxTree(parser, tree)); // print indented tree
    }

    // Next 2 methods have been taken from the https://stackoverflow.com/a/57747478
    private  static String printSyntaxTree(Parser parser, ParseTree root) {
        StringBuilder buf = new StringBuilder();
        dumpTree(root, buf, 0, Arrays.asList(parser.getRuleNames()));
        return buf.toString();
    }

    private static void dumpTree(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
        for (int i = 0; i < offset; i++) {
            buf.append("  ");
        }
        buf.append(Trees.getNodeText(aRoot, ruleNames)).append("\n");
        if (aRoot instanceof ParserRuleContext) {
            ParserRuleContext prc = (ParserRuleContext) aRoot;
            if (prc.children != null) {
                for (ParseTree child : prc.children) {
                    dumpTree(child, buf, offset + 1, ruleNames);
                }
            }
        }
    }
}
OUT

unset _JAVA_OPTIONS
# Compile .java to .class
javac -classpath /usr/share/java/antlr-complete.jar:nftables-parser/dst:. ParserUsageSample.java
# Run the .class file
cat nftables-parser/test/inet-filter.nft | java -classpath /usr/share/java/antlr-complete.jar:nftables-parser/dst:. ParserUsageSample
```
Save this as index.sh and run as `./index.sh`.

The following input:
```
table inet filter {
	chain input		{ type filter hook input priority 0; }
	chain forward		{ type filter hook forward priority 0; }
	chain output		{ type filter hook output priority 0; }
}
```
it generates the following output:
```
program
  line
    baseCmd
      addCmd
        table
        tableSpec
          familySpec
            familySpecExplicit
              inet
          identifier
            filter
        {
        tableBlock
          stmtSeparator
            

        tableBlock
          chain
          chainIdentifier
            identifier
              input
          {
          chainBlock
            hookSpec
              type
              filter
              hook
              input
              prioSpec
                priority
                extendedPrioSpec
                  intNum
                    0
            stmtSeparator
              ;
          }
          stmtSeparator
            

        tableBlock
          chain
          chainIdentifier
            identifier
              forward
          {
          chainBlock
            hookSpec
              type
              filter
              hook
              forward
              prioSpec
                priority
                extendedPrioSpec
                  intNum
                    0
            stmtSeparator
              ;
          }
          stmtSeparator
            

        tableBlock
          chain
          chainIdentifier
            identifier
              output
          {
          chainBlock
            hookSpec
              type
              filter
              hook
              output
              prioSpec
                priority
                extendedPrioSpec
                  intNum
                    0
            stmtSeparator
              ;
          }
          stmtSeparator
            

        }
    stmtSeparator
      

  <EOF>


```

The the available Java API can be found [here](https://www.antlr.org/api/Java/overview-summary.html).

The code for this example is stored in a separate git branch called [usage-sample](https://github.com/njcom/nftables-parser/tree/usage-sample).

## Current status

Right now it can parse successfully the all sample files from the [test directory](https://github.com/njcom/nftables-parser/tree/main/test).

## Automation and QA

* [![.github/workflows/test.yml](https://github.com/njcom/nftables-parser/actions/workflows/test.yml/badge.svg)](https://github.com/njcom/nftables-parser/actions/workflows/test.yml)
* [![.github/workflows/check-updates.yml](https://github.com/njcom/nftables-parser/actions/workflows/check-updates.yml/badge.svg)](https://github.com/njcom/nftables-parser/actions/workflows/check-updates.yml)

