<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Php;

use Morpho\App\Web\PhpFileHeaderFixer;
use Morpho\Base\Err;
use Morpho\Base\NotImplementedException;
use Morpho\Base\Ok;
use Morpho\Base\Result;

use function Morpho\App\Cli\errorLine;
use function Morpho\App\Cli\showLine;
use function Morpho\App\Cli\showOk;
use function Morpho\Base\indent;
use function Morpho\Base\q;

class CliPhpFileHeaderFixer {
    public function __invoke(mixed $conf): mixed {
        throw new NotImplementedException();
        $result = null;
        foreach ($conf['files'] as [$filePaths, $context]) {
            $context['dryRun'] = $conf['dryRun'];
            $result = $this->fixFiles([$conf['constructArgs'] ?? null], $filePaths, $context, $result);
        }
        $this->showResult($result);
        return $result;
    }

    public function fixFiles(array $constructArgs, iterable $files, array $context, Result $prevResult = null): Result {
        $fixer = new PhpFileHeaderFixer(...$constructArgs);
        if ($prevResult) {
            $stats = $prevResult->value();
            $ok = $prevResult->isOk();
        } else {
            $stats = ['processed' => ['num' => 0], 'fixed' => ['num' => 0, 'filePaths' => []]];
            $ok = true;
        }
        foreach ($files as $filePath) {
            showLine("Processing file " . q($filePath) . '...');
            $result = $fixer->__invoke(array_merge($context, ['filePath' => $filePath]));
            if (!$result->isOk()) {
                errorLine("Unable to fix the file " . q($filePath) . "\n" . print_r($result, true));
            }
            if (isset($result->value()['text'])) {
                showLine(indent($result->value()['text']));
                $stats['fixed']['num']++;
                $stats['fixed']['filePaths'][] = $filePath;
            }
            $stats['processed']['num']++;
            showOk();
            $ok = $result->isOk() && $ok;
        }
        return $ok ? new Ok($stats) : new Err($stats);
    }

    public function showResult(Result $result): void {
        showLine("\nNumber of processed files: " . $result->value()['processed']['num']);
        showLine("Number of fixed files: " . $result->value()['fixed']['num']);
        showLine(
            "List of fixed files: " . ($result->value()['fixed']['num'] > 0 ? "\n" . indent(
                    implode("\n", $result->value()['fixed']['filePaths']),
                    4
                ) : '-')
        );
    }
}
