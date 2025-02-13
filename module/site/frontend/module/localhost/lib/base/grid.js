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

class Grid extends Widget {
    checkAllCheckboxes() {
        this.checkboxes().prop('checked', true).trigger('change');
    }
    uncheckAllCheckboxes() {
        this.checkboxes().prop('checked', false).trigger('change');
    }
    checkedCheckboxes() {
        return this.checkboxes(':checked');
    }
    checkboxes(selector) {
        return this.el.find('.grid__chk' + (selector || ''));
    }
    isActionButtonDisabled() {
        const actionButtons = this.actionButtons();
        if (!actionButtons.length) {
            throw new Error("Empty action buttons");
        }
        return actionButtons.filter(':not(.disabled)').length === 0;
    }
    actionButtons() {
        return this.el.find('.grid__action-btn');
    }
    init() {
        super.init();
        this.initCheckboxes();
        this.initActionButtons();
    }
    bindHandlers() {
        super.bindHandlers();
    }
    unbindHandlers() {
        super.unbindHandlers();
    }
    initCheckboxes() {
        const selectAllCheckbox = this.selectAllCheckbox();
        const checkboxes = this.checkboxes();
        if (selectAllCheckbox.is(':checked') || (checkboxes.length && !checkboxes.not(selectAllCheckbox).not(':checked').length)) {
            this.checkAllCheckboxes();
        }
    }
    initActionButtons() {
    }
    selectAllCheckbox() {
        return this.el.find('.grid__chk-all');
    }
}

export { Grid };
//# sourceMappingURL=grid.js.map
