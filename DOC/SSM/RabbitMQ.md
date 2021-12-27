> 摘要：为了简单起见，在安装过程中已默认关闭了firewalld防火墙 和 SELinux。实际生产中，则不这样子做，而是开放相应的端口，以增强安全性。
>
> 关闭firewalld防火墙 和 SELinux关闭命令如下：

```bash
//-----------------------------------关闭Firewalld防火墙
//1、停止firewalld服务
systemctl stop firewalld

//2、禁止firewalld开机启动
systemctl disable firewalld

 

//-----------------------------------关闭SELinux
//1、临时关闭
setenforce 0

//2、永久关闭SELinux
sed -i "s/^SELINUX=enforcing/SELINUX=disabled/g" /etc/selinux/config
```

# 二、下载

> RabbitMQ所需要的安装包，即Erlang 和 RabbitMQ

1、RabbitMQ是Erlang语言编写的，所以在安装RabbitMQ之前，需要先安装Erlang。但是在搭建RabbitMQ环境过程中，会因为RabbitMQ 和 Erlang的版本问题导致环境一直搭建不起来， 以下是RabbitMQ与Erlang的版本对应关系，所以这里我下载的RabbitMQ的版本为 3.7.16，Erlang的版本为22.0

也可以去官网查看RabbitMQ 和 Erlang的版本问题，网址：https://www.rabbitmq.com/which-erlang.html#erlang-repositories

RabbitMQ版本	Erlang最低版本要求	Erlang最高版本要求

| RabbitMQ版本    | Erlang最低版本要求 | Erlang最高版本要求 |
| --------------- | ------------------ | ------------------ |
| 3.7.15 - 3.7.16 | 20.3.x             | 22.0.x             |
| 3.7.7 - 3.7.14  | 20.3.x             | 21.3.x             |
| 3.7.0 - 3.7.6   | 19.3               | 20.3.x             |

如果觉得下载比较繁琐，我已经提供了所需模块的安装包：

链接：https://pan.baidu.com/s/1NLYtuSkaQQHLH8lcMILYuw 
提取码：1111

Erlang安装包：otp_src_22.0.tar.gz

RabbitMQ安装包：rabbitmq-server-generic-unix-3.7.16.tar.xz





# 三、传到Linux

> 把下载好的RabbitMQ 和 Erlang上传到Linux服务器上

1、打开WinSCP，把我们下载好的RabbitMQ 和 Erlang安装包，上传到Linux的 /mnt/ 文件目录下

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/2019071311323353.png)

2、使用putty连接到我们的Linux服务器，进入到/mnt/ 文件目录中，并解压上传的RabbitMQ 和 Erlang安装包

```bash
[root@localhost ~]# cd /mnt/     //进入到mnt目录下

[root@localhost mnt]# ls    //查看mnt目录
otp_src_22.0.tar.gz  rabbitmq-server-generic-unix-3.7.16.tar.xz

[root@localhost mnt]# tar -zxvf otp_src_22.0.tar.gz &>/dev/null   //解压Erlang

[root@localhost mnt]# xz -d rabbitmq-server-generic-unix-3.7.16.tar.xz   //解压RabbitMQ
[root@localhost mnt]# tar -xvf rabbitmq-server-generic-unix-3.7.16.tar &>/dev/null

[root@localhost mnt]# ls    //再次查看mnt目录
otp_src_22.0  otp_src_22.0.tar.gz  rabbitmq_server-3.7.16  rabbitmq-server-generic-unix-3.7.16.tar
```

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713114942951.png" alt="img"  />

3、在/usr/local/software 目录下创建一个rabbitmq_software文件夹，便于我们管理安装的RabbitMQ软件，并把我们解压好的文件移动到rabbitmq_software目录下

