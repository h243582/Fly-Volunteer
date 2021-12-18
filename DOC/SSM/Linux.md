## 查看cpu

>top

## 查看磁盘内存

>df -h
### 搜索文件夹

```
find -name "uninstallAll.sh"   
find -name "*.sh"   
```



## 切换用户
> su root
> Password: ******

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
