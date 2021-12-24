function showAD() {
    var t = document.createElement("script");
    t.setAttribute("type", "text/javascript"), t.setAttribute("src", "//axvert.chsi.com.cn/js/advertisment.js");
    var e = document.createElement("link");
    e.setAttribute("type", "text/css"), e.setAttribute("rel", "stylesheet"), e.setAttribute("href", "//axvert.chsi.com.cn/css/axvert.css");
    var r = document.getElementsByTagName("head")[0];
    r.appendChild(e), r.appendChild(t)
}

function parse(url) {
    if (null == url || -1 == url.indexOf("?")) return null;
    var argsUrl = url.split("?")[1];
    if (-1 == argsUrl.indexOf("=")) return null;
    var properties = argsUrl.replace(/&/g, "',").replace(/=/g, ":'") + "'", obj = null, template = "obj = {p}";
    return eval(template.replace(/p/g, properties)), obj
}

var axvertUrl = "";
!function () {
    function t(t, e) {
        return i[t] ? i[t] : i[t] = e
    }

    function e(t) {
        return '<iframe id="' + ("chsi_slot_iframe_" + t.id) + '" src="' + t.frameSrc + '"  vspace="0" hspace="0" allowTransparency="true" scrolling="no" marginHeight="0" marginWidth="0" frameborder="0" style="border: 0; vertical-align: bottom; margin: 0; display: block;"></iframe>'
    }

    function r(t) {
        if (this._id = "chsi_slot_div_" + t, this._wrap = a.createElement("div"), this._wrap.id = this._id, this._wrap.setAttribute("ndata", t), t) {
            var r = n(t);
            a.getElementById(this._id) ? a.getElementById(this._id).innerHTML = e(r) : (this._wrap.innerHTML = e(r), function (t) {
                a.write(t)
            }(function (t) {
                var e = a.createElement("div");
                return e.appendChild(t), e.innerHTML
            }(this._wrap)))
        }
    }

    function n(t) {
        o[t];
        return {id: t, frameSrc: axvertUrl + "/axv/" + t + ".html", width: 200, height: 200}
    }

    axvertUrl = ("https:" == document.location.protocol ? "https://" : "http://") + "t4.chei.com.cn";
    var i = window, a = (i.screen, i.navigator, i.document),
        o = (a.compatMode, Object.prototype.hasOwnProperty, t("chsi_shot_map", {}));
    r.prototype = {
        height: function (t) {
            var e = a.getElementById(this._id);
            return e.style.height = t + "px", e.style.overflow = "hidden", this
        }, width: function (t) {
            var e = a.getElementById(this._id);
            return e.style.width = t + "px", e.style.overflow = "hidden", this
        }
    }, t("showShortDom", function (t) {
        if (t) return e(n(t))
    }), t("showShortCut", function (t) {
        return new r(t)
    }), t("listenLoad", function (t) {
        if ("string" == typeof t) {
            var t = t.replace(/{|}|html_id|_w|_h|"|close|:/g, "").split(","),
                e = document.getElementById("chsi_slot_iframe_" + t[0]),
                r = document.getElementById("chsi_slot_div_" + t[0]);
            "true" !== t[1] ? (0 == t[2] && (r.style.width = "0px", r.style.height = "0px", r.style.overflow = "hidden"), e.style.width = t[1] + "px", e.style.height = t[2] + "px", e.style.overflow = "hidden") : r.parentNode.parentNode.removeChild(r.parentNode)
        }
    })
}();
var generalCallback = function (t) {
    "object" == typeof t && t.data && (t = t.data), listenLoad(t)
}, supportPostMessage = "postMessage" in window;
supportPostMessage ? "addEventListener" in document ? window.addEventListener("message", generalCallback, !1) : "attachEvent" in document && window.attachEvent("onmessage", generalCallback) : window.navigator.axvert_top = generalCallback, window.onload = function () {
    var t = parse(window.location.href.toString());
    t && t.advPageId && showAD()
};