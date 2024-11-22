<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Test\Unit\App\Web\View;

use Morpho\App\Web\View\RcProcessor;
use Morpho\App\Web\View\TemplateEngine;
use Morpho\Testing\TestCase;
use Override;
use PHPUnit\Framework\Attributes\BackupGlobals;
use PHPUnit\Framework\Attributes\DataProvider;

class RcProcessorTest extends TestCase {
    private RcProcessor $processor;

    protected function setUp(): void {
        parent::setUp();
        $this->processor = new RcProcessor(new TemplateEngine(function () {}, [], true));
    }

    public function testHandlingOfScripts_InChildParentPages() {
        $childPage = <<<OUT
This
<script src="/foo/child.js"></script>
is a child
OUT;

        // processor should save child scripts
        $this->assertMatchesRegularExpression('~^This\\s+is a child$~', $this->processor->__invoke($childPage));

        $parentPage = <<<OUT
<body>
This is a
<script src="/bar/parent.js"></script>
parent
</body>
OUT;
        // And now render them for <body>
        $html = $this->processor->__invoke($parentPage);

        $re = $this->escapeRe(
            [
                '<body>',
                'This is a',
                'parent',
                '<script src="/bar/parent.js"></script>',
                '<script src="/foo/child.js"></script>',
                '</body>',
            ]
        );

        $this->assertMatchesRegularExpression($re, $html);
    }

    public function testIndexAttrNotEmpty() {
        $this->assertNotEmpty($this->processor->indexAttr);
    }

    public function testHandlingOfScripts_IndexAttribute() {
        $childPage = <<<OUT
This
<script src="foo/child.js"></script>
is a child
OUT;

        // processor should save child scripts
        $html = $this->processor->__invoke($childPage);
        $this->assertStringNotContainsString('<script', $html);

        $indexAttr = $this->processor->indexAttr;
        $parentPage = <<<OUT
<body>
This is a
<script src="bar/parent.js" {$indexAttr}="100"></script>
parent
</body>
OUT;
        // And now render them for <body>
        $html = $this->processor->__invoke($parentPage);

        $re = $this->escapeRe(
            [
                '<body>',
                'This is a',
                'parent',
                '<script src="foo/child.js"></script>',
                '<script src="bar/parent.js"></script>',
                '</body>',
            ]
        );
        $this->assertMatchesRegularExpression($re, $html);
    }

    public static function dataRemovesSkipAttribute() {
        return [
            [
                'body',
            ],
            [
                'script',
            ],
        ];
    }

    #[DataProvider('dataRemovesSkipAttribute')]
    public function testRemovesSkipAttribute($tag) {
        $html = '<' . $tag . ' _skip></' . $tag . '>';
        $this->assertSame("<$tag></$tag>", trim($this->processor->__invoke($html)));
    }

    public function testSkipsScriptsWithUnknownType() {
        $html = '<script type="text/template">foo</script>';
        $processed = $this->processor->__invoke($html);
        $this->assertSame($html, $processed);
    }

    private function escapeRe(array $parts): string {
        return '~^' . implode('\s*', array_map(preg_quote(...), $parts)) . '$~s';
    }
}
