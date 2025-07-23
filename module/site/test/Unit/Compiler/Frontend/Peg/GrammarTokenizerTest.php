<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Compiler\Frontend\Peg;

use Iterator;
use Morpho\Compiler\Frontend\Peg\Token;
use Morpho\Compiler\Frontend\Peg\TokenException;
use Morpho\Compiler\Frontend\Peg\GrammarTokenizer;
use Morpho\Testing\TestCase;

class GrammarTokenizerTest extends TestCase {
    private GrammarTokenizer $tokenizer;

    protected function setUp(): void {
        parent::setUp();
        $this->tokenizer = new GrammarTokenizer();
    }

    public function testTokenize_EmptyString() {
        $this->assertTokensStr("Token(type=0 (EndMarker), value='', start=(1, 0), end=(1, 0), line='')", $this->tokenizer->__invoke(''));
    }

    public function testTokenize_Sample1() {
        $doubleQuote3 = '"""';
        $stream = $this->mkStream("@subheader $doubleQuote3\n");
        $tokens = $this->tokenizer->__invoke($stream);
        $this->assertTokensStr(
            <<<'EOF'
        Token(type=55 (Op), value='@', start=(1, 0), end=(1, 1), line='@subheader """\n')
        Token(type=1 (Name), value='subheader', start=(1, 1), end=(1, 10), line='@subheader """\n')
        EOF,
            $tokens,
            new TokenException('EOF in multi-line string', [1, 11])
        );
    }

    public function testTokenize_Sample2() {
        $s = <<<'EOF'
'(' "memo" ')' { "memo" }
EOF;
        $stream = $this->mkStream(rtrim($s) . "\n\n");
        $tokens = $this->tokenizer->__invoke($stream);
        $this->assertTokensStr(
            <<<'EOF'
Token(type=3 (String), value="'('", start=(1, 0), end=(1, 3), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=3 (String), value='"memo"', start=(1, 4), end=(1, 10), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=3 (String), value="')'", start=(1, 11), end=(1, 14), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=55 (Op), value='{', start=(1, 15), end=(1, 16), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=255 (GrammarAction), value=' "memo" ', start=(1, 16), end=(1, 24), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=55 (Op), value='}', start=(1, 24), end=(1, 25), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=4 (NewLine), value='\n', start=(1, 25), end=(1, 26), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=65 (ContinuedNewLine), value='\n', start=(2, 0), end=(2, 1), line='\n')
Token(type=0 (EndMarker), value='', start=(3, 0), end=(3, 0), line='')
EOF,
            $tokens
        );
    }

