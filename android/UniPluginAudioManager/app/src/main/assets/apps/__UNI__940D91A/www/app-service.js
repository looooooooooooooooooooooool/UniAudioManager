(this["webpackJsonp"]=this["webpackJsonp"]||[]).push([["app-service"],{"0de9":function(t,e,n){"use strict";function r(t){var e=Object.prototype.toString.call(t);return e.substring(8,e.length-1)}function o(){return"string"===typeof __channelId__&&__channelId__}function i(t){for(var e=arguments.length,n=new Array(e>1?e-1:0),r=1;r<e;r++)n[r-1]=arguments[r];console[t].apply(console,n)}function u(){for(var t=arguments.length,e=new Array(t),n=0;n<t;n++)e[n]=arguments[n];var i=e.shift();if(o())return e.push(e.pop().replace("at ","uni-app:///")),console[i].apply(console,e);var u=e.map((function(t){var e=Object.prototype.toString.call(t).toLowerCase();if("[object object]"===e||"[object array]"===e)try{t="---BEGIN:JSON---"+JSON.stringify(t)+"---END:JSON---"}catch(o){t="[object object]"}else if(null===t)t="---NULL---";else if(void 0===t)t="---UNDEFINED---";else{var n=r(t).toUpperCase();t="NUMBER"===n||"BOOLEAN"===n?"---BEGIN:"+n+"---"+t+"---END:"+n+"---":String(t)}return t})),c="";if(u.length>1){var a=u.pop();c=u.join("---COMMA---"),0===a.indexOf(" at ")?c+=a:c+="---COMMA---"+a}else c=u[0];console[i](c)}n.r(e),n.d(e,"log",(function(){return i})),n.d(e,"default",(function(){return u}))},3307:function(t,e,n){"undefined"===typeof Promise||Promise.prototype.finally||(Promise.prototype.finally=function(t){var e=this.constructor;return this.then((function(n){return e.resolve(t()).then((function(){return n}))}),(function(n){return e.resolve(t()).then((function(){throw n}))}))}),uni.restoreGlobal&&uni.restoreGlobal(weex,plus,setTimeout,clearTimeout,setInterval,clearInterval),__definePage("pages/index/index",(function(){return Vue.extend(n("b4c5").default)}))},3362:function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=uni.requireNativePlugin("Fvv-UniAudioManager"),r={data:function(){return{}},onLoad:function(){},methods:{init:function(){n.init()},getVolume:function(){t("log",n.getCurrentVolume("music")," at pages/index/index.vue:27")},up:function(){n.adjustVolume({type:"music",direction:"raise",flag:5})},down:function(){n.adjustVolume({type:"music",direction:"lower",flag:5})},set:function(){n.setVolume({type:"music",volume:100,flag:5})}}};e.default=r}).call(this,n("0de9")["default"])},"4ba9":function(t,e,n){"use strict";n.r(e);var r=n("ac49");for(var o in r)"default"!==o&&function(t){n.d(e,t,(function(){return r[t]}))}(o);var i,u,c,a,f=n("f0c5"),s=Object(f["a"])(r["default"],i,u,!1,null,null,null,!1,c,a);e["default"]=s.exports},"59c6":function(t,e,n){"use strict";n("3307");var r=i(n("8bbf")),o=i(n("4ba9"));function i(t){return t&&t.__esModule?t:{default:t}}function u(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,r)}return n}function c(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?u(Object(n),!0).forEach((function(e){a(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):u(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}function a(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}r.default.config.productionTip=!1,o.default.mpType="app";var f=new r.default(c({},o.default));f.$mount()},6452:function(t,e,n){"use strict";var r,o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("view",{staticClass:t._$s(0,"sc","content"),attrs:{_i:0}},[n("p"),n("button",{attrs:{_i:2},on:{click:t.init}}),n("button",{attrs:{_i:3},on:{click:t.getVolume}}),n("button",{attrs:{_i:4},on:{click:t.up}}),n("button",{attrs:{_i:5},on:{click:t.down}}),n("button",{attrs:{_i:6},on:{click:t.set}})])},i=[];n.d(e,"b",(function(){return o})),n.d(e,"c",(function(){return i})),n.d(e,"a",(function(){return r}))},"7aee":function(t,e,n){"use strict";n.r(e);var r=n("3362"),o=n.n(r);for(var i in r)"default"!==i&&function(t){n.d(e,t,(function(){return r[t]}))}(i);e["default"]=o.a},"8bbf":function(t,e){t.exports=Vue},"8ea2":function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n={onLaunch:function(){t("log","App Launch"," at App.vue:4")},onShow:function(){t("log","App Show"," at App.vue:7")},onHide:function(){t("log","App Hide"," at App.vue:10")}};e.default=n}).call(this,n("0de9")["default"])},ac49:function(t,e,n){"use strict";n.r(e);var r=n("8ea2"),o=n.n(r);for(var i in r)"default"!==i&&function(t){n.d(e,t,(function(){return r[t]}))}(i);e["default"]=o.a},b4c5:function(t,e,n){"use strict";n.r(e);var r=n("6452"),o=n("7aee");for(var i in o)"default"!==i&&function(t){n.d(e,t,(function(){return o[t]}))}(i);var u,c=n("f0c5"),a=Object(c["a"])(o["default"],r["b"],r["c"],!1,null,null,null,!1,r["a"],u);e["default"]=a.exports},f0c5:function(t,e,n){"use strict";function r(t,e,n,r,o,i,u,c,a,f){var s,l="function"===typeof t?t.options:t;if(a){l.components||(l.components={});var p=Object.prototype.hasOwnProperty;for(var d in a)p.call(a,d)&&!p.call(l.components,d)&&(l.components[d]=a[d])}if(f&&((f.beforeCreate||(f.beforeCreate=[])).unshift((function(){this[f.__module]=this})),(l.mixins||(l.mixins=[])).push(f)),e&&(l.render=e,l.staticRenderFns=n,l._compiled=!0),r&&(l.functional=!0),i&&(l._scopeId="data-v-"+i),u?(s=function(t){t=t||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext,t||"undefined"===typeof __VUE_SSR_CONTEXT__||(t=__VUE_SSR_CONTEXT__),o&&o.call(this,t),t&&t._registeredComponents&&t._registeredComponents.add(u)},l._ssrRegister=s):o&&(s=c?function(){o.call(this,this.$root.$options.shadowRoot)}:o),s)if(l.functional){l._injectStyles=s;var v=l.render;l.render=function(t,e){return s.call(e),v(t,e)}}else{var b=l.beforeCreate;l.beforeCreate=b?[].concat(b,s):[s]}return{exports:t,options:l}}n.d(e,"a",(function(){return r}))}},[["59c6","app-config"]]]);