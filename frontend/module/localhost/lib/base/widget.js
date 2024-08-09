class EventManager {
    handlers = {};
    on(eventName, handler) {
        this.handlers[eventName] = this.handlers[eventName] || [];
        this.handlers[eventName].push(handler);
    }
    trigger(eventName, ...args) {
        let handlers = this.handlers[eventName];
        if (!handlers) {
            return;
        }
        for (let i = 0; i < handlers.length; ++i) {
            if (false === handlers[i](...args)) {
                break;
            }
        }
    }
}

class Widget extends EventManager {
    el;
    conf;
    constructor(conf) {
        super();
        this.conf = this.normalizeConf(conf);
        this.init();
        this.bindHandlers();
    }
    dispose() {
        this.unbindHandlers();
    }
    init() {
        if (this.conf && this.conf.el) {
            this.el = $(this.conf.el);
        }
    }
    bindHandlers() {
    }
    unbindHandlers() {
    }
    normalizeConf(conf) {
        if (conf instanceof jQuery) {
            return { el: conf };
        }
        return conf;
    }
}
function okToast(text) {
    Toastify({
        text: text,
        backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
        className: "info",
    }).showToast();
}
function errorToast(text = undefined) {
    Toastify({
        text: text || 'Error.',
        backgroundColor: "linear-gradient(to right, #ff5f6d, #ffc371)",
        className: "info",
    }).showToast();
}
function showResponseErr(response) {
    if (response.err && typeof response.err == 'string') {
        errorToast(response.err);
    }
    else {
        errorToast();
    }
}

export { Widget, errorToast, okToast, showResponseErr };
//# sourceMappingURL=widget.js.map