```bash
[root@localhost mnt]# mkdir -p /usr/local/software/rabbitmq_software   //创建一个rabbitmq_software文件夹


//把我们解压好的文件移动到rabbitmq_software目录下
[root@localhost mnt]# mv otp_src_22.0 /usr/local/software/rabbitmq_software/

[root@localhost mnt]# mv rabbitmq_server-3.7.16 /usr/local/software/rabbitmq_software/

[root@localhost mnt]# cd /usr/local/software/rabbitmq_software/

[root@localhost rabbitmq_software]# ls
otp_src_22.0  rabbitmq_server-3.7.16
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713115902388.png)

# 四、安装Erlang

1、安装Erlang编译所依赖的环境

```bash
yum install make gcc gcc-c++ build-essential openssl openssl-devel unixODBC unixODBC-devel kernel-devel m4 ncurses-devel
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713144938554.png)

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713145115802.png)

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713145440999.png)

2、在 /usr/local 目录下创建一个erlang文件夹，因为erlang编译安装默认是装在/usr/local下的bin和lib中，这里我们将他统一装到/usr/local/erlang中，方便查找和使用

```bash
[root@localhost rabbitmq_software]# mkdir -p /usr/local/erlang
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713150045224.png)

3、编译Erlang

```bash
[root@localhost rabbitmq_software]# cd otp_src_22.0/       //进入到Erlang目录下
//编译Erlang，这里由于不需要用java编译器编译,所以后面添加了 --without-javac

[root@localhost otp_src_22.0]# ./configure  --prefix=/usr/local/erlang --without-javac
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713151307999.png)

正常编译完成之后，显示如下图所示

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713151457524.png)

5、安装Erlang

```bash
[root@localhost otp_src_22.0]# make && make install
```


![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713152946399.png)安装完成

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713153040295.png)

6、配置Erlang环境变量

```bash
[root@localhost otp_src_22.0]# vim /etc/profile    //编辑环境配置文件
//添加如下配置信息
export ERLANG_HOME=/usr/local/erlang

export PATH=${ERLANG_HOME}/bin:${PATH}

[root@localhost otp_src_22.0]# source /etc/profile  //重新读取配置文件
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713154827802.png)

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713155530255.png)


7、创建软连

```bash
[root@localhost otp_src_22.0]# ln -s /usr/local/erlang/bin/erl /usr/local/bin/erl
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713160005474.png)

8、测试Erlang是否安装成功

```bash
[root@localhost otp_src_22.0]# erl

Erlang/OTP 22 [erts-10.4] [source] [64-bit] [smp:1:1] [ds:1:1:10] [async-threads:1] [hipe]

Eshell V10.4  (abort with ^G)
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713161146229.png)

# 五、安装RabbitMQ

1、配置RabbitMQ环境变量

```bash
[root@localhost otp_src_22.0]# vim /etc/profile     //编辑环境配置文件

//添加如下配置信息
export RABBITMQ_HOME=/usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16

export PATH=${RABBITMQ_HOME}/sbin:${PATH}

[root@localhost otp_src_22.0]# source /etc/profile  //重新读取配置文件
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713163131797.png)

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/201907131636352.png)

2、开启Web管理界面插件，便于访问RabbitMQ

```bash
[root@localhost otp_src_22.0]# cd /usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16/sbin

[root@localhost sbin]# ./rabbitmq-plugins enable rabbitmq_management   //开启web管理界面插件 
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713165707731.png)

3、设置RabbitMQ开机启动

```bash
[root@localhost sbin]# vim /etc/rc.d/rc.local
```

添加如下代码到 /etc/rc.d/rc.local 中：

   **注意：1、手动启动 是因为你是用户登陆，用户登陆就会去加载/etc/profile文件中配置的Erlang 和 RabbitMQ环境，这个时候你就能启动RabbitMQ
              2、开机启动  它会先读取启动文件配置，你必须在系统识别用户前加载/etc/profile文件中配置的Erlang 和 RabbitMQ环境，RabbitMQ才能在开机时启动** 

```bash
source /etc/profile

/usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16/sbin/rabbitmq-server -detached
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713173302295.png)

4、后台启动RabbitMQ服务

