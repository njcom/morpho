(() => {
    let uniqId = 0;
    $.fn.once = function (fn) {
        let cssClass = String(uniqId++) + '-processed';
        return this.not('.' + cssClass)
            .addClass(cssClass)
            .each(fn);
    };
})();
$.resolvedPromise = function (value, ...args) {
    return $.Deferred().resolve(value, ...args).promise();
};
$.rejectedPromise = function (value, ...args) {
    return $.Deferred().reject(value, ...args).promise();
};
const __dummy = null;
$.fn.extend({
    uniqId: (function () {
        var uuid = 0;
        return function () {
            return this.each(function () {
                if (!this.id) {
                    this.id = "ui-id-" + (++uuid);
                }
            });
        };
    })(),
    removeUniqId: function () {
        return this.each(function () {
            if (/^ui-id-\d+$/.test(this.id)) {
                $(this).removeAttr("id");
            }
        });
    }
});

export { __dummy };
//# sourceMappingURL=jquery-ext.js.map
