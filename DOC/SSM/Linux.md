# 一、权限

## 1、文件权限命令

![在这里插入图片描述](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/ee7ea01eebfc4b2a9dc161f768251dcb.png)

1. ps -mp pid -o THREAD,tid,time
2. printf “%x\n” tid 把十进制的tid转16进制的id
3. jstack pid |grep tid -A 1000

## 2、切换用户

> su root
> Password:  不显示

## 查看cpu

>top

## 查看磁盘内存

>df -h
### 搜索文件夹

```
find -name "uninstallAll.sh"   
find -name "*.sh"   
```

#### 查找文件

find ./* -name mysql.server

> 

## 安装包解压

首先 移动 到 压缩包 所在的 文件夹

tar -zxvf 压缩包名

> tar -zxvf **redis-6.2.4.tar.gz**



## 文件夹操作



### 1、路径

绝对路径:  /

相对路径：

1. 	跑到上级目录的另一个文件   cd ../man
2. 	当前目录 ./

### 2、其他

- ls（英文全拼：list files）: 列出目录及文件名

- cd（英文全拼：change directory）：切换目录

- pwd（英文全拼：print work directory）：显示目前的路径（-p 显示最完整路径）

- mkdir（英文全拼：make directory）：创建一个新的目录

- rmdir（英文全拼：remove directory）：删除一个空的目录

- cp（英文全拼：copy file）: 复制文件或目录

  ```
  //复制这个文件到上一级目录的tom文件夹内
  [root@LBJF hyfConfig]# cp redis.conf ../tom
  ```

- rm（英文全拼：remove）: 删除文件或目录

- mv（英文全拼：move file）: 移动文件与目录，或修改文件与目录的名称



### 3、文件操作

#### 1、保存

:w 保存；

:w filename 另存为filename； 

:wq! 保存并强制退出；

:wq! filename 注：以filename为文件名保存后强制退出；

:q! 强制退出；

:x 保存并退出（仅当文件有变化时保存）
#### 2、删除删不掉的文件时



查看文件属性

```java
lsattr xxx  查看文件属性(xxx为文件名)
```

看到的情况

```java
-----a-------或者-----i-------
```

去除属性

```java
chattr -a xxx 或者 chattr -i xxx
```

删除文件

```java
rm -rf xxx
```







# mysql

## 一、启动

1、使用 service 启动：service mysqld start

2、使用 mysqld 脚本启动：/etc/inint.d/mysqld start

3、使用 safe_mysqld 启动：safe_mysqld&

## 二、停止

1、使用 service 启动：service mysqld stop

2、使用 mysqld 脚本启动：/etc/inint.d/mysqld stop

3、 mysqladmin shutdown 

## 三、重启

1、 使用 service 启动：service mysqld restart

2、使用 mysqld 脚本启动：/etc/inint.d/mysqld restart

## 四、连接数设置

找到`my.cnf`文件 一般在/etc下

```properties
# max_connections设置最大连接数为1000
max_connections=1000

# max_user_connections设置每用户最大连接数为500
max_user_connections=500

# wait_timeout表示3600秒后将关闭空闲（IDLE）的连接，但是对正在工作的连接不影响。
# 写太大启动报错的！
# wait_timeout=3600
```

然后重启mysql
