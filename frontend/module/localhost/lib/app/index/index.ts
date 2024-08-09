//import {App} from "../base/app";
//window.app = new App();

import $ from "jquery";
//window.$ = window.jQuery = jQuery;


import {EditorState, Extension} from '@codemirror/state'
import { EditorView, keymap } from '@codemirror/view'
import { markdown, markdownKeymap } from '@codemirror/lang-markdown'
import { defaultKeymap, history, historyKeymap } from '@codemirror/commands'
import { defaultHighlightStyle, syntaxHighlighting } from '@codemirror/language'
//import doc from './doc.md'

function customKeymap(): Extension {
    return keymap.of([...defaultKeymap, ...markdownKeymap, ...historyKeymap]);
}

const prompt = `Hello World, it works!`;

const view = new EditorView({
    doc: prompt,
    extensions: [
        markdown(),
        history(),
        syntaxHighlighting(defaultHighlightStyle),
        customKeymap(),
    ],
    parent: $('#chat')[0],
})


