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

export { EventManager };
//# sourceMappingURL=event-manager.js.map
