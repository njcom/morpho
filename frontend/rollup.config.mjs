import {fileURLToPath} from 'node:url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

import path, {dirname} from 'node:path';
import * as fs from 'node:fs';
import typescript from '@rollup/plugin-typescript';
//import typescript from './rollup-plugin-typescript.mjs';
//import {rollupImportMapPlugin} from "rollup-plugin-import-map";
import {nodeResolve} from '@rollup/plugin-node-resolve';
import assert from "node:assert";
import {globSync as glob} from "glob";

// ----------------------------------------------------------------------------
// Global (common) library functions

function d(...args) {
    console.log(...args);
    process.exit(1);
}

function ensureTruthy(val) {
    if (!val) {
        throw new Error();
    }
    return val;
}

function changeExt(filePath, newExt) {
    const lastDotPos = filePath.lastIndexOf(".");
    if (lastDotPos < 0) {
        throw new Error('File extension not found in the file path');
    }
    return filePath.substring(0, lastDotPos) + '.' + newExt;
}

/*function findParentPackageDir(dirPath) {
    if (dirPath === '/') {
        throw new Error('Unable to find parent directory');
    }
    if (fs.existsSync(dirPath + '/node_modules') && fs.existsSync(dirPath + '/package.json')) {
        return dirPath;
    }
    return findParentPackageDir(dirname(dirPath));
}*/

// ----------------------------------------------------------------------------
// Local library functions.

function tsPluginOptions(inFilePath) {
    let tsConfFilePath = dirname(inFilePath) + '/tsconfig.json';
    if (!fs.existsSync(tsConfFilePath)) {
        tsConfFilePath = __dirname + '/tsconfig.json';
    }
    tsConfFilePath = ensureTruthy(fs.realpathSync(tsConfFilePath));
    return {
        tsconfig: tsConfFilePath,
        module: 'nodenext',
        filterRoot: dirname(tsConfFilePath),
        noEmitOnError: true,
    }
}

function conf(inFilePath, outDirPath, preserveModules) {
    let outputConf = {
        format: 'es',
        sourcemap: true,
        preserveModules,
        entryFileNames: (chunkInfo) => { // see also `chunkFileNames`
            assert(chunkInfo['type'] === 'chunk');
            if (chunkInfo['facadeModuleId'].endsWith('/node_modules/codemirror/dist/index.js')) {
                return 'codemirror.js';
            }
            const match = chunkInfo['facadeModuleId'].match(new RegExp('/node_modules/(?<module>@(codemirror|lezer)/[^/]+)/dist/index\\.js$'));
            if (match) {
                return match['groups']['module'] + '.js';
            }
            if (chunkInfo['facadeModuleId'].endsWith('/node_modules/style-mod/src/style-mod.js')) {
                return 'style-mod.js';
            }
            if (chunkInfo['facadeModuleId'].endsWith('/node_modules/w3c-keyname/index.js')) {
                return 'w3c-keyname.js';
            }
            if (chunkInfo['facadeModuleId'].endsWith('/node_modules/crelt/index.js')) {
                return 'crelt.js';
            }
            assert(chunkInfo['facadeModuleId'].startsWith('/') && chunkInfo['facadeModuleId'].endsWith('.ts'));
            assert(chunkInfo['facadeModuleId'].startsWith(outDirPath));
            return changeExt(path.relative(outDirPath, chunkInfo['facadeModuleId']), 'js');
        }
    };
    const checkOutputPath = (path) => {
        if (path.includes('/node_modules/')) {
            throw new Error('Invalid output path')
        }
        return path;
    };
    if (!outDirPath) {
        outDirPath = dirname(inFilePath);
    }
    outputConf.dir = checkOutputPath(outDirPath);
    return {
        plugins: [
            nodeResolve(),
            /*            rollupImportMapPlugin([
                            {
                                "imports": {
                                    "@codemirror/view": "/module/localhost/lib/app/chat/@codemirror/view.js",
                                    '@codemirror/lang-markdown': "/module/localhost/lib/app/chat/@codemirror/lang-markdown.js"
                                }
                            },
                        ]),*/
            typescript(tsPluginOptions(inFilePath))
        ],
        input: inFilePath,
        output: outputConf
    };
}

/*
function cmModule(name) {
    return {
        name: '@codemirror/' + name, src: 'dist/index.js',
    }
}

const npmModules = [
    {name: 'codemirror', src: 'dist/index.js'},
    cmModule('autocomplete'),
    cmModule('commands'),
    cmModule('language'),
    cmModule('lint'),
    cmModule('search'),
    cmModule('state'),
    cmModule('view'),
    cmModule('lang-javascript'),
    cmModule('lang-python'),
    cmModule('lang-markdown'),
    {name: 'style-mod', src: 'src/style-mod.js'},
    {name: '@lezer/common', src: 'dist/index.js'},
    {name: '@lezer/highlight', src: 'dist/index.js'},
    {name: '@lezer/python', src: 'dist/index.js'},
    {name: '@lezer/lr', src: 'dist/index.js'},
    {name: 'w3c-keyname', src: 'index.js'},
    {name: 'crelt', src: 'index.js'},
].map((module) => conf(__dirname + '/module/localhost/node_modules/' + module.name + '/' + module.src, __dirname + '/module/localhost/lib/app'/!* + module.name + '.js'*!/));
*/

function withJQueryConf(inFilePath, preserveModules) {
    let conf1 = conf(inFilePath, undefined, preserveModules);
    //conf1['output']['paths'] = {'jquery': '/module/localhost/lib/jquery.js'};
    conf1['external'] = 'jquery';
    return conf1;
}
//conf(__dirname + '/module/morpho/lib/app/index.ts'),
//conf(__dirname + '/module/morpho/lib/app/framework.ts'),
//export default npmModules.concat(localModules);

const libs = glob(__dirname + '/module/localhost/lib/base/*.ts')
    .map((inFilePath) => withJQueryConf(inFilePath, false));

const apps = [__dirname + '/module/localhost/lib/app/index/index.ts'].map((inFilePath) => withJQueryConf(inFilePath, true));

export default libs.concat(apps);

