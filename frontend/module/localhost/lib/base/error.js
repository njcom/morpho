class Exception extends Error {
    message;
    constructor(message) {
        super(message);
        this.message = message;
        this.name = 'Exception';
        this.message = message;
    }
    toString() {
        return this.name + ': ' + this.message;
    }
}
class NotImplementedException extends Exception {
}
class UnexpectedValueException extends Exception {
}

export { Exception, NotImplementedException, UnexpectedValueException };
//# sourceMappingURL=error.js.map
