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

var MessageType;
(function (MessageType) {
    MessageType[MessageType["Error"] = 1] = "Error";
    MessageType[MessageType["Warning"] = 2] = "Warning";
    MessageType[MessageType["Info"] = 4] = "Info";
    MessageType[MessageType["Debug"] = 8] = "Debug";
    MessageType[MessageType["All"] = 15] = "All";
})(MessageType || (MessageType = {}));
function renderMessage(message) {
    let text = message.text.encodeHtml();
    text = text.format(message.args);
    return wrapMessage(text, messageTypeToStr(message.type));
}
function wrapMessage(text, type) {
    return '<div class="' + type.toLowerCase().encodeHtml() + '">' + text + '</div>';
}
function messageTypeToStr(type) {
    return MessageType[type];
}
class Message {
    type;
    text;
    args;
    constructor(type, text, args = []) {
        this.type = type;
        this.text = text;
        this.args = args;
    }
    hasType(type) {
        return this.type === type;
    }
}
class ErrorMessage extends Message {
    constructor(text, args = []) {
        super(MessageType.Error, text, args);
    }
}

var RestAction;
(function (RestAction) {
    RestAction["Delete"] = "delete";
})(RestAction || (RestAction = {}));
function redirectTo(uri, storePageInHistory = true) {
    if (storePageInHistory) {
        window.location.href = uri;
    }
    else {
        window.location.replace(uri);
    }
}

