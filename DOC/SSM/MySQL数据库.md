# 一、数据库引擎

1、`Archive`引擎

​		存储限制`none`，啥权限也没有

2、`InnoDB`引擎

​		存储限制`64TB`，==**支持事物**==，==**支持数索引**==，==**支持数据缓存**==，==**支持外键**==

3、`Memory`引擎

​		存储限制`RAM`，支持数索引，支持数据缓存，==**支持外键**==

4、`MyISAM`引擎

​		存储限制`256TB`，支持全文索引，支持数索引

# 二、`sql`调优

1. 使用group by 分组查询是，默认分组后，还会排序，可能会降低速度，

   **在`group by` 后面增加 `order by null` 就可以防止排序.**

2. 最好不要给数据库留 NULL，尽可能的使用 NOT NULL 填充数据库.

   备注、描述、评论之类的可以设置为 NULL，其他的，最好不要使用 NULL。

3. **首先应考虑在 where 及 order by 涉及的列上建立索引**

4. 减少 IO 次数

5. **少排序、分组、查重**：降低 CPU 计算（order by, group by,distinct，排序）

6. 尽量用连接（join）代替子查询（不需要在内存创建临时表），尽量少 join

7. 不要 select *，要写具体

8. 尽量少 or,使用 union all 或者是union(必要的时候)的方式来代替“or”会得到更好

9. 避免类型转换

10. 优先优化高并发的 `SQL`

11. 从全局出发优化，充分考虑系统中所有的 `SQL`







# 三、事务四大特性

### 1、原子性A

是指一个事务的所有操作，要么全部成功，要么全部失败

### 2、一致性C

执行前和执行后必须一致。不能一个加了钱，一个没加钱

### 3、隔离性I

每个用户访问数据库不会互相干扰

### 4、持久性D

事务提交后永久性保存



# 四、事务隔离级别

## 1、为什么有隔离级别

### （1）脏读

一个事务读取了另一个还未提价的事务中的内容

### （2）不可重复读update/delete

查询间隔，查询内容被另一个事务修改并提交了。导致多次查询返回了不同的值

### （3）幻读（虚读）insert

期间事务B 插入了相同搜索条件的新数据，事务A再次按照原先条件进行读取时，发现了事务B ==新插入的数据== 

## 2、事务的隔离级别

![image-20210721193311759](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210721193311.png)

### （1）读未提交**Read uncommitted**

一个事务写数据的时候，其他事务全部不允许写数据，但是允许读。

这种级别可以通过"**排它写锁**"和 不排斥读线程实现。

#### 避免了**更新丢失**，却可能出现**脏读**

### （2）读已提交**Read committed**

**读事务**的时候，允许其他事务读写；

**写事务**的时候，禁止其他事务**访问**该行数据

#### 避免了**脏读**和**更新丢失**，但是可能出现**不可重复读**

### （3）可重复读取**Repeatable read**

==**`MySQL`默认的隔离级别是*可重复读*。**==

**（保证多次查询结果相同）**

事务A读取这个数据（不可写），在在这个事务还没结束时，其他事务不能访问该数据(包括了读写)

(读取数据的事务)可以通过“共享读镜”和“排他写锁”实现。

#### 解决了**更新丢失**、**脏读**、**不可重复读**、但是还会出现**幻读**

### （4）可序化**Serializable**

事务只能一个接着一个地执行（**不可并发**）

仅仅通过“行级锁”是无法实现序列化的，必须通过其他机制保证新插入的数据不会被执行查询操作的事务访问到。

它以锁表的方式(类似于Java多线程中的锁)使得其他线程只能在锁外等待

**序列化是最高的事务隔离级别**，**性能很低**，一般**很少使用**

#### 不仅可以避免**脏读**、**不可重复读**，还避免了幻读



# 五、缓存

## 1、缓存处理流程

取数据的时候先在缓存中找，没有的话再到数据库中查询，返回结果

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210818094833.png)

## 2、缓存穿透

缓存和数据库都没有数据，但是用户一直请求。这时候用户很可能是攻击者

### 解决方案

1. 接口层增加效验，用于鉴定，id<0直接拦截
2. 如果缓存和数据库中都无数据，这时候可以把key-value写为key-null，缓存有效时间设置短一点：30秒，太长的话用户也用不好。可以防止攻击用户反复用同一个id暴力攻击

## 3、缓存击穿

缓存中没有数据，刚刚过期了，数据库中有，这时：并发用户特别多，同时读取缓存没读到数据又跑到数据库取数据，导致数据库压力瞬间扩大。

### 解决方法

设置热点数据永不过期

加互斥锁

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/202108181641570.png)
#### 说明

