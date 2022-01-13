var requirejs, require, define;
(function (ca) {
    function G(b) {
        return "[object Function]" === M.call(b)
    }

    function H(b) {
        return "[object Array]" === M.call(b)
    }

    function v(b, c) {
        if (b) {
            var d;
            for (d = 0; d < b.length && (!b[d] || !c(b[d], d, b)); d += 1) ;
        }
    }

    function U(b, c) {
        if (b) {
            var d;
            for (d = b.length - 1; -1 < d && (!b[d] || !c(b[d], d, b)); d -= 1) ;
        }
    }

    function s(b, c) {
        return ga.call(b, c)
    }

    function j(b, c) {
        return s(b, c) && b[c]
    }

    function B(b, c) {
        for (var d in b) if (s(b, d) && c(b[d], d)) break
    }

    function V(b, c, d, g) {
        c && B(c, function (c, h) {
            if (d || !s(b, h)) g && "object" === typeof c && c && !H(c) && !G(c) && !(c instanceof
                RegExp) ? (b[h] || (b[h] = {}), V(b[h], c, d, g)) : b[h] = c
        });
        return b
    }

    function t(b, c) {
        return function () {
            return c.apply(b, arguments)
        }
    }

    function da(b) {
        throw b;
    }

    function ea(b) {
        if (!b) return b;
        var c = ca;
        v(b.split("."), function (b) {
            c = c[b]
        });
        return c
    }

    function C(b, c, d, g) {
        c = Error(c + "\nhttp://requirejs.org/docs/errors.html#" + b);
        c.requireType = b;
        c.requireModules = g;
        d && (c.originalError = d);
        return c
    }

    function ha(b) {
        function c(a, e, b) {
            var f, n, c, d, g, h, i, I = e && e.split("/");
            n = I;
            var m = l.map, k = m && m["*"];
            if (a && "." === a.charAt(0)) if (e) {
                n =
                    I.slice(0, I.length - 1);
                a = a.split("/");
                e = a.length - 1;
                l.nodeIdCompat && R.test(a[e]) && (a[e] = a[e].replace(R, ""));
                n = a = n.concat(a);
                d = n.length;
                for (e = 0; e < d; e++) if (c = n[e], "." === c) n.splice(e, 1), e -= 1; else if (".." === c) if (1 === e && (".." === n[2] || ".." === n[0])) break; else 0 < e && (n.splice(e - 1, 2), e -= 2);
                a = a.join("/")
            } else 0 === a.indexOf("./") && (a = a.substring(2));
            if (b && m && (I || k)) {
                n = a.split("/");
                e = n.length;
                a:for (; 0 < e; e -= 1) {
                    d = n.slice(0, e).join("/");
                    if (I) for (c = I.length; 0 < c; c -= 1) if (b = j(m, I.slice(0, c).join("/"))) if (b = j(b, d)) {
                        f = b;
                        g = e;
                        break a
                    }
                    !h && (k && j(k, d)) && (h = j(k, d), i = e)
                }
                !f && h && (f = h, g = i);
                f && (n.splice(0, g, f), a = n.join("/"))
            }
            return (f = j(l.pkgs, a)) ? f : a
        }

        function d(a) {
            z && v(document.getElementsByTagName("script"), function (e) {
                if (e.getAttribute("data-requiremodule") === a && e.getAttribute("data-requirecontext") === i.contextName) return e.parentNode.removeChild(e), !0
            })
        }

        function g(a) {
            var e = j(l.paths, a);
            if (e && H(e) && 1 < e.length) return e.shift(), i.require.undef(a), i.require([a]), !0
        }

        function u(a) {
            var e, b = a ? a.indexOf("!") : -1;
            -1 < b && (e = a.substring(0,
                b), a = a.substring(b + 1, a.length));
            return [e, a]
        }

        function m(a, e, b, f) {
            var n, d, g = null, h = e ? e.name : null, l = a, m = !0, k = "";
            a || (m = !1, a = "_@r" + (M += 1));
            a = u(a);
            g = a[0];
            a = a[1];
            g && (g = c(g, h, f), d = j(p, g));
            a && (g ? k = d && d.normalize ? d.normalize(a, function (a) {
                return c(a, h, f)
            }) : c(a, h, f) : (k = c(a, h, f), a = u(k), g = a[0], k = a[1], b = !0, n = i.nameToUrl(k)));
            b = g && !d && !b ? "_unnormalized" + (Q += 1) : "";
            return {
                prefix: g,
                name: k,
                parentMap: e,
                unnormalized: !!b,
                url: n,
                originalName: l,
                isDefine: m,
                id: (g ? g + "!" + k : k) + b
            }
        }

        function q(a) {
            var e = a.id, b = j(k, e);
            b || (b = k[e] = new i.Module(a));
            return b
        }

        function r(a, e, b) {
            var f = a.id, n = j(k, f);
            if (s(p, f) && (!n || n.defineEmitComplete)) "defined" === e && b(p[f]); else if (n = q(a), n.error && "error" === e) b(n.error); else n.on(e, b)
        }

        function w(a, e) {
            var b = a.requireModules, f = !1;
            if (e) e(a); else if (v(b, function (e) {
                if (e = j(k, e)) e.error = a, e.events.error && (f = !0, e.emit("error", a))
            }), !f) h.onError(a)
        }

        function x() {
            S.length && (ia.apply(A, [A.length, 0].concat(S)), S = [])
        }

        function y(a) {
            delete k[a];
            delete W[a]
        }

        function F(a, e, b) {
            var f = a.map.id;
            a.error ? a.emit("error", a.error) : (e[f] =
                !0, v(a.depMaps, function (f, c) {
                var d = f.id, g = j(k, d);
                g && (!a.depMatched[c] && !b[d]) && (j(e, d) ? (a.defineDep(c, p[d]), a.check()) : F(g, e, b))
            }), b[f] = !0)
        }

        function D() {
            var a, e, b = (a = 1E3 * l.waitSeconds) && i.startTime + a < (new Date).getTime(), f = [], c = [], h = !1,
                k = !0;
            if (!X) {
                X = !0;
                B(W, function (a) {
                    var i = a.map, m = i.id;
                    if (a.enabled && (i.isDefine || c.push(a), !a.error)) if (!a.inited && b) g(m) ? h = e = !0 : (f.push(m), d(m)); else if (!a.inited && (a.fetched && i.isDefine) && (h = !0, !i.prefix)) return k = !1
                });
                if (b && f.length) return a = C("timeout", "Load timeout for modules: " +
                    f, null, f), a.contextName = i.contextName, w(a);
                k && v(c, function (a) {
                    F(a, {}, {})
                });
                if ((!b || e) && h) if ((z || fa) && !Y) Y = setTimeout(function () {
                    Y = 0;
                    D()
                }, 50);
                X = !1
            }
        }

        function E(a) {
            s(p, a[0]) || q(m(a[0], null, !0)).init(a[1], a[2])
        }

        function K(a) {
            var a = a.currentTarget || a.srcElement, e = i.onScriptLoad;
            a.detachEvent && !Z ? a.detachEvent("onreadystatechange", e) : a.removeEventListener("load", e, !1);
            e = i.onScriptError;
            (!a.detachEvent || Z) && a.removeEventListener("error", e, !1);
            return {node: a, id: a && a.getAttribute("data-requiremodule")}
        }

        function L() {
            var a;
            for (x(); A.length;) {
                a = A.shift();
                if (null === a[0]) return w(C("mismatch", "Mismatched anonymous define() module: " + a[a.length - 1]));
                E(a)
            }
        }

        var X, $, i, N, Y, l = {waitSeconds: 7, baseUrl: "./", paths: {}, bundles: {}, pkgs: {}, shim: {}, config: {}},
            k = {}, W = {}, aa = {}, A = [], p = {}, T = {}, ba = {}, M = 1, Q = 1;
        N = {
            require: function (a) {
                return a.require ? a.require : a.require = i.makeRequire(a.map)
            }, exports: function (a) {
                a.usingExports = !0;
                if (a.map.isDefine) return a.exports ? p[a.map.id] = a.exports : a.exports = p[a.map.id] = {}
            }, module: function (a) {
                return a.module ?
                    a.module : a.module = {
                        id: a.map.id, uri: a.map.url, config: function () {
                            return j(l.config, a.map.id) || {}
                        }, exports: a.exports || (a.exports = {})
                    }
            }
        };
        $ = function (a) {
            this.events = j(aa, a.id) || {};
            this.map = a;
            this.shim = j(l.shim, a.id);
            this.depExports = [];
            this.depMaps = [];
            this.depMatched = [];
            this.pluginMaps = {};
            this.depCount = 0
        };
        $.prototype = {
            init: function (a, e, b, f) {
                f = f || {};
                if (!this.inited) {
                    this.factory = e;
                    if (b) this.on("error", b); else this.events.error && (b = t(this, function (a) {
                        this.emit("error", a)
                    }));
                    this.depMaps = a && a.slice(0);
                    this.errback =
                        b;
                    this.inited = !0;
                    this.ignore = f.ignore;
                    f.enabled || this.enabled ? this.enable() : this.check()
                }
            }, defineDep: function (a, e) {
                this.depMatched[a] || (this.depMatched[a] = !0, this.depCount -= 1, this.depExports[a] = e)
            }, fetch: function () {
                if (!this.fetched) {
                    this.fetched = !0;
                    i.startTime = (new Date).getTime();
                    var a = this.map;
                    if (this.shim) i.makeRequire(this.map, {enableBuildCallback: !0})(this.shim.deps || [], t(this, function () {
                        return a.prefix ? this.callPlugin() : this.load()
                    })); else return a.prefix ? this.callPlugin() : this.load()
                }
            }, load: function () {
                var a =
                    this.map.url;
                T[a] || (T[a] = !0, i.load(this.map.id, a))
            }, check: function () {
                if (this.enabled && !this.enabling) {
                    var a, e, b = this.map.id;
                    e = this.depExports;
                    var f = this.exports, c = this.factory;
                    if (this.inited) if (this.error) this.emit("error", this.error); else {
                        if (!this.defining) {
                            this.defining = !0;
                            if (1 > this.depCount && !this.defined) {
                                if (G(c)) {
                                    if (this.events.error && this.map.isDefine || h.onError !== da) try {
                                        f = i.execCb(b, c, e, f)
                                    } catch (d) {
                                        a = d
                                    } else f = i.execCb(b, c, e, f);
                                    this.map.isDefine && void 0 === f && ((e = this.module) ? f = e.exports : this.usingExports &&
                                        (f = this.exports));
                                    if (a) return a.requireMap = this.map, a.requireModules = this.map.isDefine ? [this.map.id] : null, a.requireType = this.map.isDefine ? "define" : "require", w(this.error = a)
                                } else f = c;
                                this.exports = f;
                                if (this.map.isDefine && !this.ignore && (p[b] = f, h.onResourceLoad)) h.onResourceLoad(i, this.map, this.depMaps);
                                y(b);
                                this.defined = !0
                            }
                            this.defining = !1;
                            this.defined && !this.defineEmitted && (this.defineEmitted = !0, this.emit("defined", this.exports), this.defineEmitComplete = !0)
                        }
                    } else this.fetch()
                }
            }, callPlugin: function () {
                var a =
                    this.map, b = a.id, d = m(a.prefix);
                this.depMaps.push(d);
                r(d, "defined", t(this, function (f) {
                    var d, g;
                    g = j(ba, this.map.id);
                    var J = this.map.name, u = this.map.parentMap ? this.map.parentMap.name : null,
                        p = i.makeRequire(a.parentMap, {enableBuildCallback: !0});
                    if (this.map.unnormalized) {
                        if (f.normalize && (J = f.normalize(J, function (a) {
                            return c(a, u, !0)
                        }) || ""), f = m(a.prefix + "!" + J, this.map.parentMap), r(f, "defined", t(this, function (a) {
                            this.init([], function () {
                                return a
                            }, null, {enabled: !0, ignore: !0})
                        })), g = j(k, f.id)) {
                            this.depMaps.push(f);
                            if (this.events.error) g.on("error", t(this, function (a) {
                                this.emit("error", a)
                            }));
                            g.enable()
                        }
                    } else g ? (this.map.url = i.nameToUrl(g), this.load()) : (d = t(this, function (a) {
                        this.init([], function () {
                            return a
                        }, null, {enabled: !0})
                    }), d.error = t(this, function (a) {
                        this.inited = !0;
                        this.error = a;
                        a.requireModules = [b];
                        B(k, function (a) {
                            0 === a.map.id.indexOf(b + "_unnormalized") && y(a.map.id)
                        });
                        w(a)
                    }), d.fromText = t(this, function (f, c) {
                        var g = a.name, J = m(g), k = O;
                        c && (f = c);
                        k && (O = !1);
                        q(J);
                        s(l.config, b) && (l.config[g] = l.config[b]);
                        try {
                            h.exec(f)
                        } catch (j) {
                            return w(C("fromtexteval",
                                "fromText eval for " + b + " failed: " + j, j, [b]))
                        }
                        k && (O = !0);
                        this.depMaps.push(J);
                        i.completeLoad(g);
                        p([g], d)
                    }), f.load(a.name, p, d, l))
                }));
                i.enable(d, this);
                this.pluginMaps[d.id] = d
            }, enable: function () {
                W[this.map.id] = this;
                this.enabling = this.enabled = !0;
                v(this.depMaps, t(this, function (a, b) {
                    var c, f;
                    if ("string" === typeof a) {
                        a = m(a, this.map.isDefine ? this.map : this.map.parentMap, !1, !this.skipMap);
                        this.depMaps[b] = a;
                        if (c = j(N, a.id)) {
                            this.depExports[b] = c(this);
                            return
                        }
                        this.depCount += 1;
                        r(a, "defined", t(this, function (a) {
                            this.defineDep(b,
                                a);
                            this.check()
                        }));
                        this.errback && r(a, "error", t(this, this.errback))
                    }
                    c = a.id;
                    f = k[c];
                    !s(N, c) && (f && !f.enabled) && i.enable(a, this)
                }));
                B(this.pluginMaps, t(this, function (a) {
                    var b = j(k, a.id);
                    b && !b.enabled && i.enable(a, this)
                }));
                this.enabling = !1;
                this.check()
            }, on: function (a, b) {
                var c = this.events[a];
                c || (c = this.events[a] = []);
                c.push(b)
            }, emit: function (a, b) {
                v(this.events[a], function (a) {
                    a(b)
                });
                "error" === a && delete this.events[a]
            }
        };
        i = {
            config: l, contextName: b, registry: k, defined: p, urlFetched: T, defQueue: A, Module: $, makeModuleMap: m,
            nextTick: h.nextTick, onError: w, configure: function (a) {
                a.baseUrl && "/" !== a.baseUrl.charAt(a.baseUrl.length - 1) && (a.baseUrl += "/");
                var b = l.shim, c = {paths: !0, bundles: !0, config: !0, map: !0};
                B(a, function (a, b) {
                    c[b] ? (l[b] || (l[b] = {}), V(l[b], a, !0, !0)) : l[b] = a
                });
                a.bundles && B(a.bundles, function (a, b) {
                    v(a, function (a) {
                        a !== b && (ba[a] = b)
                    })
                });
                a.shim && (B(a.shim, function (a, c) {
                    H(a) && (a = {deps: a});
                    if ((a.exports || a.init) && !a.exportsFn) a.exportsFn = i.makeShimExports(a);
                    b[c] = a
                }), l.shim = b);
                a.packages && v(a.packages, function (a) {
                    var b,
                        a = "string" === typeof a ? {name: a} : a;
                    b = a.name;
                    a.location && (l.paths[b] = a.location);
                    l.pkgs[b] = a.name + "/" + (a.main || "main").replace(ja, "").replace(R, "")
                });
                B(k, function (a, b) {
                    !a.inited && !a.map.unnormalized && (a.map = m(b))
                });
                if (a.deps || a.callback) i.require(a.deps || [], a.callback)
            }, makeShimExports: function (a) {
                return function () {
                    var b;
                    a.init && (b = a.init.apply(ca, arguments));
                    return b || a.exports && ea(a.exports)
                }
            }, makeRequire: function (a, e) {
                function g(f, c, d) {
                    var j, l;
                    e.enableBuildCallback && (c && G(c)) && (c.__requireJsBuild =
                        !0);
                    if ("string" === typeof f) {
                        if (G(c)) return w(C("requireargs", "Invalid require call"), d);
                        if (a && s(N, f)) return N[f](k[a.id]);
                        if (h.get) return h.get(i, f, a, g);
                        j = m(f, a, !1, !0);
                        j = j.id;
                        return !s(p, j) ? w(C("notloaded", 'Module name "' + j + '" has not been loaded yet for context: ' + b + (a ? "" : ". Use require([])"))) : p[j]
                    }
                    L();
                    i.nextTick(function () {
                        L();
                        l = q(m(null, a));
                        l.skipMap = e.skipMap;
                        l.init(f, c, d, {enabled: !0});
                        D()
                    });
                    return g
                }

                e = e || {};
                V(g, {
                    isBrowser: z, toUrl: function (b) {
                        var e, d = b.lastIndexOf("."), g = b.split("/")[0];
                        if (-1 !==
                            d && (!("." === g || ".." === g) || 1 < d)) e = b.substring(d, b.length), b = b.substring(0, d);
                        return i.nameToUrl(c(b, a && a.id, !0), e, !0)
                    }, defined: function (b) {
                        return s(p, m(b, a, !1, !0).id)
                    }, specified: function (b) {
                        b = m(b, a, !1, !0).id;
                        return s(p, b) || s(k, b)
                    }
                });
                a || (g.undef = function (b) {
                    x();
                    var c = m(b, a, !0), e = j(k, b);
                    d(b);
                    delete p[b];
                    delete T[c.url];
                    delete aa[b];
                    U(A, function (a, c) {
                        a[0] === b && A.splice(c, 1)
                    });
                    e && (e.events.defined && (aa[b] = e.events), y(b))
                });
                return g
            }, enable: function (a) {
                j(k, a.id) && q(a).enable()
            }, completeLoad: function (a) {
                var b,
                    c, f = j(l.shim, a) || {}, d = f.exports;
                for (x(); A.length;) {
                    c = A.shift();
                    if (null === c[0]) {
                        c[0] = a;
                        if (b) break;
                        b = !0
                    } else c[0] === a && (b = !0);
                    E(c)
                }
                c = j(k, a);
                if (!b && !s(p, a) && c && !c.inited) {
                    if (l.enforceDefine && (!d || !ea(d))) return g(a) ? void 0 : w(C("nodefine", "No define call for " + a, null, [a]));
                    E([a, f.deps || [], f.exportsFn])
                }
                D()
            }, nameToUrl: function (a, b, c) {
                var f, d, g;
                (f = j(l.pkgs, a)) && (a = f);
                if (f = j(ba, a)) return i.nameToUrl(f, b, c);
                if (h.jsExtRegExp.test(a)) f = a + (b || ""); else {
                    f = l.paths;
                    a = a.split("/");
                    for (d = a.length; 0 < d; d -= 1) if (g = a.slice(0,
                        d).join("/"), g = j(f, g)) {
                        H(g) && (g = g[0]);
                        a.splice(0, d, g);
                        break
                    }
                    f = a.join("/");
                    f += b || (/^data\:|\?/.test(f) || c ? "" : ".js");
                    f = ("/" === f.charAt(0) || f.match(/^[\w\+\.\-]+:/) ? "" : l.baseUrl) + f
                }
                return l.urlArgs ? f + ((-1 === f.indexOf("?") ? "?" : "&") + l.urlArgs) : f
            }, load: function (a, b) {
                h.load(i, a, b)
            }, execCb: function (a, b, c, d) {
                return b.apply(d, c)
            }, onScriptLoad: function (a) {
                if ("load" === a.type || ka.test((a.currentTarget || a.srcElement).readyState)) P = null, a = K(a), i.completeLoad(a.id)
            }, onScriptError: function (a) {
                var b = K(a);
                if (!g(b.id)) return w(C("scripterror",
                    "Script error for: " + b.id, a, [b.id]))
            }
        };
        i.require = i.makeRequire();
        return i
    }

    var h, x, y, D, K, E, P, L, q, Q, la = /(\/\*([\s\S]*?)\*\/|([^:]|^)\/\/(.*)$)/mg,
        ma = /[^.]\s*require\s*\(\s*["']([^'"\s]+)["']\s*\)/g, R = /\.js$/, ja = /^\.\//;
    x = Object.prototype;
    var M = x.toString, ga = x.hasOwnProperty, ia = Array.prototype.splice,
        z = !!("undefined" !== typeof window && "undefined" !== typeof navigator && window.document),
        fa = !z && "undefined" !== typeof importScripts,
        ka = z && "PLAYSTATION 3" === navigator.platform ? /^complete$/ : /^(complete|loaded)$/,
        Z = "undefined" !== typeof opera && "[object Opera]" === opera.toString(), F = {}, r = {}, S = [], O = !1;
    if ("undefined" === typeof define) {
        if ("undefined" !== typeof requirejs) {
            if (G(requirejs)) return;
            r = requirejs;
            requirejs = void 0
        }
        "undefined" !== typeof require && !G(require) && (r = require, require = void 0);
        h = requirejs = function (b, c, d, g) {
            var u, m = "_";
            !H(b) && "string" !== typeof b && (u = b, H(c) ? (b = c, c = d, d = g) : b = []);
            u && u.context && (m = u.context);
            (g = j(F, m)) || (g = F[m] = h.s.newContext(m));
            u && g.configure(u);
            return g.require(b, c, d)
        };
        h.config = function (b) {
            return h(b)
        };
        h.nextTick = "undefined" !== typeof setTimeout ? function (b) {
            setTimeout(b, 4)
        } : function (b) {
            b()
        };
        require || (require = h);
        h.version = "2.1.11";
        h.jsExtRegExp = /^\/|:|\?|\.js$/;
        h.isBrowser = z;
        x = h.s = {contexts: F, newContext: ha};
        h({});
        v(["toUrl", "undef", "defined", "specified"], function (b) {
            h[b] = function () {
                var c = F._;
                return c.require[b].apply(c, arguments)
            }
        });
        if (z && (y = x.head = document.getElementsByTagName("head")[0], D = document.getElementsByTagName("base")[0])) y = x.head = D.parentNode;
        h.onError = da;
        h.createNode = function (b) {
            var c =
                b.xhtml ? document.createElementNS("http://www.w3.org/1999/xhtml", "html:script") : document.createElement("script");
            c.type = b.scriptType || "text/javascript";
            c.charset = "utf-8";
            c.async = !0;
            return c
        };
        h.load = function (b, c, d) {
            var g = b && b.config || {};
            if (z) return g = h.createNode(g, c, d), g.setAttribute("data-requirecontext", b.contextName), g.setAttribute("data-requiremodule", c), g.attachEvent && !(g.attachEvent.toString && 0 > g.attachEvent.toString().indexOf("[native code")) && !Z ? (O = !0, g.attachEvent("onreadystatechange", b.onScriptLoad)) :
                (g.addEventListener("load", b.onScriptLoad, !1), g.addEventListener("error", b.onScriptError, !1)), g.src = d, L = g, D ? y.insertBefore(g, D) : y.appendChild(g), L = null, g;
            if (fa) try {
                importScripts(d), b.completeLoad(c)
            } catch (j) {
                b.onError(C("importscripts", "importScripts failed for " + c + " at " + d, j, [c]))
            }
        };
        z && !r.skipDataMain && U(document.getElementsByTagName("script"), function (b) {
            y || (y = b.parentNode);
            if (K = b.getAttribute("data-main")) return q = K, r.baseUrl || (E = q.split("/"), q = E.pop(), Q = E.length ? E.join("/") + "/" : "./", r.baseUrl =
                Q), q = q.replace(R, ""), h.jsExtRegExp.test(q) && (q = K), r.deps = r.deps ? r.deps.concat(q) : [q], !0
        });
        define = function (b, c, d) {
            var g, h;
            "string" !== typeof b && (d = c, c = b, b = null);
            H(c) || (d = c, c = null);
            !c && G(d) && (c = [], d.length && (d.toString().replace(la, "").replace(ma, function (b, d) {
                c.push(d)
            }), c = (1 === d.length ? ["require"] : ["require", "exports", "module"]).concat(c)));
            if (O) {
                if (!(g = L)) P && "interactive" === P.readyState || U(document.getElementsByTagName("script"), function (b) {
                    if ("interactive" === b.readyState) return P = b
                }), g = P;
                g && (b ||
                (b = g.getAttribute("data-requiremodule")), h = F[g.getAttribute("data-requirecontext")])
            }
            (h ? h.defQueue : S).push([b, c, d])
        };
        define.amd = {jQuery: !0};
        h.exec = function (b) {
            return eval(b)
        };
        h(r)
    }
})(this);

//---------------------

require.config({
    baseUrl: '//staticv3-pre.youzy.cn/ToC.PC/scripts_dist/0204_89r6yi20i8/static/',
    urlArgs: 'v=1612413623904',
    waitSeconds: 300,
    paths: {
        //===========libs
        'jquery': '//staticv3.youzy.cn/libs/jquery-1.7.2.min',
        'bootstrap': '//staticv3.youzy.cn/libs/bootstrap2.0/bootstrap.min',
        'underscore': '//staticv3.youzy.cn/libs/underscore/underscore-1.8.min',
        'handlebars': '//staticv3.youzy.cn/libs/handlebars/handlebars2',
        'json2': '//staticv3.youzy.cn/libs/json2',
        'json3': '//staticv3.youzy.cn/libs/json3',
        'cookie': '//staticv3.youzy.cn/libs/js.cookie.min',
        'ueditor/config': '/ueditor/ueditor.config', //ueditor
        'ueditor': '/ueditor/ueditor.all', //ueditor
        'md5': '//staticv3.youzy.cn/libs/cdn/md5/md5',

        //===========plugins
        'placeholder': '//staticv3.youzy.cn/libs/jquery.placeholder.min', //input textarea --placeholder
        'swfobject': '/content/lessons/swfobject.min', //swf object
        'easing1.3': '//staticv3.youzy.cn/libs/jquery.easing/jquery.easing.min-1.3', //jquery easing 圆形进度条依赖
        'easyPieChart': '//staticv3.youzy.cn/libs/easyPieChart/jquery.easypiechart.min', //圆形进度条主库
        'baiduMap': '//api.map.baidu.com/getscript?v=2.0&ak=Ql79AkVF6MapPGclflS8lxOB&services=&t=20181016102824', //baidu map api
        'slimScroll': '//staticv3.youzy.cn/libs/jquery.slimscroll.min', //漂亮滚动条
        'jqueryPagination': '//staticv3.youzy.cn/libs/jqueryPagination/pagination.min', //分页插件
        'jqueryFineuploader': '//staticv3.youzy.cn/libs/jquery.fineuploader/jquery.fineuploader-3.4.1.min', //上传图片插件
        'dragdealer': '//staticv3.youzy.cn/libs/dragdealer', //jq滑块拖动组件
        'superSlide': '//staticv3.youzy.cn/libs/jquery.SuperSlide', //超级切换
        'rangeSlider': '//staticv3.youzy.cn/libs/ion-rangeslider/js/ion.rangeSlider.min', //区域拖拉插件
        'qrcode': '//staticv3.youzy.cn/libs/qrcode/qrcode', //二维码js
        'qrcodeUtils': '//staticv3.youzy.cn/libs/qrcode/utils', //二维码工具类
        'suggest': '//staticv3.youzy.cn/libs/jquery.suggest/jquery.suggest', //智能填充组件
        'sweetalert2.1': '//staticv3.youzy.cn/libs/sweetalert2.1/sweetalert2.1.min', //友好弹框（PC暂未用到，用到请删除此句）
        'fancybox': '//staticv3.youzy.cn/libs/fancybox/jquery.fancybox',
        'fancyboxThumbs': '//staticv3.youzy.cn/libs/fancybox/helpers/jquery.fancybox-thumbs',
        'echarts': '//staticv3.youzy.cn/libs/echarts/echarts.min', //echarts
        'echartsMapChina': '//staticv3.youzy.cn/libs/echarts/china', //echarts
        'highlightRegex': '//staticv3.youzy.cn/libs/highlightRegex', //高亮显示当前页面关键词
        'highcharts5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/highcharts5.0.12', //hCharts图表渲染插件
        'highchartsMore5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/highcharts-more5.0.12',
        'highChartsExporting5': '//staticv3.youzy.cn/libs/Highcharts-5.0.12/exporting5.0.12',
        'fineUploader2': '//staticv3.youzy.cn/libs/fineuploader/fineuploader-3.8.0.min',
        'raty': '//staticv3.youzy.cn/libs/jquery-raty/jquery.raty', //打星插件
        'umpplayer': '/content/tv/ump.player_v1.min', //Ucloud直播插件
        'jwplayer': '//staticv3.youzy.cn/libs/jwplayer/jwplayer', //录播插件
        'extensions': '//staticv3.youzy.cn/scripts/extensions',
        'nicescroll': '//staticv3.youzy.cn/libs/jquery.nicescroll/jquery.nicescroll.min',
        'dragula': '//staticv3.youzy.cn/libs/dragula-master/dist/dragula.min', //拖动插件
        'cropper': '//staticv3.youzy.cn/libs/cropper/cropper.min', //图片裁剪,
        //'barrage': '//staticv3.youzy.cn/libs/barrage/barrage',
        'gtLibs': '//staticv3.youzy.cn/libs/gt/gt',
        'moment': '//staticv3.youzy.cn/libs/moment/moment.min',
        'datetimepicker': '//staticv3.youzy.cn/libs/datetimepicker/jquery.datetimepicker.full', //日历控件
        'bootstrap-datetimepicker': '//staticv3.youzy.cn/libs/bootstrap-datetimepicker/bootstrap-datetimepicker.min', //时间空间-纯日期
        'datetimepickerMonth': '//staticv3.youzy.cn/libs/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN', //时间控件-纯日期 中文包 通过调用该组件来唤起日历控件
        'dateRangePicker': '//staticv3.youzy.cn/libs/bootstrap-daterangepicker/daterangepicker', //时间空间 区间选择
        'swiper3': '//staticv3.youzy.cn/libs/swiper3.4/swiper.jquery.min', //轮播图
        'aliplayer': '//g.alicdn.com/de/prismplayer/2.8.8/aliplayer-min', //阿里播放代码插件
        'aliplayerComponent': '//staticv3.youzy.cn/libs/aliplayercomponents-1.0.5.min', //阿里播放代码组件
        'bodymovin': '//staticv3-pre.youzy.cn/libs/lottie/bodymovin', //lottie

        //===========dialogs start
        //common
        'dialogs/loading': 'scripts/dialogs/common/loading.dialog', //通用loading
        'dialogs/autosaveloading': 'scripts/dialogs/common/autosave.dialog', //通用自动保存中loading
        'dialogs/message': 'scripts/dialogs/common/message.dialog', //通用消息
        'dialogs/uploadImage': 'scripts/dialogs/common/uploadImage.dialog', //上传
        'dialogs/expertPhoto': 'scripts/dialogs/common/expertPhoto.dialog', //专家上传图片
        'dialogs/useFuntionLogs': 'scripts/dialogs/common/useFunctionLogs.dialog', //非VIP用户能免费查看的次数
        //users
        'dialogs/users/userLogin': 'scripts/dialogs/users/userLogin.dialog', //用户登录
        'dialogs/users/perfectInfo': 'scripts/dialogs/users/perfectInfo.dialog', //用户完善信息
        'dialogs/users/perfectCourseType': 'scripts/dialogs/users/perfectCourseType.dialog', //完善文理科信息
        'dialogs/users/perfectGender': 'scripts/dialogs/users/perfectGender.dialog', //完善性别信息
        'dialogs/users/perfectMobile': 'scripts/dialogs/users/perfectMobile.dialog', //完善手机绑定
        'dialogs/openAuth/weixinLogin': 'scripts/dialogs/openAuth/weixinLogin.dialog', //三方登录 - 微信

        //选科
        'dialogs/profession': 'scripts/dialogs/newGaoKaoChooseSubject/profession.dialog',
        'dialogs/college': 'scripts/dialogs/newGaoKaoChooseSubject/college.dialog',
        //payment
        'dialogs/paymentDialog': 'scripts/dialogs/pay/payment.dialog', //通用支付
        'dialogs/paymentPacksDialog': 'scripts/dialogs/pay/paymentPacks.dialog', //购买课程

        //创建成绩
        'dialogs/users/scoreCountLimit': 'scripts/dialogs/users/scores/scoreCountLimit.dialog', //创建成绩总入口
        'dialogs/users/createScoreIndex': 'scripts/dialogs/users/scores/createScoreIndex.dialog', //创建成绩总入口
        'dialogs/users/createScorePutong': 'scripts/dialogs/users/scores/createScorePutong.dialog', //创建成绩-传统
        'dialogs/users/createScoreJiangsu': 'scripts/dialogs/users/scores/createScoreJiangsu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreZhejiang': 'scripts/dialogs/users/scores/createScoreZhejiang.dialog', //创建成绩-浙江
        'dialogs/users/createScoreShanghai': 'scripts/dialogs/users/scores/createScoreShanghai.dialog', //创建成绩-上海
        'dialogs/users/createScoreShandong': 'scripts/dialogs/users/scores/createScoreShandong.dialog', //创建成绩-山东
        'dialogs/users/createScoreBeijing': 'scripts/dialogs/users/scores/createScoreBeijing.dialog', //创建成绩-新高考//北京
        'dialogs/users/createScoreTianJin': 'scripts/dialogs/users/scores/createScoreTianJin.dialog', //创建成绩-新高考//天津
        'dialogs/users/createScoreHaiNan': 'scripts/dialogs/users/scores/createScoreHaiNan.dialog', //创建成绩-新高考//海南
        //v2
        'dialogs/users/scoreCountLimit': 'scripts/dialogs/users/scores/scoreCountLimit.dialog', //创建成绩总入口
        'dialogs/users/createScoreIndex': 'scripts/dialogs/users/scores/createScoreIndex.dialog', //创建成绩总入口
        'dialogs/users/createScorePuTong/v2': 'scripts/dialogs/users/scores/v2/createScorePuTong.dialog', //创建成绩-传统
        'dialogs/users/createScoreJiangSu/v2': 'scripts/dialogs/users/scores/v2/createScoreJiangSu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreNewGaoKao': 'scripts/dialogs/users/scores/v2/createScoreNewGaoKao.dialog', //创建成绩-浙江
        'dialogs/users/createScoreNewGaoKao312': 'scripts/dialogs/users/scores/v2/createScoreNewGaoKao312.dialog', //创建成绩-3+1+2

        //创建成绩 高考版
        'dialogs/users/createScoreGKPutong': 'scripts/dialogs/users/scores/createScoreGKPutong.dialog', //传统
        'dialogs/users/createScoreGKJiangsu': 'scripts/dialogs/users/scores/createScoreGKJiangsu.dialog', //江苏
        'dialogs/users/createScoreGKZhejiang': 'scripts/dialogs/users/scores/createScoreGKZhejiang.dialog', //浙江
        'dialogs/users/createScoreGKShanghai': 'scripts/dialogs/users/scores/createScoreGKShanghai.dialog', //上海
        'dialogs/users/createScoreGKShandong': 'scripts/dialogs/users/scores/createScoreGKShandong.dialog', //山东
        'dialogs/users/createScoreGKBeijing': 'scripts/dialogs/users/scores/createScoreGKBeijing.dialog', //北京
        'dialogs/users/createScoreGKTianjin': 'scripts/dialogs/users/scores/createScoreGKTianjin.dialog', //天津
        'dialogs/users/createScoreGKHainan': 'scripts/dialogs/users/scores/createScoreGKHainan.dialog', //海南
        //v2
        'dialogs/users/createScoreGKPuTong/v2': 'scripts/dialogs/users/scores/v2/createScoreGKPuTong.dialog', //创建成绩-传统
        'dialogs/users/createScoreGKJiangSu/v2': 'scripts/dialogs/users/scores/v2/createScoreGKJiangSu.dialog', //创建成绩-江苏
        'dialogs/users/createScoreGKNewGaoKao': 'scripts/dialogs/users/scores/v2/createScoreGKNewGaoKao.dialog', //创建成绩-浙江

        //tzy
        'dialogs/tzy': 'scripts/dialogs/tzy/tzy.dialog', //传统
        'dialogs/tzy/pfraction': 'scripts/dialogs/tzy/pfraction.dialog', //填志愿专业分数线
        'dialogs/tzy/replaceCollege': 'scripts/dialogs/tzy/replaceCollege.dialog', //相同志愿院校替换
        'dialogs/tzy/tzyMessage': 'scripts/dialogs/tzy/tzyMessage.dialog',
        'services/tzy/dataTransformation': 'scripts/controllers/tzy/chuanTongOrJiangSu/dataTransformation.controller',
        'services/tzy/sessionStorage': 'scripts/controllers/tzy/tianZy/chuanTong/sessionStorage.controller', //职业优先填报 - 院校优先 - 专业优先之间的购物车值保存
        'tzy/chuanTong/common': 'scripts/controllers/tzy/tianZy/chuanTong/common.controller', //填志愿-传统版和江苏版-通用JS

        //===========main services start
        'services/base': 'scripts/services/base.service', //所有调用数据服务基类
        'services/config': 'scripts/services/config',
        'services/common/youzyEpt': 'scripts/services/common/youzyEpt.service',
        'services/workContext': 'scripts/services/workContext.service',
        'services/common/gtCaptcha': 'scripts/services/common/gtCaptcha.service',
        'services/common/aes': 'scripts/services/common/aes.service',
        'services/common/aesHelp': 'scripts/services/common/aeshelp.service',
        'services/common/common': 'scripts/services/common/common.service', //业务通用service 例 获取高考年
        'services/common/areas': 'scripts/services/common/areas.service',
        'services/common/sessionStorage': 'scripts/services/common/sessionStorage.controller',
        'services/common/tools': 'scripts/services/common/tools.service',
        'services/common/paging': 'scripts/services/common/paging.service',
        'services/common/pagingChooseSubject': 'scripts/services/common/pagingChooseSubject.service', //选科弹框里的分页专供
        'services/common/handlebarsHelper': 'scripts/services/common/handlebarsHelper.service', //通用helper
        'services/iframe': 'scripts/services/common/iframe.service',
        'services/ares': 'scripts/services/ares/ares.service', //ares埋点
        'services/ub4y': 'scripts/services/ub4y/track.service', //ub4y埋点

        //===========business services start
        'services/openAuth': 'scripts/services/openAuth/openAuth.service', //三方登录
        'services/payment/order': 'scripts/services/payment/order.service', //支付服务
        'services/aboutUs': 'scripts/services/aboutUs/aboutUs.service', //优志愿 关于我们
        'services/lessons': 'scripts/services/lessons/lessons.service', //课堂-课程服务-德智
        'services/examination': 'scripts/services/examination/examination.service', //课堂-试卷服务
        'services/classrooms': 'scripts/services/classrooms/classrooms.service', //课堂-讲堂服务
        'services/experts': 'scripts/services/experts/experts.service', //专家服务
        'services/expertsOP': 'scripts/services/experts/expertsOP.service', //开放服务-专家服务
        'services/helpCenter': 'scripts/services/helpCenter/helpCenter.service', //帮助中心
        'services/studyTour': 'scripts/services/studyTour/studyTour.service', //留学
        'services/tzy/evaluation/download': 'scripts/services/tzy/evaluation/download.service', //测评-下载服务
        'services/tzy/evaluation/questions': 'scripts/services/tzy//evaluation/questions.service', //测评-获取题库服务
        'services/tzy/evaluation/results': 'scripts/services/tzy/evaluation/results.service', //测评-获取题库结果服务
        'services/tzy/evaluation/scores': 'scripts/services/tzy/evaluation/scores.service', //测评-提交测评结果服务
        'services/tzy/evaluation': 'scripts/services/tzy/evaluation/evaluation.service', //测评服务
        'services/tzy/evaluation/tips': 'scripts/services/tzy/evaluation/tips.service', //测评-提示文字
        'services/colleges': 'scripts/services/colleges/colleges.service', //找大学、大学详情页模块
        'services/majors': 'scripts/services/majors/majors.service', //专业服务
        'services/scoreLines': 'scripts/services/scoreLines/scoreLines.service', //分数线、招生计划等模块
        'services/configuration': 'scripts/services/configuration/configuration.service', //配置服务-获取分数线等各种
        'services/zyRule': 'scripts/services/configuration/zyRule.service', //志愿配置服务
        'services/gaokao': 'scripts/services/configuration/gaokao.service', //新高考配置服务
        'services/configuration/scoreLine': 'scripts/services/configuration/scoreLines.service', //分数线等模块配置信息
        'services/careers': 'scripts/services/careers/careers.service', //职业库
        'services/cards': 'scripts/services/cards/cards.service', //会员卡服务
        'services/users': 'scripts/services/users/users.service', //用户服务
        'services/users/chooseSubjectsSolution': 'scripts/services/users/chooseSubjectsSolution.service', //用户选科服务
        'services/users/zyTable': 'scripts/services/users/zyTable.service', //智能填报-志愿表服务
        'services/users/sms': 'scripts/services/users/sms.service', //用户sms服务
        'services/users/socials': 'scripts/services/users/socials.service', //用户三方服务
        'services/users/scores': 'scripts/services/users/scores.service', //用户成绩服务
        'services/users/logs': 'scripts/services/users/logs.service', //用户日志服务
        'services/users/useFunctionLogs': 'scripts/services/users/useFunctionLogs.service', //用户使用日志
        'services/users/searchKeywords': 'scripts/services/users/searchKeywords.service', //用户搜索记录
        'services/collection': 'scripts/services/users/collection.service', //用户关注服务
        'services/students/expertFillin': 'scripts/services/students/expertFillin.service', //专家一对一服务
        'services/students/zyTable': 'scripts/services/students/zyTable.service', //智能填报-志愿表服务
        'services/users/scores': 'scripts/services/users/scores.service', //用户成绩服务
        'services/chooseSubjects': 'scripts/services/chooseSubjects/chooseSubjects.service', //选科服务
        'services/chooseSubjects/colleges': 'scripts/services/chooseSubjects/colleges.service', //选科-院校服务
        'services/chooseSubjects/majors': 'scripts/services/chooseSubjects/majors.service', //选科-专业服务
        'services/students/favoriteTag': 'scripts/services/students/favoriteTag.service', //选科服务
        'services/tzy/collegeEnroll': 'scripts/services/tzy/collegeEnroll.service', //填志愿模块招生服务
        'services/tzy/preFraction': 'scripts/services/tzy/preFraction.service', //填志愿提前批
        'services/tzy/func': 'scripts/services/tzy/func.service', //成绩查询服务
        'services/tzyCdiData': 'scripts/services/tzy/expertTzyConditionData.service', //智能推荐通用数据
        'services/tzy/recommendation': 'scripts/services/tzy/recommendation.service', //智能推荐服务
        'services/tzy/tzyCollegeFirst': 'scripts/services/tzy/tzyCollegeFirst.service', //智能推荐-院校优先
        'services/tzy/tzyMajorFirst': 'scripts/services/tzy/tzyMajorFirst.service', //智能推荐-专业优先
        'services/tzy/tzyManualFill': 'scripts/services/tzy/tzyManualFill.service', //智能推荐-职业优先填报
        'services/tzy/chooseSubject': 'scripts/services/tzy/chooseSubject.service', //选科服务
        'services/tzy/zhiYuanTable': 'scripts/services/tzy/zhiYuanTable.servie', //新版智能填报
        'services/payments': 'scripts/services/payments/payments.service', //支付服务
        'services/order/zyTables': 'scripts/services/order/zyTables.service', //专家志愿表服务
        'services/news': 'scripts/services/news/news.service', //新闻服务
        'services/activities/chuCaiBei': 'scripts/services/activities/chuCaiBei.service', //楚才杯服务
        'services/activities/studyAbroad': 'scripts/services/activities/studyAbroad.service', //留学预约服务
        'services/openPlatform': 'scripts/services/openPlatform/openPlatform.service', //开发平台
        'services/notification': 'scripts/services/notification/notification.service', //小优快讯
        'services/homepage': 'scripts/services/homepage/homepage.service',
        'services/dataCenter': 'scripts/services/dataCenter/dataCenter.service',
        'services/community': 'scripts/services/community/comment.service',
        'services/stores': 'scripts/services/stores/stores.service', //机构服务
        'services/aliyun': 'scripts/services/aliyun/aliyun.service', //阿里云服务
        'services/live': 'scripts/services/live/live.service', //直播
        //defy
        'services/defy/search': 'scripts/services/defy/search.service', //搜索服务


        //===========business controllers start
        'controllers/tzy/tianZy/shanDong/shopingCar': 'scripts/controllers/tzy/tianZy/shanDong/shopingCar.controller', //山东购物车
        'controllers/tzy/tianZy/zheJiang/shopingCar': 'scripts/controllers/tzy/tianZy/zheJiang/shopingCar.controller', //浙江购物车
        'controllers/tzy/tianZy/beiJing/shopingCar': 'scripts/controllers/tzy/tianZy/beiJing/shopingCar.controller', //北京购物车
        'controllers/tzy/tianZy/tianJin/shopingCar': 'scripts/controllers/tzy/tianZy/tianJin/shopingCar.controller', //天津购物车
        'controllers/tzy/tianZy/haiNan/shopingCar': 'scripts/controllers/tzy/tianZy/haiNan/shopingCar.controller', //海南购物车
        'controllers/tzy/tianZy/shangHai/shopingCar': 'scripts/controllers/tzy/tianZy/shangHai/shopingCar.controller', //上海购物车
    },
    shim: {
        'ueditor/config': {
            deps: ['jquery']
        },
        'ueditor': {
            deps: ['ueditor/config']
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'handlebars': {
            exports: 'Handlebars'
        },
        'easyPieChart': {
            deps: ['jquery', 'easing1.3']
        },
        'highlightRegex': {
            deps: ['jquery']
        },
        'highcharts': {
            deps: ['jquery']
        },
        'highcharts5': {
            deps: ['jquery']
        },
        'highchartsMore5': {
            deps: ['jquery', 'highcharts5']
        },
        'tmpl': {
            deps: ['jquery']
        },
        'baiduMap': {
            deps: ['jquery']
        },
        'dragdealer': {
            deps: ['jquery']
        },
        'jqueryPagination': {
            deps: ['jquery']
        },
        'fancybox': {
            deps: ['jquery']
        },
        'fancyboxThumbs': {
            deps: ['jquery']
        },
        'superSlide': {
            deps: ['jquery']
        },
        'placeholder': {
            deps: ['jquery']
        },
        'json2': {
            deps: ['jquery']
        },
        'json3': {
            deps: ['jquery']
        },
        'qrcode': {
            deps: ['jquery', 'qrcodeUtils']
        },
        'suggest': {
            deps: ['jquery']
        },
        'datetimepickers-zh': {
            deps: ['jquery', 'datetimepickers']
        },
        'raty': {
            deps: ['jquery']
        },
        'slimScroll': {
            deps: ['jquery']
        },
        'umpplayer': {
            deps: ['jquery']
        },
        'jwplayer': {
            deps: ['jquery']
        },
        datetimepicker: {
            deps: ['jquery']
        },
        'bootstrap-datetimepicker': {
            deps: ['jquery']
        },
        'datetimepickerMonth': {
            deps: ['jquery', 'bootstrap-datetimepicker']
        },
        'dateRangePicker': {
            deps: ['jquery', 'moment']
        },
        'aliplayerComponent': {
            deps: ['aliplayer']
        }
    }

});

require.onError = function (err) {
    console.log(err.requireType);
    if (err.requireType === 'timeout') {
        console.log('modules: ' + err.requireModules);
    }
    throw err;
};

//初始化方法
require(['jquery', 'services/config', 'services/workContext', 'services/users', 'services/common/tools',
        'dialogs/users/userLogin', 'dialogs/openAuth/weixinLogin', 'dialogs/users/perfectMobile',
        'dialogs/users/perfectCourseType', 'dialogs/users/perfectInfo', 'services/configuration/scoreLine',
        'placeholder', 'bootstrap'
    ],
    function ($, configService, workContext, userService, tools,
              userLoginDialog, weixinLoginDialog, userPerfectMobileDialog,
              userPerfectCourseTypeDialog, userPerfectInfoDialog, scoreLineService) {

        if (configService.isRelease == false) {
            console.log(workContext.currentProvince)
            console.log(workContext.currentLoginUser)
            console.log(workContext.currentScore)
            console.log(workContext.ufs)
            console.log(workContext.TempScore)
        }

        if (workContext.currentLoginUser.numId > 0) {
            //登录后，并且没有绑定手机的用户，需要绑定手机
            if (workContext.currentLoginUser.mobilePhone == '' || workContext.currentLoginUser.mobilePhone == null) {
                userPerfectMobileDialog.open(0);
            }
        }

        //三方登录后，需要绑定手机
        if (workContext.openUser != '') {
            if (workContext.currentLoginUser.mobilePhone == '' || workContext.currentLoginUser.mobilePhone == null) {
                userPerfectMobileDialog.open(1);
            }
        }

        //根据条件判断需要完善的资料
        if (workContext.currentLoginUser.numId > 0) {

            if (workContext.currentLoginUser.provinceId == '' || workContext.currentLoginUser.provinceId == 0) {
                if (window.location.href.indexOf('set-token') === -1) {
                    userPerfectInfoDialog.open();
                }
            } else {
                scoreLineService.getByProvinceNumId(workContext.currentLoginUser.provinceId).done(function (res) {
                    switch (workContext.currentLoginUser.provinceId) {
                        case 1:
                        case 839:
                        case 845:
                        case 850:
                        case 851:
                        case 849:
                        case 850:
                        case 854:
                        case 1128:
                            res.result.isOpenNewVersion = true
                            break;

                        default:
                            break;
                    }
                    // if (!res.result.isOpenNewVersion && workContext.currentLoginUser.courseType != 0 && workContext.currentLoginUser.courseType != 1) {
                    //     userPerfectCourseTypeDialog.open();

                    // }
                })
            }

            // if (workContext.currentLoginUser.provinceId != 843 && workContext.currentLoginUser.provinceId != 842 && workContext.currentLoginUser.provinceId != 847 && workContext.currentLoginUser.courseType == -1) {
            //     // 完善文理科
            //     userPerfectCourseTypeDialog.open();
            // }
        }

        $(window).scroll(function () {
            //回到顶部按钮显示隐藏
            if ($(window).scrollTop() > 400) {
                $("#onlineTop").show(400);
            } else {
                $("#onlineTop").hide(400);
            }
        });

        var rightWidgets = function () {
            if ($(window).width() <= 1400) {
                $('.right-widgets').css('display', 'none');
            } else {
                $('.right-widgets').css('display', 'block');
            };
        }
        rightWidgets();
        window.onresize = function () {
            rightWidgets();
        }

        //回到顶部按钮
        $("body").delegate(".right-widgets .t3", "click", function () {
            $('body,html').animate({
                scrollTop: 0
            }, 300);
            return false;
        })

        //顶部通用搜索
        $('#btntopSearch').on('click', function () {
            var keywords = $("#searchwd").val().trim();
            if (keywords.length >= 2) {
                var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                if (reg.test(keywords) == false) {
                    tools.alert.warning("提醒", "仅支持汉字、英文、数字，请重新输入关键字进行搜索")
                } else {
                    window.location.href = '/search/articleList?wd=' + keywords;
                }
            } else {
                tools.alert.warning("提醒", "请输入至少2个汉字、英文或数字进行搜索")
            }

        });
        $("#searchwd").keyup(function () {
            if (event.keyCode == 13) {
                //这里写你要执行的事件;
                var keywords = $("#searchwd").val().trim();
                if (keywords.length >= 2) {
                    var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
                    if (reg.test(keywords) == false) {
                        tools.alert.warning("提醒", "仅支持汉字、英文、数字，请重新输入关键字进行搜索")
                    } else {
                        window.location.href = '/search/articleList?wd=' + keywords;
                    }
                } else {
                    tools.alert.warning("提醒", "请输入至少2个汉字、英文或数字进行搜索")
                }
            }
        });

        //登录
        $("#divLogin").on("click", function () {
            userLoginDialog.open();
        });

        //微信登录
        $('.js-weixinLogin').on("click", function () {
            weixinLoginDialog.open();
        });

        //体验VIP领取
        $('.scan-btn').mouseenter(function () {
            $(this).siblings('.scan-ewm-box').addClass('active')
        })
        $('.scan-btn').mouseleave(function () {
            $(this).siblings('.scan-ewm-box').removeClass('active')
        })


    });

//---------------------
require(['jquery', 'underscore', 'handlebars', 'services/common/tools', 'dialogs/paymentDialog', 'superSlide',
        'fancyboxThumbs'
    ],
    function ($, _, handlebars, tools, paymentDialog) {

        var vc = {};
        vc.modules = {};

        var $container = $(".card-info");
        var $orderName = '升学卡在线购买';
        var $yearNum = $('.card-year');

        var $type1Text = $(".type1"); //志愿卡
        var $type2Text = $(".type2"); //升学卡
        var $type3Text = $(".type3"); //职业招生宝典
        var $type4Text = $(".type4"); //职业招生宝典和卡

        var priceContext = {
            type: 1,
            year: 1,
            num: 1,
            price: '0',
            productType: 4,
            title: '',
            detail: '请选择卡类型'
        }

        var cartInfo = {
            bussType: 0,
            productName: '',
            orderPrice: 0
        }


        vc.modules.render = function () {
            var _renderUsersSay = function () {
                //服务用户评价
                var cDate = new Date();
                var arr = [{
                    "userName": "135****598",
                    "appraise": "数据比较准，有高考课堂可以看免费看老师们的视频和大学学姐学长讲专业，服务不贵好用推荐大家哦！",
                    time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                        .getDate()
                },
                    {
                        "userName": "小*天",
                        "appraise": "拿到了张体验卡，开始很抵触，因为免费试用了一下，体验下来真不错，服务的价格也不贵关键是实用，所以就升级开通了服务啦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "159****9182",
                        "appraise": "高考是人生的一次重大的转折，志愿报名更是重要，优志愿上的学校信息都非常全面并且信息专业靠谱，开通服务后畅通无阻，特别喜欢一键填报，直接推荐4套志愿方案，省时省力，赞赞赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "张*辉",
                        "appraise": "女儿快要考了，家长就关注高考的各种动态咨询，特别推荐其他家长看下讲堂那个板块，开通服务后几乎每个专家的视频都看过，从专业到心理调整很全面受益匪浅。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "有**你",
                        "appraise": "作为家长现在也没办法在学习上帮她太多了，只有在后期好好支持支持她，现在多看看学校专业介绍、志愿模拟填报，以后就不会迷茫了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "灭**魔",
                        "appraise": "好用，特别喜欢一键填报功能，适合我这种懒人，哈哈喜欢！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "L****p",
                        "appraise": "这个网站还真的很实用的说，只要把分数地区文理等相关信息输进去就可以显示出自己适合什么学校，服务内容丰富价格实在，现在我妈手机下载了app看的可勤快了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "清**杯",
                        "appraise": "推荐和我一样奋战在高考前线的同志们，优志愿服务靠谱、有效、便捷、精准！哈哈我好像水军哦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "M****y",
                        "appraise": "优志愿讲堂内容丰富，上千位在校学长讲自己大学的专业，超级牛，果断服务，这样就可以随便看啦！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "C******g",
                        "appraise": "总结一下服务滴优点：功能强大，课程丰富，数据权威，使用方便。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "侧**听",
                        "appraise": "与其他同类型网站相比，价格算良心的，实用型的网站，蛮好的告别翻书。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "王*乐",
                        "appraise": "优志愿，很棒的网站！会及时通知与高考相关的事情，网站的内容都很有价值。这个服务值得购买。点个赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "為**鈊",
                        "appraise": "很多实时的高考资讯、学校的招生等等都更新很快，报考指南、专业的学习辅导都很实用，模拟填报功能的数据也准确！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "郭*浩",
                        "appraise": "强烈推荐大家使用测录取概率功能，我把想上的学校都测了个遍，感觉又好玩又实用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "宝**曦",
                        "appraise": "表扬下优志愿app，真的好用，信息量很强大不亚于网站，作为高三学生的家长这个app点击量是最高的，开通服务后一直看老师们的课程，对我们帮助非常大。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "T**p",
                        "appraise": "很好用的志愿填报网站，这段时间孩子们很辛苦，可是我们家长也要在后面多学习点专业、学校、志愿填报方面的知识，不要等到填志愿的时候没有头绪，准备考试结束后再预约个专家。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "洪*睿",
                        "appraise": "花小钱大回报，开通了服务功能，内容丰富，一键填报方案也很合理，现在考虑预约个专家团。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "186****8737",
                        "appraise": "作为一个第二次参加高考的考生真觉得这个网站很全面，去年我全靠翻书填报的志愿，二本线过了，可是最后只能读专科，果断复读，接触到优志愿这个网站后果断购买了服务，因为我不想再填志愿上面重蹈覆辙。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "12****12",
                        "appraise": "马上就要参加高考了，一直都没想好想去哪里读大学，连专业都没有方向，偶尔碰到了优志愿这个志愿模拟系统，可真方便，信息也准确的，推荐开通服务，用起来更不受限制。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "x*****e",
                        "appraise": "填志愿的好助手啊！不错不错哦！给妈妈手机下载了优志愿软件，现在看的比我还勤快！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "郁*容",
                        "appraise": "网站关于高考的内容还是比较全面的，功能性很强，信息的更新也很快，服务功能也算合理，特别推荐大家看下几位专家专题视频，个人觉得很受用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "183****2867",
                        "appraise": "对即将高考的考生和家长来说很不错，能够了解高考的最新消息与动态，推荐大家使用模拟填报，不要等真天志愿了无从下手。总的来说网站的服务权限很强大，值得大家一看。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "彩**文",
                        "appraise": "这个服务性价比还挺高的，特别推荐高中的同学一开始就使用，可以为自己定一个目标院校，有了目标才有动力，现在这个目标已经离我越来越近了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "L******Z",
                        "appraise": "强推优志愿服务功能哦！可以提供很多和高考择校相关的有用信息，和避免志愿填报上面的盲区。超级赞！！！！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "E****O",
                        "appraise": "优志愿讲堂内容好丰富，好多在校学长讲自己大学的专业，对很多专业有了新的了解，只可惜很多专家课程需要购买才能看到，所以干脆开通了服务功能，发现还是很实用的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "陈*云",
                        "appraise": "刚开通了服务功能，给孩子做一个高考目标定位，看看孩子现在的成绩到底能上到哪些大学，院校优先填报、一键填报和模拟填报都非常给力，数据靠谱推荐给高三的家长们！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "心**水",
                        "appraise": "这个系统可以用分数来进行分析可以上哪所大学，特别是靠谱率感觉很神奇啊！还能通过性格等测试推荐就读的专业系别，挺好用的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "雨**落",
                        "appraise": "整个网站感觉都蛮靠谱的，数据信息都很全面，功能性也强，开通服务的价格也算得上是业界良心了，对比了很多家才选择开通优志愿。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "157****1351",
                        "appraise": "这个网站使用还是很方便的，作为一个高三学生家长，看了好多好多这类网站，感觉都好复杂有点晕菜啊！这里的一键填报真的是很方便，志愿填报感觉也没那么复杂。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "天****手",
                        "appraise": "拿到优志愿的体验卡，开始没在意，最近偶然发现，登录后发现感觉不错，涨姿势了，用了几天发现服务权限更大，关键是价格不贵，很好！赞！推荐！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "路***猪",
                        "appraise": "不错不错不错，重要的事情说三遍。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "b***2",
                        "appraise": "挺好的，开通了服务，现在每天都会上来测测录取概率，模拟填报，提前为孩子填志愿做准备。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "荆***约",
                        "appraise": "这家的志愿填报是我用到现在数据最准确的，推的学校也很靠谱",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "神***丶",
                        "appraise": "推荐给高三的学子和家长们，本人鉴定过了，很靠谱的网站。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "j***6",
                        "appraise": "内容全，功能强，信息更新额也很快，蛮好的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "像***红",
                        "appraise": "因为看了李老师的直播，讲的很有道理，给我们家长很多帮助，所以开通了服务，觉得这个网站蛮好的，孩子忙着备考，家长也要早做准备。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "y***3",
                        "appraise": "开通了服务，发现预约专家团是赠送服务功能的，早知道就先预约专家团了，孩子就那么一次高考，还是准备预约个专家帮我们分析下很有必要的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "159****7822",
                        "appraise": "我今年才高二，提早做准备，哈哈哈！还过一年我也要参加高考了，但是我已经锁定目标学校了，还有1年多，为了目标，我要努力努力。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "喊***哥",
                        "appraise": "别人送的服务卡，反正免费的登录看看，没想到发现新大陆啊，院校优先的那个功能推荐的学校大多数都是我喜欢的学校，真心好用哦！推荐！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "赵***5",
                        "appraise": "作为苦逼高三党，强推优志愿的服务功能，操作方便，速度快，哦对了！我说的是app，哈哈哈！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "s***8",
                        "appraise": "为了看视频才开通的服务，没想到还有直播了，问的问题李老师解答的好清楚，真的对我们家长的帮助很大啊，用孩子模考成绩模拟填报，发现离目标学校还有点距离，这么点时间了，只能靠孩子自己用功了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "酱***7",
                        "appraise": "恩！可以！现在家长比孩子紧张啊！希望对孩子有帮助。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "x****l",
                        "appraise": "优志愿关注蛮久了，老实说之前大多数功能都可以用的，现在都要开通服务了，好在价格不贵，性价比还算可以。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "龙***人",
                        "appraise": "用同学账号做了测录取概率的测试，感觉蛮方便的，所以自己也开通了服务功能，因为太坏了还有次数限制55555.....",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "阿***脑",
                        "appraise": "别人帮我开通的服务卡，看了下感觉网站还不错，准备研究研究怎么玩法。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "上*****花",
                        "appraise": "学校发的体验卡，试用了下，很有针对性，所以毫不犹豫的开通了服务功能，试用很方便，特别是手机上，使用方便，赞！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "刘***4",
                        "appraise": "好用、推荐、可怜的高三党们！当然我也是其中一位啦！为自己目标努力！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "1***k",
                        "appraise": "朋友推荐优志愿的，使用下来觉得还是很方便的，不管是在电脑上还是手机上，就是大多数功能都需要服务权限，胜在价格不贵，总体还是值得推荐的。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "妮*",
                        "appraise": "好用！！方便！！全面！！靠谱！！使用方便！哈哈哈!我不是托~~~",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "可*多",
                        "appraise": "家长群里其他家长推荐的网站，最近这种类型网站是在看的太多了，综合看下来还是优志愿推荐的学校比较靠谱！这个服务的钱没白花！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "心***星",
                        "appraise": "了能进入梦想的大学，享受那种氛围，我不停努力，早早为自己的未来做规划，因为我今年高二，看到学姐学长么那么认真的学习，我也要不停加油！加油！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "s***p",
                        "appraise": "刚开始我是排斥收费的，但是使用后我觉得开通服务还是和值得的，现在就是我的志愿小助手！啦啦啦啦~~~",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "吴*少",
                        "appraise": "读书不好今年估计也就上个专科，所以准备复读了，感觉怎么都得混个本科学历吧！这学校信息很强啊！分数线都很全，提前先了解哪些学校我考得上的，北大清华什么的就膜拜膜拜吧！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "O**7",
                        "appraise": "临近考试，作为家长越来越紧张，但是又不能让儿子看出来，哎~高三的孩子辛苦，家长也辛苦啊！还好马上就要熬出头了，最近每天都会上这里看看咨询、或是老师们的视频，特别推荐专业解读这个版块，孩子们讲的都很好很用心，几乎所有学校专业都看过了！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "177****8954",
                        "appraise": "马上就要高考啦！高三苦逼的孩子们一起加油吧！我们大学见！！！！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "a****8",
                        "appraise": "好喜欢一键填报功能，帮我推荐的所有地区的学校，太有参考价值了，我妈也说推荐的几所学校都不错，就是还不知道到低选哪个专业，她说干脆预约个老师帮我参考参考。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "8***j",
                        "appraise": "这个服务权限还是很良心的，价格不贵，功能也蛮多的，关键是信息比较准确，对孩子填志愿能起到一定的作用。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "179****487",
                        "appraise": "在线开通服务功能很方便啊，支付宝扫一扫就好了，就是能有点折扣什么的就好了。",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    },
                    {
                        "userName": "万*宇",
                        "appraise": "分想预约个专家团试试看啊！但毕竟价格不便宜，所以先开通了服务试试水，使用下来整个网站有些功能有点复杂啊！不过还好都有提示稍微摸索下就了解了，如果预约专家团能优惠就好了，哈哈哈哈！",
                        time: cDate.getFullYear() + '.' + (cDate.getMonth() + 1) + '.' + cDate
                            .getDate()
                    }
                ];

                var round = _.sample(arr, 30);
            }
            var _renderPhotos = function () {
                //购买幻灯图片
                $(".card-show .photes-box li").eq(0).show();
                $(".card-show .nail li").mouseenter(function () {
                    var index = $(".card-show .nail li").index(this);
                    $(".card-show .nail li").removeClass("active");
                    $(this).addClass("active");
                    $(".card-show .photes-box li").hide();
                    $(".card-show .photes-box li").eq(index).show();
                });

                //会议幻灯片
                $(".picScroll-left").slide({
                    titCell: ".hd ul",
                    mainCell: ".bd ul",
                    effect: "left",
                    autoPlay: true,
                    trigger: "click"
                });
            }
            var _renderSecret = function () {
                //展开秘密
                $('.secret .unfold').on('click', function () {
                    $(this).addClass('hide');
                    $('.secret-txt').removeClass('hide');
                })
                $('.secret .fold').on('click', function () {
                    $('.secret .unfold').removeClass('hide');
                    $('.secret-txt').addClass('hide');
                })
            }
            var _renderVipTip = function () {
                //查看VIP特权
                $('.card-buy-v3 .vip-tip').on('mouseenter', function () {
                    $('.card-buy-v3 .vip-tip-table').css('display', 'block');
                })
                $('.card-buy-v3 .vip-tip').on('mouseleave', function () {
                    $('.card-buy-v3 .vip-tip-table').css('display', 'none');
                })
            }
            var _renderVipContent = function () {
                $(window).scroll(function () {
                    var $scroll = $(document).scrollTop();

                    //vip
                    //part1
                    if ($scroll >= 0) {
                        $('.part1-1').removeClass('hide').addClass('fadeIn')
                        $('.part1-2').removeClass('hide').addClass('fadeIn')
                        $('.part1-3').removeClass('hide').addClass('fadeInUp')
                        $('.part1-4').removeClass('hide').addClass('fadeInUp')
                        $('.part1-5').removeClass('hide').addClass('fadeInUp')
                        $('.part1-6').removeClass('hide').addClass('fadeInUp')
                        $('.part1-7').removeClass('hide').addClass('fadeInRight')
                    }

                    //part2
                    if ($scroll >= 800) {
                        $('.part2-1').removeClass('hide').addClass('fadeInUp')
                        $('.part2-4').removeClass('hide').addClass('fadeInDown')
                        $('.part2-2').removeClass('hide').addClass('fadeInUp')
                        $('.part2-3').removeClass('hide').addClass('fadeInUp')
                    }

                    //part3
                    if ($scroll >= 1200) {
                        $('.part3-1').removeClass('hide').addClass('fadeInUp')
                        $('.part3-2').removeClass('hide').addClass('fadeInLeft')
                        $('.part3-3').removeClass('hide').addClass('fadeInUp')
                        $('.part3-4').removeClass('hide').addClass('fadeInRight')
                    }

                    //part4
                    if ($scroll >= 1800) {
                        $('.part4-1').removeClass('hide').addClass('fadeInUp')
                        $('.part4-2').removeClass('hide').addClass('fadeInLeft')
                        $('.part4-3').removeClass('hide').addClass('fadeInUp')
                        $('.part4-4').removeClass('hide').addClass('fadeInDown')
                        $('.part4-5').removeClass('hide').addClass('fadeInUp')
                        $('.part4-6').removeClass('hide').addClass('fadeInDown')
                    }

                    //part5
                    if ($scroll >= 2300) {
                        $('.part5-1').removeClass('hide').addClass('fadeInUp')
                        $('.part5-2').removeClass('hide').addClass('fadeInUp')
                        $('.part5-3').removeClass('hide').addClass('fadeInRight')
                        $('.part5-4').delay(1000).removeClass('hide').addClass('zoomIn')
                        $('.part5-5').delay(2000).removeClass('hide').addClass('zoomIn')
                        $('.part5-6').delay(3000).removeClass('hide').addClass('zoomIn')
                        $('.part5-7').delay(4000).removeClass('hide').addClass('zoomIn')
                    }

                    //part6
                    if ($scroll >= 2800) {
                        $('.part6-1').removeClass('hide').addClass('fadeInUp')
                        $('.part6-2').removeClass('hide').addClass('fadeInUp')
                        $('.part6-3').removeClass('hide').addClass('fadeInLeft')
                        $('.part6-4').removeClass('hide').addClass('fadeInUp')
                        $('.part6-5').removeClass('hide').addClass('fadeInDown')
                        $('.part6-6').removeClass('hide').addClass('fadeInUp')
                    }
                })
            }
            var _renderSxkContent = function () {
                $(window).scroll(function () {
                    var $scroll = $(document).scrollTop();

                    //shengxueka
                    //part2
                    if ($scroll >= 800) {
                        $('.partb2-1').removeClass('hide').addClass('fadeInUp')
                        $('.partb2-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb2-3').removeClass('hide').addClass('fadeInDown')
                        $('.partb2-4').removeClass('hide').addClass('zoomIn')
                    }

                    //part3
                    if ($scroll >= 900) {
                        $('.partb3-1').removeClass('hide').addClass('fadeInDown')
                        $('.partb3-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb3-3').removeClass('hide').addClass('fadeInUp')
                    }

                    //part4
                    if ($scroll >= 1100) {
                        $('.partb4-1').removeClass('hide').addClass('fadeInUp')
                        $('.partb4-2').removeClass('hide').addClass('fadeInDown')
                        $('.partb4-3').removeClass('hide').addClass('fadeInUp')
                        $('.partb4-4').removeClass('hide').addClass('fadeInUp')
                    }

                })
            }
            return {
                renderUsersSay: _renderUsersSay,
                renderPhotos: _renderPhotos,
                renderSecret: _renderSecret,
                renderVipTip: _renderVipTip,
                renderVipContent: _renderVipContent,
                renderSxkContent: _renderSxkContent
            }
        }()

        vc.modules.service = function () {
            //根据参数显示价格
            var _changePrice = function () {
                $('#now-price').html('￥' + priceContext.price);

                $('#base-price').html('原价：￥' + priceContext.detail);
                if (priceContext.type == 3)
                    $('#base-price').addClass('hide');
                else
                    $('#base-price').removeClass('hide');
                $('#card-title').html(priceContext.title);
            }
            //判断是否需要改动价格
            var _checkPrice = function () {
                if (priceContext.type == 1) {
                    priceContext.price = '360';
                    priceContext.detail = '698';
                    priceContext.title = '志愿卡（VIP）';
                    priceContext.productType = 4;
                    return false;
                }
                if (priceContext.type == 2) {
                    priceContext.price = '460';
                    priceContext.detail = '1098';
                    priceContext.title = '升学卡（VIP+全科提分）';
                    priceContext.productType = 23;
                    return false;
                }
                if (priceContext.type == 3) {
                    priceContext.price = '200';
                    priceContext.detail = '598';
                    priceContext.title = '职业招生卡（送自招宝典）'
                    priceContext.productType = 26;
                    return false;
                }
                if (priceContext.type == 4) {
                    priceContext.price = '560';
                    priceContext.detail = '1298';
                    priceContext.title = '升学卡+职业招生卡（送自招宝典）'
                    priceContext.productType = 27;
                    return false;
                }
                return true;
            }
            return {
                changePrice: _changePrice,
                checkPrice: _checkPrice
            }
        }()

        vc.modules.bindEvent = function () {
            //选择类型
            var _chooseType = function () {
                $('.card-type a').on('click', function () {
                    $(this).addClass('choosed');
                    $(this).siblings().removeClass('choosed');
                    var _type = $(this).data('type');
                    switch (_type) {
                        case 1:
                            priceContext.type = 1;
                            $yearNum.addClass('hide');
                            vc.modules.service.checkPrice();
                            vc.modules.render.renderVipContent();
                            $type1Text.removeClass("hide");
                            $type2Text.addClass("hide");
                            $type3Text.addClass("hide");
                            $type4Text.addClass("hide");
                            break;
                        case 2:
                            priceContext.type = 2;
                            $yearNum.removeClass('hide');
                            vc.modules.service.checkPrice();
                            vc.modules.render.renderSxkContent();
                            $type2Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type3Text.addClass("hide");
                            $type4Text.addClass("hide");
                            break;
                        case 3:
                            priceContext.type = 3;
                            $type3Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type2Text.addClass("hide");
                            $type4Text.addClass("hide");
                            vc.modules.service.checkPrice();
                            break;
                        case 4:
                            priceContext.type = 4;
                            $type4Text.removeClass("hide");
                            $type1Text.addClass("hide");
                            $type2Text.addClass("hide");
                            $type3Text.addClass("hide");
                            vc.modules.service.checkPrice();
                            break;
                    }
                    $(".card-show" + _type).slide({
                        mainCell: ".photes-box ul",
                        effect: "fold",
                        autoPlay: true,
                        triggerTime: 0,
                        pnLoop: true,
                        defaultPlay: true
                    });


                    //针对上海版做特殊处理
                    try {
                        if ($type1Text.find("p")[4].innerHTML.indexOf("上海不提供普通类") != -1) {
                            $type1Text.find("p")[5].innerHTML = $type1Text.find("p")[5].innerHTML.replace("6", "5")
                            $($type1Text.find("p")[4]).addClass("hide")

                            $type2Text.find("p")[5].innerHTML = $type1Text.find("p")[5].innerHTML.replace("6", "5")
                            $($type2Text.find("p")[4]).addClass("hide")
                        } else {
                        }

                        // $type2Text
                    } catch (error) {

                    }


                    vc.modules.service.changePrice();
                })
            }
            //购买记录切换卡
            var _chooseTab = function () {
                //VIP购买记录切换卡
                $(".privilege-up .nav a").click(function () {
                    var index = $(".privilege-up .nav a").index(this);
                    $(".privilege-up .nav a").removeClass("active");
                    $(this).addClass("active");
                    $(this).parent().siblings(".privilege-list").addClass("hide");
                    $(this).parent().siblings(".privilege-list").eq(index).removeClass("hide");
                })
            }
            //购买
            var _jsOnlineBuy = function () {
                $('.js-onlineBuy').on('click', function () {
                    if (parseInt(priceContext.price) == 0) {
                        vc.modules.service.checkPrice();
                    }
                    if (priceContext.type == 0 || priceContext.year == 0 || priceContext.type ==
                        undefined || priceContext.year == undefined) {
                        error.html("请选择类型、周期");
                        error.removeClass('hide');
                        return false;
                    }

                    cartInfo.bussType = priceContext.productType;
                    cartInfo.productName = priceContext.title;
                    cartInfo.orderPrice = priceContext.price;

                    paymentDialog.open(cartInfo);

                })
            }
            return {
                chooseType: _chooseType,
                chooseTab: _chooseTab,
                jsOnlineBuy: _jsOnlineBuy
            }
        }()

        var init = function () {

            //右侧专家相册大图浏览
            $(".fancybox-thumbs-right").fancybox({
                prevEffect: "none",
                nextEffect: "none",
                closeBtn: false,
                helpers: {
                    title: {
                        type: "inside"
                    },
                    buttons: {}
                }
            });

            vc.modules.render.renderUsersSay();
            vc.modules.render.renderPhotos();
            vc.modules.render.renderSecret();
            //vc.modules.render.renderVipTip();

            vc.modules.bindEvent.chooseType();
            vc.modules.bindEvent.chooseTab();

            vc.modules.bindEvent.jsOnlineBuy();

            var typeId = tools.getQueryStr('type') || 1;
            $('#type' + typeId).click();

        }

        init();

    })