class RequiredElValidator {
    static EmptyValueMessage = 'This field is required';
    validate($el) {
        if (Form.isRequiredEl($el)) {
            if (Form.elValue($el).trim().length < 1) {
                return [RequiredElValidator.EmptyValueMessage];
            }
        }
        return [];
    }
}
function defaultValidators() {
    return [
        new RequiredElValidator()
    ];
}
function validateEl($el, validators) {
    if (!validators) {
        validators = defaultValidators();
    }
    let errors = [];
    validators.forEach(function (validator) {
        errors = errors.concat(validator.validate($el));
    });
    return errors;
}
function formData($form) {
    const data = [];
    els($form).each((index, node) => {
        const name = node.getAttribute('name');
        if (!name) {
            return;
        }
        data.push({
            name,
            value: Form.elValue($(node))
        });
    });
    return data;
}
function forEachEl($form, fn) {
    return els($form).each(function (index, el) {
        if (false === fn($(el), index)) {
            return false;
        }
        return undefined;
    });
}
function els($form) {
    return $($form[0].elements);
}
var FieldType;
(function (FieldType) {
    FieldType["Button"] = "button";
    FieldType["Checkbox"] = "checkbox";
    FieldType["File"] = "file";
    FieldType["Hidden"] = "hidden";
    FieldType["Image"] = "image";
    FieldType["Password"] = "password";
    FieldType["Radio"] = "radio";
    FieldType["Reset"] = "reset";
    FieldType["Select"] = "select";
    FieldType["Submit"] = "submit";
    FieldType["Textarea"] = "textarea";
    FieldType["Textfield"] = "text";
})(FieldType || (FieldType = {}));
const elChangeEvents = 'keyup blur change paste cut';
class Form extends Widget {
    static defaultInvalidCssClass = 'invalid';
    skipValidation;
    elContainerCssClass;
    formMessageContainerCssClass;
    invalidCssClass;
    elChangeEvents;
    static elValue($el) {
        if ($el.get(0)['type'] === 'checkbox') {
            return $el.is(':checked') ? 1 : 0;
        }
        return $el.val();
    }
    static isRequiredEl($el) {
        return $el.is('[required]');
    }
    els() {
        return els(this.el);
    }
    elsToValidate() {
        return this.els().filter(function () {
            const $el = $(this);
            return $el.is(':not(:submit)');
        });
    }
    validate() {
        this.removeErrors();
        let errors = [];
        this.elsToValidate().each(function () {
            const $el = $(this);
            const elErrors = validateEl($el);
            if (elErrors.length) {
                errors.push([$el, elErrors.map((error) => { return new ErrorMessage(error); })]);
            }
        });
        if (errors.length) {
            this.showErrors(errors);
            return false;
        }
        return true;
    }
    invalidEls() {
        const self = this;
        return this.els().filter(function () {
            return $(this).hasClass(self.invalidCssClass);
        });
    }
    hasErrors() {
        return this.el.hasClass(this.invalidCssClass);
    }
    removeErrors() {
        this.invalidEls().each((index, el) => {
            this.removeElErrors($(el));
        });
        this.formMessageContainerEl().remove();
        this.el.removeClass(this.invalidCssClass);
    }
    submit() {
        this.removeErrors();
        if (this.skipValidation) {
            this.send();
        }
        else if (this.validate()) {
            this.send();
        }
    }
    send() {
        this.disableSubmitButtonEls();
        return this.sendFormData(this.uri(), this.formData());
    }
    showErrors(errors) {
        let formErrors = [];
        errors.forEach((err) => {
            if (Array.isArray(err)) {
                const [$el, elErrors] = err;
                this.showElErrors($el, elErrors);
            }
            else {
                formErrors.push(err);
            }
        });
        this.showFormErrors(formErrors);
        this.scrollToFirstError();
    }
    static fieldType($field) {
        const typeAttr = () => {
            const typeAttr = $field.attr('type');
            return typeAttr === undefined ? '' : typeAttr.toLowerCase();
        };
        let typeAttribute;
        switch ($field[0].tagName) {
            case 'INPUT':
                typeAttribute = typeAttr();
                switch (typeAttribute) {
                    case 'text':
                        return FieldType.Textfield;
                    case 'radio':
                        return FieldType.Radio;
                    case 'submit':
                        return FieldType.Submit;
                    case 'button':
                        return FieldType.Button;
                    case 'checkbox':
                        return FieldType.Checkbox;
                    case 'file':
                        return FieldType.File;
                    case 'hidden':
                        return FieldType.Hidden;
                    case 'image':
                        return FieldType.Image;
                    case 'password':
                        return FieldType.Password;
                    case 'reset':
                        return FieldType.Reset;
                }
                break;
            case 'TEXTAREA':
                return FieldType.Textarea;
            case 'SELECT':
                return FieldType.Select;
            case 'BUTTON':
                typeAttribute = typeAttr();
                if (typeAttribute === '' || typeAttribute === 'submit') {
                    return FieldType.Submit;
                }
                if (typeAttribute === 'button') {
                    return FieldType.Button;
                }
                break;
        }
        throw new Error('Unknown field type');
    }
    showFormErrors(errors) {
        if (errors.length) {
            const rendered = '<div class="alert alert-error">' + errors.map(renderMessage).join("\n") + '</div>';
            this.formMessageContainerEl()
                .prepend(rendered);
        }
        this.el.addClass(this.invalidCssClass);
    }
    showElErrors($el, errors) {
        const invalidCssClass = this.invalidCssClass;
        $el.addClass(invalidCssClass).closest('.' + this.elContainerCssClass).addClass(invalidCssClass).addClass('has-error');
        $el.after(errors.map(renderMessage).join("\n"));
    }
    removeElErrors($el) {
        const $container = $el.removeClass(this.invalidCssClass).closest('.' + this.elContainerCssClass);
        if (!$container.find('.' + this.invalidCssClass).length) {
            $container.removeClass(this.invalidCssClass).removeClass('has-error');
        }
        $el.next('.error').remove();
    }
    formMessageContainerEl() {
        const containerCssClass = this.formMessageContainerCssClass;
        let $containerEl = this.el.find('.' + containerCssClass);
        if (!$containerEl.length) {
            $containerEl = $('<div class="' + containerCssClass + '"></div>').prependTo(this.el);
        }
        return $containerEl;
    }
    init() {
        super.init();
        this.skipValidation = false;
        this.elContainerCssClass = 'form-group';
        this.formMessageContainerCssClass = 'messages';
        this.invalidCssClass = Form.defaultInvalidCssClass;
        this.elChangeEvents = elChangeEvents;
        this.el.attr('novalidate', 'novalidate');
    }
    bindHandlers() {
        this.el.on('submit', () => {
            this.submit();
            return false;
        });
        const self = this;
        this.elsToValidate().on(this.elChangeEvents, function () {
            const $el = $(this);
            if ($el.hasClass(self.invalidCssClass)) {
                self.removeElErrors($el);
            }
        });
    }
    sendFormData(uri, requestData) {
        const ajaxSettings = this.ajaxSettings();
        ajaxSettings.url = uri;
        ajaxSettings.data = requestData;
        return $.ajax(ajaxSettings);
    }
    ajaxSettings() {
        const self = this;
        return {
            beforeSend(jqXHR, settings) {
                return self.beforeSend(jqXHR, settings);
            },
            success(data, textStatus, jqXHR) {
                return self.ajaxSuccess(data, textStatus, jqXHR);
            },
            error(jqXHR, textStatus, errorThrown) {
                return self.ajaxError(jqXHR, textStatus, errorThrown);
            },
            method: this.submitMethod()
        };
    }
    submitMethod() {
        return this.el.attr('method') || 'GET';
    }
    beforeSend(jqXHR, settings) {
    }
    ajaxSuccess(responseData, textStatus, jqXHR) {
        this.enableSubmitButtonEls();
        this.handleResponse(responseData);
    }
    ajaxError(jqXHR, textStatus, errorThrown) {
        this.enableSubmitButtonEls();
        alert("AJAX error");
    }
    formData() {
        return formData(this.el);
    }
    uri() {
        return this.el.attr('action') || window.location.href;
    }
    enableSubmitButtonEls() {
        this.submitButtonEls().prop('disabled', false);
    }
    disableSubmitButtonEls() {
        this.submitButtonEls().prop('disabled', true);
    }
    submitButtonEls() {
        return this.els().filter(function () {
            return $(this).is(':submit');
        });
    }
    handleResponse(result) {
        if (result.err !== undefined) {
            this.handleErrResponse(result.err);
        }
        else if (result.ok !== undefined) {
            this.handleOkResponse(result.ok);
        }
        else {
            this.invalidResponseError();
        }
    }
    handleOkResponse(responseData) {
        if (responseData && responseData.redirect) {
            redirectTo(responseData.redirect);
            return true;
        }
    }
    handleErrResponse(responseData) {
        if (Array.isArray(responseData)) {
            const errors = responseData.map((message) => {
                return new ErrorMessage(message.text, message.args);
            });
            this.showErrors(errors);
        }
        else {
            this.invalidResponseError();
        }
    }
    invalidResponseError() {
        alert('Invalid response');
    }
    scrollToFirstError() {
        let $first = this.el.find('.error:first');
        let $container = $first.closest('.' + this.elContainerCssClass);
        if ($container.length) {
            $first = $container;
        }
        else {
            $container = $first.closest('.' + this.formMessageContainerCssClass);
            if ($container.length) {
                $first = $container;
            }
        }
        if (!$first.length) {
            return;
        }
    }
}

export { FieldType, Form, RequiredElValidator, defaultValidators, elChangeEvents, els, forEachEl, formData, validateEl };
//# sourceMappingURL=form.js.map
