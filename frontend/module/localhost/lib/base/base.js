function id(value) {
    return value;
}
function lname(name) {
    name = name.replace('_', '-');
    name = name.replace(/[a-z][A-Z]/, function camelizeNextCh(match) {
        return match[0] + '-' + match[1].toLowerCase();
    });
    name = name.replace(/[^-A-Za-z.0-9]/, '-');
    name = name.replace(/-+/, '-');
    return name;
}
function isPromise(val) {
    return val && typeof val.promise === 'function';
}
function isDomNode(obj) {
    return obj && obj.nodeType > 0;
}
function isGenerator(fn) {
    return fn.constructor.name === 'GeneratorFunction';
}
class Re {
    static email = /^[^@]+@[^@]+$/;
}
function showUnknownError(message) {
    alert("Unknown error, please contact support");
}
function delayedCallback(callback, waitMs) {
    let timer = 0;
    return function () {
        const self = this;
        const args = arguments;
        clearTimeout(timer);
        timer = window.setTimeout(function () {
            callback.apply(self, args);
        }, waitMs);
    };
}

export { Re, delayedCallback, id, isDomNode, isGenerator, isPromise, lname, showUnknownError };
//# sourceMappingURL=base.js.map
