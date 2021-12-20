# 一、目录结构



### assets资源目录

资源目录 `assets` 用于组织未编译的静态资源如 `LESS`、`SASS` 或 `JavaScript`。

### components组件目录

组件目录 `components` 用于组织应用的 Vue.js 组件。Nuxt.js 不会扩展增强该目录下 Vue.js 组件，即这些组件不会像页面组件那样有 `asyncData` 方法的特性。

### layouts布局目录

布局目录 `layouts` 用于组织应用的布局组件。

*若无额外配置，该目录不能被重命名。*

[关于布局的更多信息](https://www.nuxtjs.cn/guide/views#布局)

### middleware中间件目录

`middleware` 目录用于存放应用的中间件。

[关于中间件的更多信息](https://www.nuxtjs.cn/guide/routing#中间件)

### pages页面目录

页面目录 `pages` 用于组织应用的路由及视图。Nuxt.js 框架读取该目录下所有的 `.vue` 文件并自动生成对应的路由配置。

*若无额外配置，该目录不能被重命名。*

[关于页面的更多信息](https://www.nuxtjs.cn/guide/views)

### plugins插件目录

插件目录 `plugins` 用于组织那些需要在 `根vue.js应用` 实例化之前需要运行的 Javascript 插件。

[关于插件的更多信息](https://www.nuxtjs.cn/guide/plugins)

### static静态文件目录

静态文件目录 `static` 用于存放应用的静态文件，此类文件不会被 Nuxt.js 调用 Webpack 进行构建编译处理。服务器启动的时候，该目录下的文件会映射至应用的根路径 `/` 下。

**举个例子:** `/static/robots.txt` 映射至 `/robots.txt`

*若无额外配置，该目录不能被重命名。*

[关于静态文件的更多信息](https://www.nuxtjs.cn/guide/assets#静态文件)

### Store 目录

`store` 目录用于组织应用的 [Vuex 状态树](http://vuex.vuejs.org) 文件。 Nuxt.js 框架集成了 [Vuex 状态树](http://vuex.vuejs.org) 的相关功能配置，在 `store` 目录下创建一个 `index.js` 文件可激活这些配置。

*若无额外配置，该目录不能被重命名。*

[关于 store 的更多信息](https://www.nuxtjs.cn/guide/vuex-store)

### nuxt.config.js 文件

`nuxt.config.js` 文件用于组织 Nuxt.js 应用的个性化配置，以便覆盖默认配置。

*若无额外配置，该文件不能被重命名。*

[关于 nuxt.config.js 的更多信息](https://www.nuxtjs.cn/guide/configuration)

### package.json 文件

`package.json` 文件用于描述应用的依赖关系和对外暴露的脚本接口。

*该文件不能被重命名。*





## 别名

| 别名         | 目录                                                       |
| ------------ | ---------------------------------------------------------- |
| `~` 或 `@`   | [srcDir](https://www.nuxtjs.cn/api/configuration-srcdir)   |
| `~~` 或 `@@` | [rootDir](https://www.nuxtjs.cn/api/configuration-rootdir) |

默认情况下，`srcDir` 和 `rootDir` 相同。

**提示:** 在您的 `vue` 模板中, 如果你需要引入 `assets` 或者 `static` 目录, 使用 `~/assets/your_image.png` 



# 二、路由

> Nuxt.js 依据 `pages` 目录结构自动生成 [vue-router](https://github.com/vuejs/vue-router) 模块的路由配置。

要在页面之间使用路由，我们建议使用[``](https://www.nuxtjs.cn/api/components-nuxt-link) 标签。

例如:

```html
<template>
  <nuxt-link to="/">首页</nuxt-link>
</template>
```



