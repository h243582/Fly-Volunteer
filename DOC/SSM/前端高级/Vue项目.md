# 安装不了的时候

```java
npm install --registry=https://registry.npm.taobao.org     //用阿里镜像可以下载成功
```

# 一、安装cnpm和cli

## 安装`Node.js`

然后就可以在命令行查看到版本了

D:\Program Files\Node.js>`node -v`
v14.18.1

D:\Program Files\Node.js>`npm -v`
6.14.15

## 设置npm安装路径和缓存路径

```
npm config set prefix "D:\Program Files\Node.js\node_modules"

npm config set cache "D:\Program Files\Node.js\node_cache"
```

## 设置环境变量

==一定要设置，不然有些东西 安装了，但是显示找不到==

新建一个文件夹D:\Program Files\Node.js\node_global

```
//添加系统变量
NODE_PATH     D:\Program Files\Node.js\node_modules

////添加系统变量Path
D:\Program Files\Node.js\node_global
%NODE_PATH%
```



## 安装express

==-g是安装的意思，如果没有-g就会安装到在当前路径下==

```
npm install express -g
```

## 安装cnpm 

```
npm install cnpm -g
```

## 安装vue-cli

```
//查看 Vue Cli 所有版本号
cnpm view @vue/cli versions --json    3.x 和 4.x 的所有版本号
cnpm view vue-cli versions --json   1.x 和 2.x 的所有版本号


cnpm install vue-cli -g

//安装指定版本cli
cnpm install -g @vue/cli@3    安装3版本最高版
cnpm install -g @vue/cli@版本号  安装 3.x 和 4.x 版本
cnpm install -g vue-cli@版本号  安装 1.x 和 2.x 版本，比如2.9.6




//卸载Vue Cli
npm uninstall -g @vue/cli   卸载 3.x 或 4.x 版本的Vue Cli
npm uninstall vue-cli -g   卸载 1.x 或 2.x 版本的Vue Cli
```





## 查看创建项目的方式

```
vue list
```







# 二、安装http-server,SwaggerEditor，SwaggerUI 



## http-server

全局安装http-server(http-server是一个简单的零配置命令行http服务器)

```
npm install -g http-server
```



## SwaggerEditor

SwaggerEditor是个文档编辑器，把yml文件变成html，



下一步文档编写好之后，把dist的所有文件复制到nginx的html文件夹中

![image-20211030202858409](https://i.loli.net/2021/10/30/iNp2SvY4DCLOh19.png)

![image-20211030202815713](https://i.loli.net/2021/10/30/pyZzaEC1vkKmItW.png)



（1）下载 https://github.com/swagger-api/swagger-editor/releases/download/v2.10.4/swagger-editor.zip。我在资源中已经提供。

（2）解压swagger-editor,

（4）进入swagger-editor文件夹，启动swagger-editor

```
http-server
```

（5）浏览器打开： http://localhost:8080

## SwaggerUI 

SwaggerUI是用来展示Swagger文档的界面，以下为安装步骤

（1）在本地安装nginx  

（2）下载SwaggerUI源码   https://swagger.io/download-swagger-ui/

（3）解压，将dist文件夹下的全部文件拷贝至 nginx的html目录

（4）双击启动nginx

（5）浏览器打开页面  http://localhost即可看到文档页面  

![](../../%E9%A1%B9%E7%9B%AE/1024%E7%A4%BE%E5%8C%BA/%E5%89%8D%E7%AB%AFmd%E6%96%87%E4%BB%B6/image/2-11-16355971806911.png)



（6）我们将编写好的yml文件也拷贝至nginx的html目录，这样我们就可以加载我们的swagger文档了

==网页是动态的，不用重启！==

### Windows关闭进程

任意位置输入

```
taskkill /f /t /im nginx.exe
```

### 重启进程

nginx目录输入

```
nginx -r reload
```





# 二、安装webpack和webpack-cli

## 安装webpack 

+ ```
  cnpm install webpack -g
  ```

## 安装webpack-cli

```
cnpm install webpack-cli -g
```

## 查看版本

```
webpack -v
```

//首先清除我们已经安装过的版本：
　npm uninstall node-sass -g
　npm uninstall sass-loader
　npm uninstall style-loader
　//注意我们清除的时候可以选择全局的清除 全局的安装，否则下次创建 项目还会有同样的错误 执行重复的操作
　npm i node-sass --sass_binary_site=https://npm.taobao.org/mirrors/node-sass/ -g  //淘宝镜像安装
　npm install sass-loader@7.3.1 --save-dev  -g　　　 //安装7.3.1版本的sass
　npm install style-loader --save-dev -g
　// 安装style-loader

# 三、命令行创建项目

## 创建好项目文件夹

### 进入目录

```
F:
cd F:\WebStorm_se\Vue\
```

### 在这个目录创建项目

```cmd
vue init webpack my-first-vue
```

![image-20210808153154499](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210808153154.png)

## ==进入项目下载依赖==

```
cd my-first-vue
npm install

npm install --registry=https://registry.npm.taobao.org     //用阿里镜像可以下载成功

```

## 打包并且运行服务器

```
npm run dev
```

## 安装vue-router路由

```
cnpm install vue-router --save-dev
```

## 安装SASS加载器

==用来解析sass文件，不用安装==

```
npm install sass-loader@7.3.1 node-sass@4.14.1 --save-dev
```









# 三、ui方式安装

### 安装vue ui

```
cnpm i -g @vue/cli
```

### 启动vue ui

```
vue ui
```

### 跟着步骤装好项目



### 添加element-ui插件

![image-20210803134634283](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803134634.png)

`vue-cli-plugin-element`

![image-20210803134320002](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803134320.png)

![image-20210803134458145](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803134458.png)

### 添加axios

![image-20210803134657338](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803134657.png)

![image-20210803134716813](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803134716.png)

# 安装touch

```
npm install touch-cli -g
```















## 使用webpack打包

#### main.js文件

```js
var hello = require("./hello");

hello.sayHi();
```

#### hello.js文件

```js
//暴露一个方法
exports.sayHi = function () {
    document.write("<h1>何昱飞</h1>")

};
```

#### webpack.config.js配置文件，文件名貌似不能改。 必须放在根目录下

```js
module.exports = {
    entry:"./modules/main.js",
    output:{
        filename:"./js/bundle.js"
    }
}
```

#### 在终端打包

输入webpack， idea必须以管理员身份运行，不然可能出错

![p2SuyKPHkIXA4gt](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803132242.png)



也可以**热部署**， 输入`webpack --watch`, 随时自动打包，直接覆盖原文件，Ctrl + c停止

#### 这时候会生成打包好的js文件

![yVSrna6qBJ21lG8](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803131754.png)

#### 最后直接调用

![7WOxiaIyuYsJfdN](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210803131709.png)







