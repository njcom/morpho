<?php declare(strict_types=1);
/**
 * This file is part of morpho-os/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\App;

$baseDirPath = realpath(__DIR__ . '/..');
return [
    'siteFactory' => function (App $app) {
        return PHP_SAPI === 'cli' ? new Cli\SiteFactory($app->conf) : new Web\SiteFactory($app->conf);
    },
    'sites' => [
        [
            'name'  => VENDOR . '/localhost',
            'hosts' => [
                'framework',
                'localhost',
                '127.0.0.1'
            ],
            'paths' => [
                'dirPath'      => $baseDirPath . '/' . MODULE_DIR_NAME . '/localhost',
                'confFilePath' => $baseDirPath . '/' . MODULE_DIR_NAME . '/localhost/' . CONF_DIR_NAME . '/' . SITE_CONF_FILE_NAME,
            ],
        ],
    ],
];
