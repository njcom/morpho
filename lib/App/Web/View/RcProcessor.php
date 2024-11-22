<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App\Web\View;

use function implode;
use function usort;

class RcProcessor extends HtmlSemiParser {
    public string $skipAttr = '_skip';
    public string $indexAttr = '_index';

    private array $scriptTags = [];
    private array $cssLinkTags = [];

    protected function containerHead(array $tag): array|false|null|string {
        if (isset($tag[$this->skipAttr])) {
            unset($tag[$this->skipAttr]);
            return $tag;
        }
        if ($this->cssLinkTags) {
            $tag['_text'] .= implode("\n", array_map($this->renderTag(...), $this->sortTags($this->cssLinkTags)));
        }
        return $tag;
    }

    protected function containerBody(array $tag): array|false|null|string {
        if (isset($tag[$this->skipAttr])) {
            unset($tag[$this->skipAttr]);
            return $tag;
        }
        $prevTags = $this->scriptTags;
        $this->scriptTags = [];
        $html = $this->__invoke($tag['_text']); // Render the parent page, extract and collect all scripts from it into $this->scriptTags
        $tag['_text'] = $html . $this->renderBodyScriptTags($this->sortTags(array_merge($this->scriptTags, $prevTags)));
        return $tag;
    }

    protected function containerScript(array $tag): array|false|null|string {
        if (isset($tag[$this->skipAttr])) {
            unset($tag[$this->skipAttr]);
            return $tag; // change tag
        }
        if (!isset($tag['type']) || ($tag['type'] == 'text/javascript' || $tag['type'] == 'module')) {
            $this->scriptTags[] = $tag;
            return false;  // remove the original tag, we will add it later.
        }
        return null; // do nothing
    }

    protected function tagLink(array $tag): array|false|null|string {
        if (isset($tag[$this->skipAttr])) {
            unset($tag[$this->skipAttr]);
            return $tag; // change tag
        }
        if (isset($tag['rel']) && $tag['rel'] == 'stylesheet') {
            $this->cssLinkTags[] = $tag;
            return false;
        }
        return null;
    }

    /**
     * Includes a file for controller's action.

    public function actionScripts(string $jsModuleId): array {
        $siteConf = $this->site->conf();
        $shortModuleName = last($this->site->moduleName, '/');
        $fullJsModuleId = $shortModuleName . '/' . LIB_DIR_NAME . '/app/' . $jsModuleId;
        $relFilePath = $fullJsModuleId . '.js';
        $jsFilePath = $siteConf['paths']['frontendModuleDirPath'] . '/' . $relFilePath;
        $scripts = [];
        if (file_exists($jsFilePath)) {
            $jsConf = $this->jsConf();
            $scripts[] = [
                'src' => '/' . $relFilePath, // Prepend with '/' to prepend base URI path later
                '_tagName' => 'script',
                '_text' => '',
            ];
            $scripts[] = [
                '_tagName' => 'script',
                '_text'    => 'define(["require", "exports", "' . $fullJsModuleId . '"], function (require, exports, module) { if (!window.app) window.app = {}; module.main(window.app, ' . json_encode($jsConf, JSON_UNESCAPED_SLASHES) . '); });',
            ];
        }
        return $scripts;
    }


    protected function jsConf(): array {
        $request = $this->request;
        if (isset($request['jsConf'])) {
            return (array)$request['jsConf'];
        }
        return [];
    }
 */
    protected function sortTags(array $tags): array {
        // Add indexes for scripts
        $index = 0;
        foreach ($tags as $key => $script) {
            if (!isset($script[$this->indexAttr])) {
                $script[$this->indexAttr] = $index;
                $index++;
            }
            $script[$this->indexAttr] = floatval($script[$this->indexAttr]);
            $tags[$key] = $script;
        }
        // Then sort them by index
        usort(
            $tags,
            function ($prev, $next) {
                $a = $prev[$this->indexAttr];
                $b = $next[$this->indexAttr];
                $diff = $a - $b;
                if (abs($diff) <= PHP_FLOAT_EPSILON && isset($prev['src']) && isset($next['src'])) {
                    // Without this sort an exact order can be unknown when indexes are equal.
                    return $prev['src'] <=> $next['src'];
                }
                if ($diff > PHP_FLOAT_EPSILON) {
                    return 1;
                }
                if ($diff >= -PHP_FLOAT_EPSILON) { // -PHP_FLOAT_EPSILON <= $diff <= PHP_FLOAT_EPSILON
                    return 0;
                }
                return -1; // $diff < -PHP_FLOAT_EPSILON
            }
        );
        return $tags;
    }

    /*
    protected function renderScripts(array $scripts): string {
        $html = [];
        foreach ($scripts as $tag) {
            /* @todo: Already done in UriProcessor?
             * if (isset($tag['src'])) {
             * $tag['src'] = $this->request->prependWithBasePath($tag['src'])->toStr(null, false);
             * }* /
            unset($tag[$this->indexAttr]);
            $html[] = $this->renderTag($tag);
        }
        return implode("\n", $html);
    }

    private function changeBodyScripts(array $scripts): array {
        $scripts = $this->sortTags($scripts);
        $event = new Event('beforeRenderScripts', $scripts);
        $event['caller'] = $this;
        //$event->caller = $this;
        $this->trigger($event);
        unset($event['caller']);
        return $event->getArrayCopy();
    }
    */
    private function renderBodyScriptTags(array $scriptTags): string {
        $scriptPaths = [];
        $html = '';
        foreach ($scriptTags as $script) {
            $html .= $this->renderTag($script);

            /*
            $scriptPaths[] = $script['src'];
            $html .= '<script src="' . TemplateEngine::e($script['src']) . '"
            */
        }
        /*
        $args = [
            '--build $baseDirPath . /module/localhost/ui/frontend/lib/app/tsconfig.json',
        ];
        $args = [
            $baseDirPath . '/module/localhost/lib/app/index.ts',
        ];
        $result = sh(escapeshellarg($this->tsCompilerFilePath) . ' ' . implode(' ', $args) . ' 2>&1', ['capture' => true, 'check' => false]);
        d($result, $scripts);
        */
        return $html;
    }
}