```bash
[root@localhost sbin]#  ./rabbitmq-server -detached     //后台启动RabbitMQ

//这个警告是正常的警告，并非是异常信息
Warning: PID file not written; -detached was passed.
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713174225778.png)

5、在浏览器的地址栏中输入你 服务器的ip地址:15672，即可访问RabbitMQ的管理登录界面，例如我的Linux服务器的ip地址是192.168.30.1，那么我的RabbitMQ管理界面的访问地址是 192.168.30.1:15672

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713175127755.png)

6、RabbitMQ的Username 和 Password 默认为guest/guest

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713175606184.png)

7、可以看到Login failed (登录失败)，User can only log in via localhost (用户只能通过本地主机登录)，因为rabbitmq从3.3.0开始禁止使用guest/guest管理员权限通过除localhost外的访问

解决方案：如果想使用guest/guest通过远程机器访问，需要在/usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16/ebin目录下找到rabbit.app文件，并把文件中的 {loopback_users, [<<"guest">>]}, 删除其中的<<"guest">>，修改后为{loopback_users, []},    

**注意：{loopback_users, []}, 后面的逗号不能删除**

```bash
[root@localhost sbin]# cd /usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16/ebin/

[root@localhost ebin]# vim rabbit.app
```

可以看到{default_user, <<"guest">>} 和 {default_pass, <<"guest">>}，即RabbitMQ默认的Username 和 Password

删除{loopback_users, [<<"guest">>]}, 中的<<"guest">>，**注意保留后面的逗号,**

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713181851261.png)

删除后

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713182308869.png)

8、重启RabbitMQ服务

```bash
[root@localhost ebin]# cd /usr/local/software/rabbitmq_software/rabbitmq_server-3.7.16/sbin/

//关闭RabbitMQ服务
[root@localhost sbin]# rabbitmqctl stop
Stopping and halting node rabbit@localhost ...

//启动RabbitMQ服务
[root@localhost sbin]# ./rabbitmq-server -detached
Warning: PID file not written; -detached was passed.
```

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/201907131839477.png)

9、重新访问RabbitMQ的管理登录界面，Username 和 Password 默认为guest/guest，登录成功，到这里RabbitMQ基本上就安装好了

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190713184222581.png)

# 六、管理界面创建用户和虚拟主机

1、点击Admin，进入到用户管理界面

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714000820811.png)

2、点击Add a user创建一名用户，填写用户名、用户密码、用户确认密码以及添加用户角色

用户角色分为以下几个：

（1）超级管理员(administrator)：可登陆管理控制台(启用management plugin的情况下)，可查看所有的信息，并且可以对用户，策略(policy)进行操作。

（2）监控者(monitoring)：可登陆管理控制台(启用management plugin的情况下)，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等)。

（3）策略制定者(policymaker)：可登陆管理控制台(启用management plugin的情况下), 同时可以对policy进行管理。但无法查看节点的相关信息 (即Admin用户管理界面右边导航栏 中的Policies节点信息)。

（4）普通管理者(management)：仅可登陆管理控制台(启用management plugin的情况下)，无法看到节点信息，也无法对策略进行管理。

（5）其他：无法登陆管理控制台，通常就是普通的生产者和消费者。

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714011503327.png)

3、可以看到创建好的admin用户一栏中的Can access virtual hosts中显示 No access，即admin用户没有可以访问的虚拟主机

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714004926830.png)

4、创建虚拟主机，点击Virtual Hosts，输入虚拟主机名称，格式一般以 斜杠/ + 名称，最后点击Add virtual host

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714005802245.png)

5、可以看到添加好的 /rabbitmq虚拟主机

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714010050505.png)

6、点击Users，找到Name下的admin并点击，为其添加可访问的虚拟机

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714011745281.png)

7、找到Permissions，选择我们之前创建好的 /rabbitmq虚拟主机，最后点击Set permission

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/2019071401234253.png)

8、可以看到当前用户admin 可以访问的虚拟主机

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714012916668.png)

9、点击Admin，进入到用户管理界面，可以看到当前用户admin 添加/rabbitmq虚拟主机成功

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/2019071401345264.png)

10、退出guest用户登录，测试使用admin用户登录

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714013859898.png)![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/2019071401395790.png)![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190714014304721.png)

