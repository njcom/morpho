Math.EPS = 0.000001;
Math.roundFloat = function (val, precision = 2) {
    const dd = Math.pow(10, precision);
    return Math.round(val * dd) / dd;
};
Math.floatLessThanZero = function (val) {
    return val < -Math.EPS;
};
Math.floatGreaterThanZero = function (val) {
    return val > Math.EPS;
};
Math.floatEqualZero = function (val) {
    return Math.abs(val) <= Math.EPS;
};
Math.floatsEqual = function (a, b) {
    return Math.floatEqualZero(a - b);
};
Math.logN = function (n, base) {
    return Math.log(n) / Math.log(base);
};
String.prototype.e = function () {
    const entityMap = {
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': '&quot;',
        "'": '&#39;'
    };
    return this.replace(/[&<>"']/g, function (s) {
        return entityMap[s];
    });
};
String.prototype.titleize = function () {
    return this.charAt(0).toUpperCase() + this.slice(1);
};
String.prototype.format = function (args, filter) {
    let val = this;
    args.forEach((arg, index) => {
        val = val.replace('{' + index + '}', filter ? filter(arg) : arg);
    });
    return val;
};
String.prototype.nl2Br = function () {
    return this.replace(/\r?\n/g, '<br>');
};
String.prototype.ucFirst = function () {
    return this.charAt(0).toUpperCase() + this.slice(1);
};
String.prototype.trimR = function (chars) {
    if (chars === undefined) {
        return this.replace(new RegExp('\\s+$'), '');
    }
    return this.replace(new RegExp("[" + RegExp.e(chars) + "]+$"), '');
};
String.prototype.trimL = function (chars) {
    if (chars === undefined) {
        return this.replace(new RegExp('^\\s+'), '');
    }
    return this.replace(new RegExp("^[" + RegExp.e(chars) + "]+"), '');
};
String.prototype.trimLR = function (chars) {
    if (chars == undefined) {
        return this.trim();
    }
    return this.trimL(chars).trimR(chars);
};
RegExp.e = function (s) {
    return String(s).replace(/[\\^$*+?.()|[\]{}]/g, '\\$&');
};
Object.pick = function (object, keys) {
    return keys.reduce((obj, key) => {
        if (object && object.hasOwnProperty(key)) {
            obj[key] = object[key];
        }
        return obj;
    }, {});
};
//# sourceMappingURL=bom.js.map
