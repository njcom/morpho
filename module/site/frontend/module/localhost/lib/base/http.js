var RestAction;
(function (RestAction) {
    RestAction["Delete"] = "delete";
})(RestAction || (RestAction = {}));
function isResponseError(response) {
    return !response.ok;
}
function redirectToSelf() {
    window.location.reload();
}
function redirectToHome() {
    redirectTo('/');
}
function redirectTo(uri, storePageInHistory = true) {
    if (storePageInHistory) {
        window.location.href = uri;
    }
    else {
        window.location.replace(uri);
    }
}
function queryArgs() {
    const decode = (input) => decodeURIComponent(input.replace(/\+/g, ' '));
    const parser = /([^=?&]+)=?([^&]*)/g;
    let queryArgs = {}, part;
    while (part = parser.exec(window.location.search)) {
        let key = decode(part[1]), value = decode(part[2]);
        if (key in queryArgs) {
            continue;
        }
        queryArgs[key] = value;
    }
    return queryArgs;
}

export { RestAction, isResponseError, queryArgs, redirectTo, redirectToHome, redirectToSelf };
//# sourceMappingURL=http.js.map
