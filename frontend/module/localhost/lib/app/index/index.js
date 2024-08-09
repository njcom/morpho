import $ from 'jquery';
import { EditorView, keymap } from './@codemirror/view.js';
import { markdown, markdownKeymap } from './@codemirror/lang-markdown.js';
import { history, defaultKeymap, historyKeymap } from './@codemirror/commands.js';
import { syntaxHighlighting, defaultHighlightStyle } from './@codemirror/language.js';

function customKeymap() {
    return keymap.of([...defaultKeymap, ...markdownKeymap, ...historyKeymap]);
}
const prompt = `Hello World, it works!`;
new EditorView({
    doc: prompt,
    extensions: [
        markdown(),
        history(),
        syntaxHighlighting(defaultHighlightStyle),
        customKeymap(),
    ],
    parent: $('#chat')[0],
});
//# sourceMappingURL=index.js.map
