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
class PageMessenger extends Widget {
    numberOfMessages() {
        return this.messageEls().length;
    }
    messageEls() {
        return this.el.find('.alert');
    }
    bindHandlers() {
        super.bindHandlers();
        this.registerCloseMessageHandler();
    }
    registerCloseMessageHandler() {
        const self = this;
        function hideElWithAnim($el, complete) {
            $el.fadeOut(complete);
        }
        function hideMainContainerWithAnim() {
            hideElWithAnim(self.el, function () {
                self.el.find('.messages').remove();
                self.el.hide();
            });
        }
        function closeMessageWithAnim($message) {
            if (self.numberOfMessages() === 1) {
                hideMainContainerWithAnim();
            }
            else {
                const $messageContainer = $message.closest('.messages');
                if ($messageContainer.find('.alert').length === 1) {
                    hideElWithAnim($messageContainer, function () {
                        $messageContainer.remove();
                    });
                }
                else {
                    hideElWithAnim($message, function () {
                        $message.remove();
                    });
                }
            }
        }
        this.el.on('click', 'button.close', function () {
            closeMessageWithAnim($(this).closest('.alert'));
        });
        setTimeout(function () {
            hideMainContainerWithAnim();
        }, 5000);
    }
}
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
class WarningMessage extends Message {
    constructor(text, args = []) {
        super(MessageType.Warning, text, args);
    }
}
class InfoMessage extends Message {
    constructor(text, args = []) {
        super(MessageType.Warning, text, args);
    }
}
class DebugMessage extends Message {
    constructor(text, args = []) {
        super(MessageType.Debug, text, args);
    }
}

export { DebugMessage, ErrorMessage, InfoMessage, Message, MessageType, PageMessenger, WarningMessage, messageTypeToStr, renderMessage };
//# sourceMappingURL=message.js.map