1. 缓存中有数据，直接走上述代码13行后就返回结果了
2. 缓存中没有数据，第1个进入的线程，获取锁并从数据库去取数据，==没释放锁之前，其他并行进入的线程会等待100ms，再重新去缓存取数据（自旋）==。==防止都去数据库重复取数据==，重复往缓存中更新数据情况出现。
3. 当然这是简化处理，理论上如果能根据key值加锁就更好了，就是线程A从数据库取key1的数据并不妨碍线程B取key2的数据，上面代码明显做不到这点。

## 4、缓存雪崩

缓存中大量数据都过期了，这时候查询量巨大甚至死机

缓存击穿指的是并发查询一条，但是缓存雪崩是很多条数据都过期 导致很多条都要查数据库

### 解决方案

1. 缓存数据过期时间设置随机，防止同一时间大量数据过期
2. 如果缓存数据库是分布式部署，那就将热点数据均匀分布在个个缓存数据库中
3. 设置那些热点数据永不过期

# 六、索引

## 2、MySql中索引类型

### 聚簇索引

- 聚簇索引就是==主键索引==
- 聚簇索引的**叶子节点**存储的是**整行数据**

### 非聚簇索引(辅助索引)

- 非聚簇索引就是==普通索引==
- 非聚簇索引的**叶子节点**存储的是**索引值**和**主键值**
- 一张表可以有多个辅助索引。在innodb中有时也称辅助索引为**二级索引**

![image-20220304142706336](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220304142706336.png)

## 1、`innoDB`的索引类型

### （1）**主键索引**

- ==**一个表只能一个主键，一个主键索引**==

- 默认的都有，`primary`设置后，自动创建主键索引
- `InnoDB`通过主键来实现聚簇索引，如果没有主键的话，它会选择一个唯一非空的索引来实现，如果再没有的话，它会隐式生成一个主键实现聚簇索引
- `alert table user add **primary key**(id)`

### （2）**普通索引**

- 也叫 **单列索引，单值索引**
- 随便一个字段都可以建立索引，可以重复
- `alert table user add **index**  idx_name(name)`

### （3）**唯一索引**

- 一个表中可以有多个唯一索引。
- 值必须唯一，可以为空，但是只能有一个空
- alert table user add **unique** idx_id_card(id_card)

### （4）**复合索引**

- 多个列**组合索引**，
- ==最左原则==添加了age,name时，可以用age或者age和name，但是不能单独用name
- alert table user add **index**  idx_age_name(age,name)

## 2、Full Text全文索引

因为全文索引==会对文本进行====分词==，所以只能用于`char`，`varchar`，`text`

允许在==索引列==中插入==重复值==和==空值==

`MyIsam`(权限最低的那个)存储引擎支持全文索引

## 3、什么情况无法用索引

### 1.查询语句中使用LIKE关键字

- 如果第一个字符为`%`，索引不会被使用。
- 只要`%`不在第一个位置，索引就会被使用。

### 2.查询语句中使用多列索引

如果查询使用了组合索引，那必须要使用了左侧第一个字段，才会调用索引

### 3.查询语句中使用or关键字

如果`or`的时候其中有字段不是索引，就不能使用索引

`username = '123' or password='121'`

## 4、什么时候要用索引

- 在需要排序的列上创建索引
- 在经常使用在where子句中的列上面创建 索引
- 在经常需要搜索的列上加索引，可以很快搜索到
- 在外键上面建立索引

## 5、什么时候不用索引

- 使用不了索引的时候（模糊查询%在左边，组合查询的时候不遵循最左原则，or的时候有一侧不是索引）
- 查询少的列不用索引
- 数据值范围很少的列也不用索引，比如说性别
- imge、url这种的别加索引
- 如果哪一项需要经常修改的话，也最好不要加，不然索引的自动维护过程会很慢



# 七、MySQL基础

## 1、创建数据库

```sql
create database  ry  default character set utf8 COLLATE utf8_general_ci;
```

## 2、创建表

```sql
create table sys_dept (
  dept_id           bigint(20)      not null auto_increment    comment '部门id',
  parent_id         bigint(20)      default 0                  comment '父部门id',
  ancestors         varchar(50)     default ''                 comment '祖级列表',
  dept_name         varchar(30)     default ''                 comment '部门名称',
  order_num         int(4)          default 0                  comment '显示顺序',
  leader            varchar(20)     default null               comment '负责人',
  phone             varchar(11)     default null               comment '联系电话',
  email             varchar(50)     default null               comment '邮箱',
  status            char(1)         default '0'                comment '部门状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (dept_id)
) engine=innodb auto_increment=200 comment = '部门表';
```