    public function testTokenize_Sample3() {
        $s = "+\n";
        $stream = $this->mkStream($s);
        $tokens = $this->tokenizer->__invoke($stream);
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=55 (Op), value='+', start=(1, 0), end=(1, 1), line='+\n')
            Token(type=4 (NewLine), value='\n', start=(1, 1), end=(1, 2), line='+\n')
            Token(type=0 (EndMarker), value='', start=(2, 0), end=(2, 0), line='')
            EOF,
            $tokens
        );
    }

    public function testTokenize_NewLine() {
        $stream = $this->mkStream("\n\n");
        $tokens = $this->tokenizer->__invoke($stream);
        #d(Peg::prettyPrintTokens($tokens));
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=65 (ContinuedNewLine), value='\n', start=(1, 0), end=(1, 1), line='\n')
            Token(type=65 (ContinuedNewLine), value='\n', start=(2, 0), end=(2, 1), line='\n')
            Token(type=0 (EndMarker), value='', start=(3, 0), end=(3, 0), line='')
            EOF,
            $tokens
        );
    }

    public function testTokenize_NewLine2(): void {
        $grammarCode = "start: instructions\n\n";
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=1 (Name), value='start', start=(1, 0), end=(1, 5), line='start: instructions\n')
            Token(type=55 (Op), value=':', start=(1, 5), end=(1, 6), line='start: instructions\n')
            Token(type=1 (Name), value='instructions', start=(1, 7), end=(1, 19), line='start: instructions\n')
            Token(type=4 (NewLine), value='\n', start=(1, 19), end=(1, 20), line='start: instructions\n')
            Token(type=65 (ContinuedNewLine), value='\n', start=(2, 0), end=(2, 1), line='\n')
            Token(type=0 (EndMarker), value='', start=(3, 0), end=(3, 0), line='')
            EOF,
            $this->tokenizer->__invoke($grammarCode)
        );
    }

    public function testTokenize_GrammarAction() {
        $s = <<<'EOF'
        target_atom[str]:
            | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }
        EOF;
        $stream = $this->mkStream(rtrim($s) . "\n\n");
        $tokens = $this->tokenizer->__invoke($stream);
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=1 (Name), value='target_atom', start=(1, 0), end=(1, 11), line='target_atom[str]:\n')
            Token(type=55 (Op), value='[', start=(1, 11), end=(1, 12), line='target_atom[str]:\n')
            Token(type=1 (Name), value='str', start=(1, 12), end=(1, 15), line='target_atom[str]:\n')
            Token(type=55 (Op), value=']', start=(1, 15), end=(1, 16), line='target_atom[str]:\n')
            Token(type=55 (Op), value=':', start=(1, 16), end=(1, 17), line='target_atom[str]:\n')
            Token(type=4 (NewLine), value='\n', start=(1, 17), end=(1, 18), line='target_atom[str]:\n')
            Token(type=5 (Indent), value='    ', start=(2, 0), end=(2, 4), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='|', start=(2, 4), end=(2, 5), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=3 (String), value='"{"', start=(2, 6), end=(2, 9), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='~', start=(2, 10), end=(2, 11), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=1 (Name), value='atoms', start=(2, 12), end=(2, 17), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='=', start=(2, 17), end=(2, 18), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=1 (Name), value='target_atoms', start=(2, 18), end=(2, 30), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='?', start=(2, 30), end=(2, 31), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=3 (String), value='"}"', start=(2, 32), end=(2, 35), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='{', start=(2, 36), end=(2, 37), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=255 (GrammarAction), value=' "{" + (atoms or "") + "}" ', start=(2, 37), end=(2, 64), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=55 (Op), value='}', start=(2, 64), end=(2, 65), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=4 (NewLine), value='\n', start=(2, 65), end=(2, 66), line='    | "{" ~ atoms=target_atoms? "}" { "{" + (atoms or "") + "}" }\n')
            Token(type=65 (ContinuedNewLine), value='\n', start=(3, 0), end=(3, 1), line='\n')
            Token(type=6 (Dedent), value='', start=(4, 0), end=(4, 0), line='')
            Token(type=0 (EndMarker), value='', start=(4, 0), end=(4, 0), line='')
            EOF,
            $tokens
        );
    }

    public function testTokenize_MetaGrammar() {
        $metaGrammarFilePath = dirname(new \ReflectionClass(GrammarTokenizer::class)->getFileName()) . '/rc/meta.gram';
        $stream = $this->mkStream(rtrim(file_get_contents($metaGrammarFilePath)) . "\n");
        $actualTokens = $this->tokenizer->__invoke($stream);
        $expectedTokens = file_get_contents($this->getTestDirPath() . '/meta-grammar-tokens');
        $this->checkTokens($expectedTokens, $actualTokens);
    }

    public function testTokenize_ErrorTokenInsteadOfOpToken_Bug() {
        $grammar = 'start: foo?';
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=1 (Name), value='start', start=(1, 0), end=(1, 5), line='start: foo?')
            Token(type=55 (Op), value=':', start=(1, 5), end=(1, 6), line='start: foo?')
            Token(type=1 (Name), value='foo', start=(1, 7), end=(1, 10), line='start: foo?')
            Token(type=55 (Op), value='?', start=(1, 10), end=(1, 11), line='start: foo?')
            Token(type=4 (NewLine), value='', start=(1, 11), end=(1, 12), line='start: foo?')
            Token(type=0 (EndMarker), value='', start=(2, 0), end=(2, 0), line='')
            EOF,
            $this->tokenizer->__invoke($grammar)
        );
    }

    private function checkTokens(string $expectedTokens, iterable $actualTokens): void {
        $actualTokensAsString = '';
        foreach ($actualTokens as $token) {
            $this->assertInstanceOf(Token::class, $token);
            $actualTokensAsString .= $token . "\n";
        }
        $this->assertSame($expectedTokens, $actualTokensAsString);
        $this->assertNotEmpty($actualTokensAsString);
    }

    private function tokensToStr(Iterator $tokens): string {
        $result = '';
        foreach ($tokens as $token) {
            $result .= (string) $token . "\n";
        }
        return $result;
    }

    private function assertTokensStr(string $expected, Iterator $tokens, TokenException|null $expectedEx = null): void {
        $expected = explode("\n", trim($expected));
        $j = 0;
        try {
            foreach ($tokens as $i => $token) {
                $this->assertSame($expected[$i], (string) $token, 'j = ' . $j);
                $j++;
            }
        } catch (TokenException $actualEx) {
            if ($expectedEx) {
                $this->assertSame($expectedEx->getMessage(), $actualEx->getMessage());
            } else {
                throw $actualEx;
            }
        }
        $this->assertSame($j, count($expected));
    }
}