<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\Compiler\Frontend\Peg;

use Iterator;
use Morpho\Compiler\Frontend\Peg\Peg;
use Morpho\Compiler\Frontend\Peg\Token;
use Morpho\Compiler\Frontend\Peg\TokenException;
use Morpho\Compiler\Frontend\Peg\PythonTokenizer;
use Morpho\Testing\TestCase;

use const Morpho\App\LIB_DIR_NAME;
use const Morpho\Test\BASE_DIR_PATH;

class PythonTokenizerTest extends TestCase {
    private PythonTokenizer $tokenizer;

    protected function setUp(): void {
        parent::setUp();
        $this->tokenizer = new PythonTokenizer();
    }

    public function testTokenize_EmptyString() {
        $this->assertTokensStr("Token(type=0 (ENDMARKER), string='', start=(1, 0), end=(1, 0), line='')", $this->tokenizer->tokenize(''));
    }

    public function testTokenize_Sample1() {
        $doubleQuote3 = '"""';
        $stream = $this->mkStream("@subheader $doubleQuote3\n");
        $tokens = $this->tokenizer->tokenize($stream);
        $this->assertTokensStr(
            <<<'EOF'
        Token(type=55 (OP), string='@', start=(1, 0), end=(1, 1), line='@subheader """\n')
        Token(type=1 (NAME), string='subheader', start=(1, 1), end=(1, 10), line='@subheader """\n')
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
        $tokens = $this->tokenizer->tokenize($stream);

        $this->assertTokensStr(
            <<<'EOF'
Token(type=3 (STRING), string="'('", start=(1, 0), end=(1, 3), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=3 (STRING), string='"memo"', start=(1, 4), end=(1, 10), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=3 (STRING), string="')'", start=(1, 11), end=(1, 14), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=55 (OP), string='{', start=(1, 15), end=(1, 16), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=3 (STRING), string='"memo"', start=(1, 17), end=(1, 23), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=55 (OP), string='}', start=(1, 24), end=(1, 25), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=4 (NEWLINE), string='\n', start=(1, 25), end=(1, 26), line='\'(\' "memo" \')\' { "memo" }\n')
Token(type=65 (NL), string='\n', start=(2, 0), end=(2, 1), line='\n')
Token(type=0 (ENDMARKER), string='', start=(3, 0), end=(3, 0), line='')
EOF,
            $tokens
        );
    }

    public function testTokenize_Sample3() {
        $s = "+\n";
        $stream = $this->mkStream($s);
        $tokens = $this->tokenizer->tokenize($stream);
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=55 (OP), string='+', start=(1, 0), end=(1, 1), line='+\n')
            Token(type=4 (NEWLINE), string='\n', start=(1, 1), end=(1, 2), line='+\n')
            Token(type=0 (ENDMARKER), string='', start=(2, 0), end=(2, 0), line='')
            EOF,
            $tokens
        );
    }

    public function testTokenize_NewLine() {
        $stream = $this->mkStream("\n\n");
        $tokens = $this->tokenizer->tokenize($stream);
        $this->assertTokensStr(
            <<<'EOF'
            Token(type=65 (NL), string='\n', start=(1, 0), end=(1, 1), line='\n')
            Token(type=65 (NL), string='\n', start=(2, 0), end=(2, 1), line='\n')
            Token(type=0 (ENDMARKER), string='', start=(3, 0), end=(3, 0), line='')
            EOF,
            $tokens
        );
    }

    public function testTokenize_MetaGrammar() {
        $stream = $this->mkStream(file_get_contents(BASE_DIR_PATH . '/' . LIB_DIR_NAME . '/Tool/Python/meta.gram'));
        $tokens = $this->tokenizer->tokenize($stream);
        $this->checkTokens(file_get_contents($this->getTestDirPath() . '/meta-token'), $tokens);
    }

    public function testTokenize_ErrorTokenBugForSpecificCase() {
        $grammar = 'start: foo?';
        $this->markTestIncomplete();
        d($this->tokensToStr($this->tokenizer->tokenize($grammar)));
/* Must produce
[TokenInfo(type=1 (NAME), string='start', start=(1, 0), end=(1, 5), line='start: foo?'),
 TokenInfo(type=55 (OP), string=':', start=(1, 5), end=(1, 6), line='start: foo?'),
 TokenInfo(type=1 (NAME), string='foo', start=(1, 7), end=(1, 10), line='start: foo?'),
 TokenInfo(type=55 (OP), string='?', start=(1, 10), end=(1, 11), line='start: foo?'),
 TokenInfo(type=4 (NEWLINE), string='', start=(1, 11), end=(1, 12), line='start: foo?'),
 TokenInfo(type=0 (ENDMARKER), string='', start=(2, 0), end=(2, 0), line='')]
 */
    }

    private function checkTokens(string $expected, iterable $tokens): void {
        $actual = '';
        foreach ($tokens as $token) {
            $this->assertInstanceOf(Token::class, $token);
            $actual .= $token . "\n";
        }
        $this->assertSame($expected, $actual);
        $this->assertNotEmpty($actual);
    }

    private function tokensToStr(Iterator $tokens): string {
        $result = '';
        foreach ($tokens as $token) {
            $result .= (string)$token . "\n";
        }
        return $result;
    }

    private function assertTokensStr(string $expected, Iterator $tokens, TokenException $expectedEx = null): void {
        $expected = explode("\n", trim($expected));
        $j = 0;
        try {
            foreach ($tokens as $i => $token) {
                $this->assertSame($expected[$i], (string)$token, 'j = ' . $j);
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