## 3、增加

```sql
insert into stu(id,name) values('1','sss')
```

## 4、修改

```sql
update stu set nicname='jjj' where id='1'
```

## 5、删除

```sql
delete from stu where id =1
```

# 八、**Win下安装**

## **1、安装包下载。**

下载地址：https://dev.mysql.com/downloads/mysql/

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909145941512-769947425.png)

 

点击下载之后，可以选择注册Oracle账号，也可以跳过直接下载。

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909150321246-422217249.png)

下载完成后，选择一个磁盘内放置并解压。

 

2020年2月14日，mysql官网进不去了，好吧~那就来个镜像，总没问题了吧。如果官网龟速下载，建议使用下面镜像巨快。相对的~

**Mysql国内镜像：http://mirrors.sohu.com/mysql/MySQL-8.0/**

**![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20200214012521294-416245235.png)**

 

 

 下载完成之后，解压即可！

## **2 安装教程**

### **（1）配置环境变量**

变量名：MYSQL_HOME

变量值：E:\mysql-5.7.20-winx64

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909150744140-2120125213.png)

 

### **（2）生成data文件**

**以管理员身份运行cmd**

进入E:\python\mysql\mysql-8.0.12-winx64\bin>下(这里在说一下：这里的路径需要根据自己的实际安装位置进行调整，总之就是刚刚解压的文件放在那，就在哪打开~)

执行命令：mysqld --initialize-insecure --user=mysql  在E:\python\mysql\mysql-8.0.12-winx64目录下生成data目录

 

### **(3) 安装MySQL**

继续执行命令：mysqld -install

 ![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909151316958-1570665300.png)

 

### **（4）启动服务**

继续执行命令：net start MySQL

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909151501496-475633604.png)

 

### **（5）登录MySQL**

登录mysql:(因为之前没设置密码，所以密码为空，不用输入密码，直接回车即可）

E:\python\mysql\mysql-8.0.12-winx64\bin>mysql -u root -p

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909151708478-864137964.png)

 

### **（6）查询用户密码**

查询用户密码命令：mysql> select host,user,authentication_string from mysql.user;

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1435523-20180909152055740-1024771042.png)

 

### **（7）设置（或修改）root用户密码**

```cpp
alter user user() identified by "XXXXXX";
```



# 九、批量

## 1、批量插入

```sql
insert into t_place  (select * from t_place_ex_h2)
```



## 2、批量修改

```sql
update t_place set city = concat(city,county) where county !='213213';
```



# 十、方法

## 1、concat字符串合并

```sql
concat(city,county)
select concat(city,county,town) from t_place


```

## 2、split_part字符串分割

`split_part([原字符串],  [分割字符], [取第几坨])`

`注意：分割之后的字符串是不包括分割字符的`

```sql
select split_part(tp.name,'镇',3) from t_place
```

## 3、substring字符串截取

`substring([原字符串], [从第n个开始], [数m-1个数])`         n从0开始

比如

```
--place_code=123456
substring(place_code, 0, 3)    --数两位： 12
```

## 4、cast when then end





```
select  (case
             when he.ttt like '%镇%'  //if
             	then (concat(split_part(he.ttt,'镇',1),'镇')) //为真
             when tp.name like '%镇%'  //else if
                then (split_part(tp.name,'镇',2))//为真
             else (concat(split_part(he.ttt,'乡',1),'乡')) //为假
             end)   as name
from he
```
## 4、case when判断

```sql
select (case when stu.score > 90
				then '优秀'
			when stu.score > 80
				then '良好'
			else '不合格'
            end) as '等级'
from stu;            
```

# 十一、mysql常见日志

## 1、重做日志（redo log）

事务的持久性性是通过 redo log 来实现的 物理日志

**在重启mysql服务的时候，根据redo log进行重新读取，从而达到事务的持久性这一特性。**

## 2、回滚日志（undo log）

事务的原子性是通过 undo log 来实现的 逻辑日志 根据sql生成逆向回滚sql

**保存了事务发生之前的数据的一个版本，可以用于回滚**

## 3、二进制日志（binlog）

用于复制（主从复制）

## 4、其他日志

错误日志（errorlog）

慢查询日志（slow query log）

一般查询日志（general log）

中继日志（relay log）

## 5、三种日志总结

首先 InnoDB 完成一次更新操作的具体步骤：

1. 开启事务
2. 查询待更新的记录到内存，并加 X写 锁
3. 记录 undo log 到内存 buffer
4. 记录 redo log 到内存 buffer
5. 更改内存中的数据记录
6. 提交事务，触发 redo log 刷盘
7. 记录 bin log
8. 事务结束



