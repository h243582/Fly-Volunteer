一、计算机网络

## 1、`http`

### 1、概念

超文本传输协议

### 2、http协议的组成

包括请求 和 响应，在网页地址栏输入一个地址之后，浏览器会把请求发送给服务器，服务器收到响应，返回信息给浏览器

### 3、http请求

#### （1）请求头

==主机名，cookie，User-Agent==

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/202109022055175.png" alt="img" style="zoom: 50%;" />

#### （2）请求行

==请求方式（post、get）、请求的资源 内容==

#### （3）请求体

 当请求方式是post时，请求体会有请求参数格式如下：

    username=zhangsan&password=123
当请求方式时get时，请求参数是不会出现在请求体中，会拼接在url地址后面：

```
http://localhost:8080...？username=zhangsan&password=123
```

### 4、http响应

#### （1）响应头

location路径，Content-Disposition解析的资源，Set-Cookie设置cookie

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/202109022126248.png" alt="img" style="zoom:50%;" />

#### （2）响应行

包括==状态码== 返回给客户端

#### （3）响应体

**显示正文页面内容**，返回给客户端



## 2、HTTPS

### 核心SSL/TLS协议

SSL 指安全套接字协议，1999 年，SSL 3.0 进一步升级，**新版本被命名为 TLS 1.0**

SSL/TLS 的核心要素是**非对称加密**。非对称加密采用两个密钥——一个公钥，一个私钥。在通信时，私钥仅由解密者保存，公钥由任何一个想与解密者通信的发送者（加密者）所知。可以设想一个场景，

### 公钥传输的信赖性

为了公钥传输的信赖性问题，**CA** 会给各个服务器颁发证书，当客户端（浏览器）向服务器发送 HTTPS 请求时，一定要先获取目标服务器的证书，并根据证书上的信息，检验证书的合法性。

### 数字签名



## 3、HTTP和HTTPS区别

**端口号** ：HTTP 默认是 80，HTTPS 默认是 443。

**UTL 前缀** ：HTTP 的 URL 前缀是 `http://`，HTTPS 的 URL 前缀是 `https://`。

**安全性和资源消耗** ： HTTP 协议运行在 TCP 之上，所有传输的内容都是明文，客户端和服务器端都无法验证对方的身份。HTTPS 是运行在 SSL/TLS 之上的 HTTP 协议，SSL/TLS 运行在 TCP 之上。所有传输的内容都经过加密，加密采用对称加密，但对称加密的密钥用服务器方的证书进行了非对称加密。所以说，HTTP 安全性没有 HTTPS 高，但是 HTTPS 比 HTTP 耗费更多服务器资源。

## 4、应用层协议

### HTTP:超文本传输协议

### SMTP:简单邮件传输(发送)协议

### POP3/IMAP:邮件接收的协议

### FTP:文件传输协议

**基于 TCP 实现可靠的传输**。使用 `FTP` 传输文件的好处是可以屏蔽操作系统和文件存储方式。

在客户端与 FTP 服务器之间建立两个连接

1. **控制**连接：用于传送控制信息（命令和响应）
2. **数据**连接：用于数据传送；

这种将命令和数据分开传送的思想大大提高了 FTP 的效率

### Telnet:远程登陆协议

明文发送

### SSH:安全的网络传输协议

加密发送






## 5、`Tcp/Ip`

### 1、**它的模型，做了事情**

TCP/IP模型分为五层，分别是应用层，传输层，网络层，数据链路层，物理层

TCP/IP协议群主要是==报文的拆分==，增加协议头，==数据的传输==，==路由和寻址以及数据的重组==

### 2、**建立连接-三次握手**

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220304164501043.png" alt="image-20220304164501043" style="zoom:50%;" />

1. 主机A发送syn到主机B，要求建立a到b的连接。（**此时主机A的状态为syn_sent**）

2. 主机B回复`ack`+`syn`，要求建立b到a的连接，主机B的状态为syn_rcvd

   - （这里的`ack`和`syn`数据报本来是两个，但是==仅标志位不同，可以合并==,所以为什么不是四次的原因）

3. 主机A回复B中`syn`的`ack`。主机A的状态为established，建立A到B的连接

   **最后：**主机B接收到第3步的数据报，建立B到A 的连接，主机B的状态置为established

### **断开连接-四次挥手**

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220304164434033.png" alt="image-20220304164434033" style="zoom:50%;" />

1. 主机A发送`fin`到主机B，请求关闭a到b的连接
2. 主机B回复`ack`，主机B的状态置为close_wait（**表示可以关闭了**）
3. 主机B发送`fin`到主机A，请求关闭b到a的连接
4. 值即A回复`ack`（第三步的`fin`），状态置为time_wait（**表示可以关闭了**）

之后：主机B接收到第四步的数据报，状态置为closed

最后：主机A经过2MSL（超时等待时间）之后，状态置为closed

#### 为什么挥手要4次

因为当服务器收到客户端发的断开请求之后，服务器虽然可以直接断开连接了，但是服务器可能还正在给客户端发数据，一时半会儿发不完！所有要等一会儿再发送，不能一起发。

### 7、**TCP和UDP的区别**

![image-20220304164804021](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220304164804021.png)

1. TCP是有连接的可靠传输协议，而UDP是无连接的
2. UDP传时数据是有大小限制的，而TCP没有
3. UDP是面向数据报的，而TCP是面向数据流的
4. TCP保证数据正确性，顺序性，而UDP不能保证

## 6、TCP 协议如何保证可靠传输

1. 应用数据被分割成 TCP 认为最适合发送的数据块。
2. TCP 给发送的每一个包进行编号，接收方对数据包进行排序，把有序数据传送给应用层。
3. **校验和：** TCP 将保持它**首部**和**数据**的检验和。检测数据在传输过程中的任何变化。如果收到段的检验和有差错，TCP 将丢弃和不收它。
4. TCP 的接收端会丢弃重复的数据。
5. **流量控制：** TCP 连接的每一方都有**固定大小的缓冲空间**，TCP 的接收端只允许发送端发送接收端缓冲区能接纳的数据。当接收方来不及处理发送方的数据，能**提示发送方降低发送的速率**，防止包丢失。TCP 使用的流量控制协议是可变大小的滑动窗口协议。 （TCP 利用滑动窗口(=窗口大小告诉你 我接收方的容器有多大==)实现流量控制）
6. **拥塞控制：** 当网络拥塞时，减少数据的发送。
7. **ARQ 协议：** 也是为了实现可靠传输的，它的基本原理就是每发完一个分组就停止发送，等待对方确认。在收到确认后再发下一个分组。
8. **超时重传：** 当 TCP 发出一个段后，它启动一个定时器，等待目的端确认收到这个报文段。如果不能及时收到一个确认，将重发这个报文段。

#### ARQ 协议

**自动重传请求（ARQ）**是 OSI 模型中数据链路层和传输层的错误纠正协议之一；如果发送方在发送后一段时间之内没有收到确认帧，它通常会重新发送

## 7、URI 和 URL 的区别是什么?

- UR**I**(Uniform Resource Identifier) 是统一资源标志符，可以唯一标识一个资源。
- UR**L**(Uniform Resource Locator) 是统一资源定位符，可以提供该资源的路径。它是一种具体的 URI，即 URL 可以用来标识一个资源，而且还指明了如何 locate 这个资源。

URI 的作用像身份证号一样，URL 的作用更像家庭住址一样。URL 是一种具体的 URI，它不仅唯一标识资源，而且还提供了定位该资源的信息。





## 9、正向代理和反向代理的区别

==正向代理==：要访问的服务器==**只知道代理服务器**==来访问它，并==**不知道真实的客户端**==是谁

==反向代理==：反向代理正好相反。对于客户端来说，反向代理就好像目标服务器，客户端向反向代理发送请求，接着反向代理判断请求走向何处，隐藏了真实的服务器



## 10、DNS解析（DNS找IP）

当浏览器中输入www.baidu.com域名时，操作系统会检查自己本地的hosts文件查看是否有这个网址的映射关系，如果有，直接调用

如果没有，则查找本地的DNS解析器缓存，如果有，则直接返回IP

如果没有，再找TCP/IP参数中设置的本地的DNS服务器，如果该域名包含再本地配置区域的资源中，则返回解析结果。

也可能查找的域名，本地的DNS服务器已经缓存在网址的映射关系，那么直接调用这个IP

如果本地DNS服务器也无法解析，会根据本地的DNS服务器是否设置转发器进行查询

如果是未转发模式，本地DNS会把请求发给13台根DNS，由对应的根服务器（例如.com）向下找，最后完成解析

如果是转发模式，那么DNS服务器会把请求一级一级向上传，往上找，直到传到根DNS

## GET和POST的区别

get的请求数据只能放在url中，post的数据，可以放在url和请求体

**url长度有限制，所有get方法请求数据不能太多**，并且url只能传输ascli字符

POST安全性高，post可以存放请求数据在请求体，相对更加安全

GET主要是从服务端获取数据，而POST请求主要是将数据发送到服务端

POST请求刷新会被重新提交，但Get请求不会

## 常见的状态码

400:客户端请求语法错误，服务端无法理解

405：映射找到了，但是客户端请求方法和服务端提供的请求方法不匹配

500:服务端内部报错

403：无权限

## 输入一个URL到浏览器中，会发生什么

域名解析(DNS解析)

发起TCP的三次握手

建立TCP连接后发起HTTP请求（如果浏览器存储了该域名下的Cookies，那么会把Cookies放入HTTP请求头里发给服务器）

服务器端响应http请求，浏览器得到html代码

浏览器解析html代码，并请求html代码中的资源

浏览器对页面进行渲染呈现给用户

# 二、操作系统

## 1、系统调用

进程在系统上的运行级别分为用户态和系统态

- 用户态：用户可以直接读取的程序的数据
- 系统态：系统态运行的进程或程序几乎可以访问计算机的任何资源，不受限制。

所以说与系统态级别的资源有关的操作（如文件管理、进程控制、内存管理等)，都必须通过系统调用方式向操作系统提出服务请求，并由操作系统代为完成。

## 2、进程/线程、通信/同步

### （1）**进程和线程**的区别

一个进程里面装着多个线程，这些线程都是分别从主内存中拷贝的一个工作空间，都是私有的，线程里面包括了虚拟机栈、本地方法栈和程序计数器，程序计数器决定了这个线程运行到了哪一步。但他们共享堆了内存。

### （2）**通信与同步**的区别

**通信**是为了让进程/线程==**有顺序执行**==；同步是为了让进程/线程在执行时==**不被抢占**==（上锁）

### （3）、**进程**间**通信**方式



- **匿名管道**：亲属关系的进程
- **有名管道**：严格遵循先进先出（队列）
- **共享内存**：多个进程访问同一个数据，但是需要加互斥锁
- **信号**：
- **信号量**：用于多个进程对于共享数据的访问（拥塞控制）
- **消息队列**：
- **套接字Sockeet**：

### （4）、线程间通信方式

`（为什么要通信：保证线程有规律的执行，因为默认情况下CPU是随机切换线程）`

（什么是线程通信：多个线程在处理**同一个资源**，并且任务不同时，需要线程通信来帮助解决线程之间对同一个变量的**使用或操作**。）

#### 1、使用 `volatile` 关键字

```java
//定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
static volatile boolean notice = false;
```

多个线程同时监听一个变量，当这个变量发生变化的时候 ，线程能够感知并执行相应的业务。这也是最简单的一种实现方式

#### 2、Object类的`wait()，notify() `

==Object类提供了线程间通信的方法：`wait()`、`notify()`、`notifyaAl()`==

**注意： wait和 notify必须配合synchronized使用，wait方法释放锁，notify方法不释放锁**

程A发出notify()唤醒通知之后，依然是走完了自己线程的业务之后，线程B才开始执行，这也正好说明了，notify()方法不释放锁，而wait()方法释放锁。

```java
public class TestSync {
    public static void main(String[] args) throws InterruptedException {
        // 定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                    Thread.sleep(500);
                    if (list.size() == 5)  lock.notify();// 唤醒B线程
                }
            }
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 5)   lock.wait();
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                }
            }
        });
        //　需要先启动线程B
        threadB.start();
        Thread.sleep(1000);
        // 再启动线程A
        threadA.start();
    }
}
```

#### 3、JUC工具类 `CountDownLatch`

`jdk1.5`之后在`java.util.concurrent`包下提供了很多并发编程相关的工具类，简化了我们的并发编程代码的书写，`CountDownLatch`基于AQS框架，相当于也是维护了一个线程间共享变量state

```java
public class TestSync4 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                if (list.size() == 5)
                    countDownLatch.countDown();//用于使计数器减一，其一般是执行任务的线程调用
            }
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            if (list.size() != 5)      countDownLatch.await(); //主线程唤醒
            System.out.println("线程B收到通知，开始执行自己的业务...");
        });
        //　需要先启动线程B
        threadB.start();
        Thread.sleep(1000);

        // 再启动线程A
        threadA.start();
    }
}
```

#### 4、 ReentrantLock 结合 Condition

这种方式并不是很好，代码编写复杂，A在唤醒操作之后，并不释放锁。这种方法跟 ***Object*** 的 ***wait()*** 和 ***notify()*** 一样。

```java
public class TestSync3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        // 实现线程A
        Thread threadA = new Thread(() -> {
            lock.lock();  //加锁
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                Thread.sleep(500);
                if (list.size() == 5)
                    condition.signal();  //唤醒等待的线程，但是等待的还是要等自己先执行完释放
            }
            lock.unlock();
        });
        // 实现线程B
        Thread threadB = new Thread(() -> {
            lock.lock();
            System.out.println("先执行B");
            if (list.size() != 5) {
                 condition.await(); //让线程B进入等待,执行别的线程
            }
            System.out.println("线程B收到通知，开始执行自己的业务...");
            lock.unlock(); //释放锁
        });

        threadB.start();
        Thread.sleep(1000);
        threadA.start();
    }
}
```

#### 5、LockSupport实现线程间阻塞唤醒

***LockSupport*** 是一种非常灵活的实现线程间阻塞和唤醒的工具，使用它不用关注是等待线程先进行还是唤醒线程先运行，但是得知道线程的名字。

```java
public class TestSync2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 实现线程B
        final Thread threadB = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park(); //挂起当前线程
            }
            System.out.println("线程B收到通知，开始执行自己的业务...");
        });
        // 实现线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                Thread.sleep(500);
                if (list.size() == 5)
                    LockSupport.unpark(threadB);//恢复threadB线程
            }
        });
        threadA.start();
        threadB.start();
    }
}
```



### （5）**线程**同步机制

同步是为了几个线程==**并发**==执行线程，如下图，不重叠

![](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/7557373-da64ffd6d1effaac.jpg)

进程中线程同步的四种常用方式：

#### 1、互斥量(互斥锁)

采用互斥对象机制，只有拥有互斥对象的线程才有访问公共资源的权限。因为互斥对象只有一个，所以可以保证公共资源不会被多个线程同时访问。

#### 2、信号量（拥塞控制）

它允许同一时刻**多个线程来访问同一资源**，但是需要控制同一时刻访问此资源的**==最大线程数量==**。

#### 3、事件（信号）

通过通知操作的方式来保持多线程同步，还可以方便实现多线程优先级的比较。

#### 4、临界区(锁住的代码段)

临界区对象和互斥对象非常相似，只是互斥量允许在进程间使用，而临界区只限制与同一进程的各个线程之间使用，但是更节省资源，更有效率。
临界区： 当多个线程访问一个独占性共享资源时，可以使用临界区对象。拥有临界区的线程可以访问被保护起来的资源或代码段，其他线程若想访问，则被挂起，直到拥有临界区的线程放弃临界区为止。

## 3 、进程的调度算法

1. 先来先服务FCFS
2. 短作业优先**SJF**
3. 时间片轮转
   - 每个进程分配时间段（片）过了时间直接切换进程。
4. 多级反馈
   - 设置多个就绪队列，每个队列赋予优先级；每个队列按照FCFS排序；优先级越高的队列时间片越小
5. 优先级调度

## 4、死锁的条件

首先资源A被开启了互斥锁，其他进程只能等待它被释放，而且另一个进程开启了自旋锁，只要拿不到这个资源的锁，就一直自旋等待。

## 5、内存管理主要是做什么

分配与回收（malloc 函数：申请内存，free 函数：释放内存）

地址转换（逻辑地址转换成相应的物理地址）

## 6、内存管理机制

1. 连续分配管理方式
   1. **块式管理**
      - 一块只包含一个进程，如果一个进程只需要一丢丢空间，就很浪费，这个块里面没被用的空间叫碎片
2. ==非==连续分配管理方式
   1. **页式管理**
      - 增大版的块
   2. **段式管理** 
      - 一段一段的，比如一个程序段
   3. **段页式管理**
      - 分为很多段，每个段分为很多页

## 7、页面置换算法

是否缺页：被替换了

1. **OPT** （最佳页面置换算法）

   - 从主存中移出永远不再需要的页面；如无这样的页面存在，则选择最长时间不需要访问的页面。

   - | 访问页面 | 7    | 0    | 1    | 2    | 0    | 3    | 0    | 4    | 2    | 3    | 0    | 3    | 2    | 1    | 2    | 0    | 1    | 7    |
     | -------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
     | 物理块1  | 7    | 7    | 7    | 2    |      | 2    |      | 2    |      |      | 2    |      |      | 2    |      |      |      | 7    |
     | 物理块2  |      | 0    | 0    | 0    |      | 0    |      | 4    |      |      | 0    |      |      | 0    |      |      |      | 0    |
     | 物理块3  |      |      | 1    | 1    |      | 3    |      | 3    |      |      | 3    |      |      | 1    |      |      |      | 1    |
     | 缺页否   | √    | √    | √    | √    |      | √    |      | √    |      |      | √    |      |      | √    |      |      |      | √    |

1. **FIFO** （先进先出页面置换算法）
   - **最早来过的**页面最先移出
2. **LRU最久未使用算法**
   - **最早未被使用的**页面最先移出
3. **LFU最不经常使用**
   - 看之前**被置换最少**的先被置换

# 三、数据结构

## 1、栈

![栈](https://my-blog-to-use.oss-cn-beijing.aliyuncs.com/2019-6/%E6%A0%88.png)

### （1）java实现栈Stack

```java
    Stack<Integer> stack = new Stack<Integer>();
```

- `push()`：入栈
- `pop()`：返回栈顶元素并出栈
- `peek()` :返回栈顶元素**不**出栈
- `isEmpty()`:
- `size()`

## 2、堆

特征：每一个节点值都大于等于（或小于等于）子树中任意节点的值



## 3、树

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307142649321.png" alt="image-20220307142649321" style="zoom: 50%;" />

### （1）排序二叉树(BST)

又称**二叉查找树**（Binary Search Tree），亦称**二叉搜索树**。

特征：

1. 左<父，父<右

2. 孩子均可为空

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20190708213538773.png" alt="在这里插入图片描述" style="zoom: 33%;" />

缺点：

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307143336503.png" alt="image-20220307143336503" style="zoom: 25%;" />



### （2）完全二叉树

1. 除**末尾层**外，其它各层的结点数都达到最大个数，（只有**最右下角**末尾可以没有节点）

   

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210721194724.png" alt="img" style="zoom: 67%;" /><img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210721091410.png" alt="image-20210721091410629" style="zoom: 80%;" />



### （3）平衡二叉树(二叉排序树)

#### 特征：

1. ==包括排序二叉树的特征==
2. 所有子树**平衡因子** <= 1   （平衡因子是左右子树高度差）
3. 非叶子节点最多拥有两个子节点；
4. **没有相等的重复节点**

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720163212.png" alt="image-20210720163211145" style="zoom:80%;" /><img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720163248.png" alt="image-20210720163248838" style="zoom:80%;" />

#### 用途：

用来折半查找







### （4）B树(B-tree)

==**平衡多路查找树**==

#### 特征：

1. 左小右大

2. ###### 1 **<** ==**非叶节点**的**子节点数**== **<**M    (**M=2则是2叉树,M=3则是3叉**)

3. 根节点**有且只有**1个**关键字**。

4. 非根节点至**少**有M2个**关键字**。

5. 每个节点最**多**有M-1个**关键字**

#### 优点

如果**经常访问的数据离根节点很近**，而B树的非叶子节点存储关键字数据的地址，所以这种数据检索的时候会要比B+树快。



### （5）B+树

#### 特征：

1. **由B树衍生而来**
2. 根节点至少一个元素
3. 非根节点元素范围：m/2 <= 节点 <= m-1
4. B+树有两种类型的节点：**内部结点**（也称索引结点）和**叶子结点**。
   - **内部节点就是非叶子节点**，内部节点不存储数据，只存储索引，**数据都存储在叶子节点**。
   - 左小右大
5. 每个**叶子都存有邻居的指针**，叶子结点本身依关键字的大小自小而大顺序链接。
6. **父节点**存放**右孩子**的**首元素的指针**。

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720171837.png" alt="img" style="zoom:80%;" />

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720172249.png" alt="img" style="zoom:80%;" />



#### b+树优点

- 层级更少：树干存储的关键字数（索引）更多，所以查询速度更快
- ==查询性能稳定==
- 所有的叶子节点形成了一个有序链表，更加便于查找。
- 全节点遍历更快，只需要遍历所有的叶子节点即可。不用看树干





### （6）2-3树

#### 特征：

1. 2-3树不是二叉树
2. **2-节点: **有两个孩子，自身必含一个**数据项**； **左孩子** < 自身数据项 < **右孩子**
3. **3-节点:** 有三个孩子 ，**自身必含两个数据项**（用来查找的），**左孩子** < 左数据项，左数据项<**中孩子**<右数据项，右孩子>右数据项

#### 查找**H**的过程



### （7）2-3-4树

#### 特征：

1. 除了叶子节点，所有的节点都只有2个孩子或3个孩子或4个孩子
2. 有四个孩子的节点原理和三个孩子的原理相同

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720205814.png" alt="img" style="zoom:80%;" />

1. 所有的叶子节点的深度都是相同的（非叶子结点的**孩子必须连满**）

![image-20210720205855931](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210720205855.png)



### （8）[红黑树](https://www.cnblogs.com/wl889490/p/12733936.html)

==**由查找二叉树演变而来**==

#### 性质

- 性质1：每个节点要么是黑色，要么是红色。
- 性质2：**根节点是黑色**。
- 性质3：每个**叶子节点（NIL）是黑色**。
- 性质4：每个红色节点的两个子节点一定都是黑色。 不能有两个红色节点相连。
- 性质5：任意一节点到每个叶子节点的路径都包含数量相同的黑结点。

![img](https://img-blog.csdnimg.cn/20200212123747217.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3k1MDY3OTgyNzg=,size_16,color_FFFFFF,t_70)

#### **红黑树的应用** 

`TreeMap`、`TreeSet`以及`JDK1.8`的`HashMap`底层都用到了红黑树。

#### **为什么要用红黑树**

为了解决二叉查找树的缺陷，因为二叉查找树在某些情况下会退化成一个线性结构

平衡二叉树通过保持任一节点左、右子树高度差的绝对值不超过1来维持二叉树的平衡；

红黑树是根据查找路径上黑色节点的个数以及红、黑节点之间的联系来维持二叉树的平衡。平衡二叉树在插入/修改时旋转次数不可知，这也**导致在频繁的插入、修改中造成的效率问题**。红黑树在执行插入修改的操作时会发生旋转与变色（红变黑，或者黑变红）以**确保没有一条路径会比**其它路径长出两倍。

总结：**在插入或者删除节点时，红黑树旋转的次数比平衡二叉树少，因此在插入与删除操作比较频繁的情况下，选用红黑树。**

#### **为什么mysql索引使用b+树而不使用红黑树?**

红黑树多用在内部排序，即全放在内存中的

数据库文件实际存储在磁盘中；B+树多用于外存上时，B+也被成为一个磁盘友好的数据结构。



### （9）二叉树的遍历

#### 先序遍历

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307145418296.png" alt="image-20220307145418296" style="zoom:50%;" />

#### 中序遍历

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307145358848.png" alt="image-20220307145358848" style="zoom:50%;" />

#### 后序遍历

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307145334770.png" alt="image-20220307145334770" style="zoom:50%;" />

根据**前中序求后序**或者**后中序求前序**：

​		根据前/后序确定父节点是哪个

​		根据中序确定子节点在左/右  或者  哪个是儿子哪个是孙子



# 四、Java基础

## 1、访问控制修饰符

- private：仅在本类中可用

- 默认：仅同包中的 本类和子类可用

- protected：同包中的 本类和子类可用、不用包的子类可用

- public：均可用（stu.name）

## 2、hashCode() 作用

`hashCode()` 的作用是获取哈希码（`int` 整数），也称为散列码。这个哈希码的作用是确定该对象在哈希表中的索引位置。

散列表存储的是键值对(key-value

>当你把对象加入 `HashSet`(自动去重)时，`HashSet` 会先计算对象的 `hashCode` 值来判断对象加入的位置，同时也会与其他已经加入的对象的 `hashCode` 值作比较，如果没有相符的 `hashCode`，直接添加成功
>
>若发现有相同 `hashCode` 值的对象，这时会调用 `equals()` 方法来检查。如果两者相同添加失败。如果不同的话，就会重新散列到其他位置。这样我们就**==大大减少了 `equals` 的次数==**，相应就大大提高了执行速度。

- 如果两个对象的`hashCode` 值相等，那这两个对象不一定相等（哈希碰撞）。
- 如果两个对象的`hashCode` 值相等并且`equals()`方法也返回 `true`，我们才认为这两个对象相等。
- 如果两个对象的`hashCode` 值不相等，我们就可以直接认为这两个对象不相等。

## 3、基本数据类型

| 基本类型  | 位数 | 字节 | 默认值  | 取值范围                                   |
| :-------- | :--- | :--- | :------ | ------------------------------------------ |
| `byte`    | 8    | 1    | 0       | -128 ~ 127                                 |
| `short`   | 16   | 2    | 0       | -32768 ~ 32767                             |
| `int`     | 32   | 4    | 0       | -2147483648 ~ 2147483647                   |
| `long`    | 64   | 8    | 0L      | -9223372036854775808 ~ 9223372036854775807 |
| `char`    | 16   | 2    | 'u0000' | 0 ~ 65535                                  |
| `float`   | 32   | 4    | 0f      | 1.4E-45 ~ 3.4028235E38                     |
| `double`  | 64   | 8    | 0d      | 4.9E-324 ~ 1.7976931348623157E308          |
| `boolean` | 1    |      | false   | true、false                                |

Java 里使用 `long` 类型的数据一定要在数值后面加上 **L**，否则将作为整型解析。

## 4、接口和抽象类区别

- 抽象类单继承、接口多实现
- 抽象类主要用于代码复用
- 接口中的成员变量只能是 `public static final` 类型的，不能被修改且必须有初始值，而抽象类的成员变量默认 default，可在子类中被重新定义，也可被重新赋值

## 5、深拷贝和浅拷贝区别

浅拷贝：浅拷贝会在堆上创建一个新的对象，但是如果原对象的==成员变量是引用类型==，浅拷贝会直接复制内部对象的引用地址

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307164755158.png" alt="image-20220307164755158" style="zoom: 80%;" />

深拷贝：开辟了新空间，包括了成员变量

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307164837418.png" alt="image-20220307164837418" style="zoom:80%;" />

引用拷贝：还是引用同一个地址

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20220307164845182.png" alt="image-20220307164845182" style="zoom:80%;" />

## 6、Object类

```java
public final native Class<?> getClass()//native方法，用于返回当前运行时对象的Class对象，使用了final关键字修饰，故不允许子类重写。

public native int hashCode() //native方法，用于返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
public boolean equals(Object obj)//用于比较2个对象的内存地址是否相等，String类对该方法进行了重写用户比较字符串的值是否相等。

protected native Object clone() throws CloneNotSupportedException//naitive方法，用于创建并返回当前对象的一份拷贝。一般情况下，对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 为true。Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生CloneNotSupportedException异常。

public String toString()//返回类的名字@实例的哈希码的16进制的字符串。建议Object所有的子类都重写这个方法。

public final native void notify()//native方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。

public final native void notifyAll()//native方法，并且不能重写。跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。

public final native void wait(long timeout) throws InterruptedException//native方法，并且不能重写。暂停线程的执行。注意：sleep方法没有释放锁，而wait方法释放了锁 。timeout是等待时间。

public final void wait(long timeout, int nanos) throws InterruptedException//多了nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上nanos毫秒。

public final void wait() throws InterruptedException//跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念

protected void finalize() throws Throwable { }//实例被垃圾回收器回收的时候触发的操作
```

## 7、String-Buffer-Builder 区别

- **String**：
  - 每次对 `String` 类型进行改变的时候，都会生成一个新的 `String` 对象，然后将指针指向新的 `String` 对象
- `StringBuffer`：
  -  对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。
- `StringBuilder` “
  - 并没有对方法进行加同步锁，所以是非线程安全的。

>String str4 = str1 + str2 + str3;中的+实际上通过 `StringBuilder` 调用 `append()` 方法实现的，拼接完成之后调用 `toString()` 得到一个 `String` 对象 。

## 8、IO

### （1）某字段不想序列化

transient关键字

```java
private transient int tree=20;
```

### （2）字节流

#### ①FileOutputStream类（字节输出流）

`fos.write(by)`

```java
FileOutputStream fos = new FileOutputStream("E:\\heyifeo.txt");
```

#### ②FileInputStream类（字节输入流）

`fis.read()`

```java
FileInputStream fis = new FileInputStream("E:\\D.txt");
```

#### ③BufferedOutputStream

```java
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\D.txt"));
```

#### ④BuffferedInputStream



### （2）字符流

#### ①OutputStreamWriter类

`osw.write("我",0,1);//我`

```java
OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\D.txt"));//默认编码

OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\D.txt"),"GBK");//指定编码
```

#### ②InputStreamReader

`isr.read()`

```java
InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\D.txt"));
```

#### ③FileReader

`fr.read()`

```java
FileReader fr = new FileReader ("a. txt") ;
```

#### ④FileWrite

`fw. write (“ch”)`

```java
FileWriter fw = new FileWriter ("b. txt") ;
```

#### ⑤BufferedWrite

`bw. write (“ch”)`

```java
BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\D.txt"));
```

#### ⑥BufferedReader

`br.read()`

```java
BufferedReader br = new BufferedReader(new FileReader("E:\\D.txt"));
```



## 9、集合

### （1）总揽

#### ① Collection 

Collection 实现`Iterable`接口

1. `List` 添加取出有序，有索引，能存放重复，能存放NULL，可以存放多个

   1. `ArrayList`
   2. `LinkedList`
   3. `Vector`

2. `Set`  添加取出无序，无索引，不能存放重复，能存放NULL，但是只能存放一个

   因为没有索引，所以不支持普通for循环的方式遍历数据

   1. `HashSet`
   2. `TreeSet`
   3. `LinkedHashSet`

#### ② Map

遍历的六种方式：	`Map.keySet()得到所有key-Set集合`，`Map.values()得到所有的value-collection集合`，`转换成Map.Entry的方式->Set集合`，每种分为增强for和迭代器

- `HashMap`单线程使用
- `HashTable`淘汰
- `TreeMap`
- `properties`
- `LinkedHashMap`
- `ConcurrentHashMap`多线程使用

#### ③如何判断覆盖/加入

1.  通过`hashcode`方法 , ==根据内存地址经过指定运算, 得到int类型哈希值.== 

2. 将哈希码==取余当前数组容量==, ==余数对应着数组的下标== 

3. 当此数组下标位置没有元素时 , 直接存.

   有元素时, 需要跟此位置所有数据进行对比. 如果发现不同

   ​		如果不同, 则存到数组指向的了链表末尾（尾插法）,
   ​       如果相同, ==则调用equals方法==. 进一步判断

### （2）Iterator

  `foreach`就是简化版的`Iterator`

  遍历集合三种方法：**迭代器，增强for，普通for**

### （3）`ArrayList`不安全

- 线程不安全(没有synchronized)， 没有Transient（不会被序列化)
- 数组实现
- 初始化的时候若是无参则一开始大小为0，第一次扩容为10，以后一直1.5倍扩容；
- 若是有参`new ArrayList(20);`，则一直按照这个参数的1.5倍扩容

### （4）`Vector`安全

- 线程安全->带有synchronized

- 数组实现

- 初始化无参默认10，扩容2倍

- 有参扩容2倍


### （5）`LinkedList`不安全

- 实现了双向链表和双端队列的特点

- 双向链表，两个分别指向头尾节点的指针

- 添加删除元素相对来说效率较高

- ==改查选`ArrayList`，增删选`LinkedList`==

### （6）`HashSet`

- 底层是`HashMap`

- 元素是否有序：

  - 取决于hash后，在确定索引的结果

- **区分对象是否重复**：

  - 是先hash值，再equals

- 扩容

  - 底层是`HashMap`，而`HashMap`的底层是数据+链表+红黑树
  - 先是Hash表，当hash表的**单一链表长度超过 8 个**，并且**数组的大小超过64**的时候，那个链表结构就会**转为红黑树结构**

- `hashcode`得到的值不是hash值，因为还做了额外的处理

- 第一次添加的时候，table数组默认扩容到16，临界值是12(四分之三加载因子)；也就是说只要到了3/4就会扩容。扩容到超过64就变成了红黑树

- 临界值：虽然大小没有达到上限，但是要做一个缓冲，所以大小到了临界值会扩容

- 每一次table大小扩容是原来的两倍，临界值更新为四分之三

  


### （7）`LinkedHashSet`

底层是`LinkedHashMap`，维护了一个数组+双向链表

根据元素的`hashcode`值来决定元素的存储位置，同时使用链表来维护元素的次序(跨链表)，使得插入和遍历顺序一样

存在head和tail指针

==不允许添加重复元素==

### （8）`TreeSet`不安全

- ==排序==
- ==无参构造器默认不排序==
- 初始化的时候在构造器中传入自己的比较器

- `TreeSet`实际上是`TreeMap`实现的
- 初始化了一个数组  长度16 , 初始容量16 
- 当链表中数据超过8个则变成二叉树. 当小于6个的时候变成链表

####   -对象实现排序

##### ①自然排序

要在自定义类中实现`Comparerable<T>`接口  ，并且重写`compareTo`方法

`return -1;`  : -1表示放在红黑树的左边,即逆序输出
`return 1;`   : 1表示放在红黑树的右边，即顺序输出
`return o;`   : 0表示元素相同，仅存放第一个元素

```java
public class Student implements Comparable<Student> {
	private String name;
	private int age;
    
    @Override
	public int compareTo(Student s) {
        
		//主要条件 姓名的长度,如果姓名长度小的就放在左子树，否则放在右子树
		int num = this.name.length() - s.name.length();  

		//如果这两个字符串相等，就判断年龄（第二排序）
        if(num == 0){
           num = this.age - s.age
        }
		return num;
	}	
}
```

##### ②比较器排序

在自定义类中实现`Comparetor<t>`接口，重写`compare`方法

匿名内部类很方便

```java
public static void main(String[] args) {
    TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            //主要条件 姓名的长度,如果姓名长度小的就放在左子树，否则放在右子树
            int num = this.name.length() - s.name.length();  

            //如果这两个字符串相等，就判断年龄（第二排序）
            if(num == 0){
               num = this.age - s.age
            }
            return num;
        }});
	Student s1 = new Student("linqingxia", 27);
	Student s2 = new Student("zhangguorong", 29);
	ts.add(s1);
	ts.add(s2);
    for (Student s : ts) {
		System.out.println(s.getName() + "---" + s.getAge());
	}
}
```



### （9）`HashMap`不安全

#### 执行过程

##### ①执行构造器`new HashMap()`

​		 `HashMap$Node[] table = null`

##### ②执行put调用hash算法

​		`return (key == null) ? 0 : (h = key.hashcode()) ^ (h >>> 16)`

##### ③执行putVal

​    `if(table == null || table.length == 0)`    调用`resize()`扩容,第一次为16

​      添加节点

​      若有相同的   则直接break

​      大小是否到达临界值      是则扩容

#### `HashMap`为什么线程不安全

put的时候造成数据覆盖，get的时候造成死循环

​		1、put的时候导致的多线程数据不一致。

​		2、get操作可能因为resize而引起死循环（`cpu100%`）

​	    一个线程在遍历，另一个线程在修改，`HashMap`很可能出现问题

新链表位置

要么和旧位置一样，要么旧的位置加上新扩容的大小（5+16就到了21）



### （10）`ConcurrentHashMap`安全

#### 安全的原因

- 通过**锁分段**技术保证并发环境下的写操作；
- 通过 `HashEntry`的不变性、`Volatile`变量的内存可见性和加锁重读机制保证高效、安全的读操作；
- **通过不加锁和加锁两种方案控制跨段操作的的安全性。**
- key不能为NULL
- 分段锁，锁的是segment

​	



### （11）淘汰`HashTable`安全

`HashTable`的操作几乎和`HashMap`一致，主要的区别在于`HashTable`为了实现多线程安全，在几乎所有的方法上都加上了`synchronized`锁，而加锁的结果就是`HashTable`操作的效率十分低下。

- 存放的Key和Value都不能为NULL，否则抛出异常


- 底层有数组`HashTable$Entry[]` ,初始化大小为11 临界值为11*0.75 = 8

- 扩容机制: 原来的大小 * 2 + 1




### （12）`properties`

  继承`HashTable`实现了Map接口

  与`HashTable`一样Key和Value都不能NULL

  相同Key替换Value

### （13）`TreeMap`

实现参考`TreeSet`

底层红黑树



# 五、算法

## 1、时间复杂度（最坏）

一个算法中的语句执行次数称为语句频度或时间频度，记为T(n)。

- 忽略常数项
- 忽略低次项
- 忽略系数

一般情况下，算法中的基本操作语句的重复执行次数是问题规模n的某个函数，用T(n)表示，若有某个辅助函数f(n)，使得当n趋近于无穷大时，T(n) / f(n) 的极限值为不等于零的常数，则称f(n)是T(n)的同数量级函数。记作 T(n)=Ｏ( f(n) )，称Ｏ( f(n) ) 为算法的渐进时间复杂度，简称时间复杂度。

常见时间复杂度（按从小到大排列）

1. 常数阶O(1)
2. 对数阶O(log2n)
3. 线性阶O(n)
4. 线性对数阶O(nlog2n)
5. 平方阶O(n^2)
6. 立方阶O(n^3)
7. k次方阶O(n^k)
8. 指数阶O(2^n)

在做算法分析时，主要讨论的是时间复杂度。从用户使用体验上看，更看重的程序执行的速度。一些缓存产品(redis, memcache)和算法(基数排序)本质就是用空间换时间.





## 2、排序算法

### （1）算法分类

十种常见排序算法可以分为两大类：

- **比较类排序**（非线性）：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)
- **非比较类排序**（线性）：不比较就决定元素间次序，它可以突破比较排序的时间下界，达到线性

![img](网络+操作系统+数据结构+Java基础+集合.assets/849589-20190306165258970-1789860540.png)

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210712201214.png)

> 时间复杂度是 **O(nlog2n)** 的有：**归并排序**以及**堆排序**，**快速排序**平均和最好时间复杂度也可
>
> **稳定**的排序有：**冒泡排序**，**插入排序**，**归并排序**，以及所有的非比较排序。
>
> 总结：归并排序既稳定，时间复杂度又低，就是空间复杂度较高。



### （2）如何选择排序算法

==考虑点1==：如果待排序列基本有序

可以选择冒泡排序和插入排序，时间复杂度直逼 O(n)

==考虑点2==：如果待排序基本无序（通常）

数据量少的时候，还是可以选插入排序，但数据量大的时间，就要选择时间复杂度更优的排序算法，比如归并、快排、堆，这些时间复杂度都是 O(nlogn)。

但是如果选择了快速排序，而每次选择的基准数都是剩余数据里的最大值或最小值的话（序列有序或完全倒序），则快速排序时间复杂度退化到O（n^2）。

==考虑点3==：排名之类保证稳定性

则只能使用冒泡、插入、归并、非比较算法 。

> 总结来看：一般情况下，快速排序和希尔排序在排序速度上表现是比较优秀的，而归并排序稍微次之



### 1.1、冒泡排序On<sup>2</sup>

基本思想：一次比较相邻的两个数，比较如果大就交换位置。一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！

1. 一共进行数组的大小 -1 次大的循环
2. 依次比较相邻的元素，如果发现逆序就交换

优化：如果发现某一趟排序中，没有发生一次交换，可以提前结束排序

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210713090324.gif)

代码实现：

```java
public static void sort(int[] arr) {
        int temp = 0;   //临时变量
        boolean flag = false;     //标记变量

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {        //判断是否逆序，逆序则交换
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            //判断是否已经有序
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
```



### 1.2、选择排序On<sup>2</sup>

基本思想：需要遍历若干次待排序的数列，每次循环时假设第 i 位最小，从 i 到 N进行扫描，选择最小的和 i 进行交换

**算法分析：**

​		无论什么数据进去都是 O(n2) 的时间复杂度，所以用到它的时候，数据**规模越小越好**。唯一的好处可能就是不占用额外的内存空间了吧。

![img](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210713090755.gif)

代码实现：

```java
public static void sort(int[] arr) {
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];    //定义最小值
            minIndex = i;    //定义最小值的下标
          
            //查找最小值与最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //判断是否需要交换
            if (minIndex != i) {   
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
```



### 1.3、插入排序On<sup>2</sup>

#### 基本思想：

把数列分为为一个**有序表**和一个**无序表**。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。

#### 算法分析：

插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，**需要反复把已排序元素逐步向后挪位**，为最新元素提供插入空间。

#### 存在的问题：

当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响。所以需要用到希尔排序（更高效），又叫做缩小增量排序。

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210713091110.gif" alt="img" style="zoom:67%;" />



代码如下：

````java
public static void sort(int[] arr) {
        int insertVal = 0; //待插入的元素
        int insertIndex = 0;  //待插入的前一个位置

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            //与前面的元素进行比较，寻找插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //元素后移，给待插入元素空出一个位置
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //找到待插入的位置，插入待插入元素
            if (insertIndex>=0 &&insertIndex != i - 1) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
````



### 1.4、希尔排序On<sup>1.3</sup>

（插入排序优化版）

#### 基本思想：

希尔排序实质上是一种分组插入方法。它的基本思想是: 对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，所有距离为gap的倍数的记录放在同一个组中；然后，对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。然后减小gap的值，并重复执行上述的分组和排序。重复这样的操作，当gap=1时，整个数列就是有序的。

#### 算法分析：

希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。　

#### 代码实现：

```java
public void  shellSort(int[] arr) {
    int len = arr.length;
    for (int gap = len / 2; gap > 0; gap = gap / 2) {
        // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
        for (int i = gap; i < len; i++) {
            int j = i;
            int current = arr[i];
            while (j - gap >= 0 && current < arr[j - gap]) {
                arr[j] = arr[j - gap];
                j = j - gap;
            }
            arr[j] = current;
        }
    }
}
```





#### 1.5、快速排序

基本思想：

选择一个基准数，通过**一趟排序**将要排序的数据分割成独立的两部分；其中一部分的所有数据都比另外一部分的所有数据都要小。然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

![picture3.1](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/202108261239638.png)

首先哨兵 **j** 开始出动。因为此处设置的基准数是最左边的数，所以需要让哨兵 **j** 先出动，这一点非常重要（请自己想一想为什么）。哨兵 **j** 一步一步地向左挪动（即 **j--**），直到找到一个小于 **6** 的数停下来。接下来哨兵 **i** 再一步一步向右挪动（即 **i++**），直到找到一个数大于 **6** 的数停下来。最后哨兵 **j** 停在了数字 **5** 面前，哨兵 **i** 停在了数字 **7** 面前。

![picture3.2](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172502.png)

![picture3.3](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172506.png)

![picture3.4](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172518.png)

![picture3.5](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172522.png)

![picture3.6](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172531.png)

![picture3.7](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172534.png)

![picture3.8](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/20210714172539.png)



代码实现：

```java
public static void sort(int[] arr, int left, int right) {
    //如果左边界大于右边界则结束递归
    if (left >= right) {
        return;
    }
    int i = left;  //暂存左边界
    int j = right;   //暂存右边界
    int base = arr[left];//base中存放基准数【左边界值】

    //i == j代表左右两边的指针已经重合，不需要再比较了
    while (i != j) {
        //先从右往左找，直到找出比base值小的数
        while (i < j && arr[j] >= base) {
            j--;
        }
        //先从左往右找，直到找出比base值大的数
        while (i < j && arr[i] <= base) {
            i++;
        }
        //交换比其次数小的数与比基准数大的数的位置
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //将基准数放到中间位置【基准数归位】
    arr[left] = arr[i];
    arr[i] = base;
    //递归
    sort(arr, left, i - 1);
    sort(arr, i + 1, right);
}
```

`什么情况下快排的查询效率最低`：

最坏情况下，是整个序列都已经有序或完全倒序

此时,快速排序退化为冒泡排序,要比较n2次才能完成

### 1.6、归并排序`Onlogn`

基本思想：

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and  Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

- 把长度为 n 的输入序列分成两个长度为 n/2 的子序列
- 对这两个子序列分别采用归并排序
- 将两个排序好的子序列合并成一个最终的排序序列

算法分析：

归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/1024555-20161218163120151-452283750.png" alt="img" style="zoom: 50%;" />

![img](https://images2015.cnblogs.com/blog/1024555/201612/1024555-20161218194508761-468169540.png)![img](https://images2015.cnblogs.com/blog/1024555/201612/1024555-20161218194621308-588010220.png)



代码实现：

````java
     /**
     * 分
     * @param arr   待排序数组
     * @param left  左边索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void sort(int[] arr, int left, int right, int[] temp) {
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            //向左递归进行分解
            sort(arr, left, mid, temp);
            //向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //合并
            add(arr, left, mid, right, temp);
        }
    }

    /**
     * 合(排序)
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void add(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;      //左序列的起始位置
        int j = mid + 1;   //右序列的起始位置
        int t = 0;   //指向临时数组的当前索引

        //将两边的数组所有元素整按大小放入临时数组，直到一边全部存入
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将剩余数据的一边的数据依次全部放入临时数组
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //复制临时数组的数据到原始数组，但不是拷贝所有，只拷贝left到right之间的值
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
````

### 1.7、堆排序Onlogn

堆排序是利用堆这种数据结构而设计的排序算法，**堆排序是一种选择排序**，它的最坏，最好，平均时间复杂度均为 O(nlogn)，它也不是稳定的排序。

堆是具有以下性质的**完全二叉树**：**结点 >= 左右孩子** ，称为大顶堆(倒序)。结点 <= 左右孩子，称为小顶堆（从小到大）。

堆排序的基本思想是： 

1. 将无序列表构建成一个堆，根据升降序需求选择大顶堆或小顶堆
2. 将堆顶元素与末尾元素进行交换，将最大的元素“沉”到数组末尾
3. 重新调整结构，使其满足堆的定义，然后继续交换堆顶元素和当前末尾元素，反复执行调整+交换步骤，直到整个序列有序

![img](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015231308699-356134237.gif)

代码如下：

```java
public class Demo2 {
    public static void heapsort(int[] tree, int n, int i) {
        if (i == n)   return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max])            max = c1;
        if (c2 < n && tree[c2] > tree[max])            max = c2;
        if (max != i) {
            int temp = tree[i];
            tree[i] = tree[max];
            tree[max] = temp;
            heapsort(tree, n, max);
        }
    }

    public static void main(String[] args) {
        int[] tree = {3,6,1,4,5,2,7,8};
        int n = tree.length;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = (j - 1) / 2; i >= 0; i--) {  heapsort(tree, j+1, i); }
            int temp = tree[0];
            tree[0] = tree[j];
            tree[j] = temp;
        }
        System.out.println(Arrays.toString(tree));
    }
}
```



### 1.8、基数排序

基本思想：

> 把个位，十位，百位分别进行计数排序

​       将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次计数排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。

- 找出待排序的数组中最大和最小的元素；
- 统计数组中每个值为 i 的元素出现的次数，存入数组 C 的第 i 项；
- 对所有的计数累加（从 C 中的第一个元素开始，每一项和前一项相加）
- 反向填充目标数组：将每个元素i放在新数组的第 C(i) 项，每放一个元素就将 C(i) 减去 1。



![img](https://gitee.com/anshao0625/blog-imgs/raw/master/img/alg-sort-radix-1.jpg)

代码如下：

```java
public static void sort(int[] arr) {
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //定义一个一维数组，记录每个桶中的有效个数
        int[] bucketElementCount = new int[10];

        //先得到数组中最大元素的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        //完成基数排序一共需要maxLength次排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素的位（个位、十位、百位）进行排序处理（放入对应的桶中）
            for (int value : arr) {
                //取出每个元素个位的值
                int digitOfElement = value / n % 10;
                //放入对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = value;
                bucketElementCount[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原数组）
            int index = 0;
            //遍历每一个桶，
            for (int k = 0; k < 10; k++) {
                //如果桶中有数据，才放入原数组
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //处理完每个桶后，一定要将每个桶的有效个数清空！！
                bucketElementCount[k] = 0;
            }
        }
    }
```



### 1.9、桶排序On<sup>2</sup>

将待排序元素划分到不同的桶。先扫描一遍序列求出最大值 max 和最小值 min ， 

设桶的个数为 k ，则把区间 [min, max] 均匀划分成k个区间，每个区间就是一个桶。将序列中的元素分配到各自的桶。
**对每个桶内的元素进行排序。可以选择任意一种排序算法。** 将各个桶中的元素合并成一个大的有序序列。
假设数据是均匀分布的，则每个桶的元素平均个数为 n/k 。**桶越多，时间效率就越高，而桶越多，空间就越大。**





### 1.10、计数排序

**计数排序O(n+k)**本质上是一种特殊的**桶排序**，当桶的个数最大的时候（每个桶一个数），就是计数排序。







## 3、查找算法 

### 2.1、线性查找

基本思想：最简单的一种查找算法，直接遍历数据即可

代码实现：

```java
/**
 * 线性查找
 * @param arr  待查找数组
 * @param value  待查找的值
 * @return 查找到的下标
 */
public static int search(int[] arr, int value){
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == value){
            return i;
        }
    }
    return -1;
}
```

### 2.2、二分查找

基本思想：

1、首先确定该数组的中间的下标 

​          mid = (left + right)/2;

2、然后让待查找的数`findVal``与arr[mid]`进行比较

​          2.1 **`findVal` > arr[mid]** 说明要查找的数在mid的右边，向右递归

​          2.2 **findVal < arr[mid]** 说明要查找的数在mid的左边，向左递归

​          2.3 **findVal = arr[mid]** 说明找到，直接返回

什么时候需要去结束递归？

- 找到就结束递归
- 递归完整个数组，仍然没有找到findVal，也需要结束递归，当left>right

代码实现：

```java
 /**
 * 二分查找
 * @param arr     数组
 * @param left    左边的索引
 * @param right   右边的索引
 * @param findVal 待查找的值
 * @return 如果找到返回下标，如果没有，返回-1
 */
public static int search(int[] arr, int left, int right, int findVal) {
    if (left > right) {
        return -1;
    }
    int mid = (left + right) / 2;
    int midVal = arr[mid];

    if (findVal < midVal) { //向左递归
        return search(arr, left, mid - 1, findVal);
    } else if (findVal > midVal) {  //向右递归
        return search(arr, mid + 1, right, findVal);
    } else {
        return mid;
    }
}
```

### 2.3、插值查找

基本思想：

- 插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找
- `int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])`

插值查找注意事项：

1. 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
2. 关键字分布不均匀的情况下，该方法不一定比折半查找要好

代码实现：

```java
 /**
 * 插值查找
 * @param arr  数组
 * @param left  左边的索引
 * @param right   右边的索引
 * @param findVal  待查找的值
 * @return  如果找到返回下标，如果没有，返回-1
 */
public static int search(int[] arr, int left, int right, int findVal) {
    if (left > right || findVal < arr[left] || findVal > arr[right]) {
        return -1;
    }
    //自适应mid
    int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
    int midVal = arr[mid];
    if (findVal < midVal) {
        return search(arr, left, mid - 1, findVal);
    } else if (findVal > midVal) {
        return search(arr, mid + 1, right, findVal);
    }else{
        return mid;
    }
}
```





# 六、设计模式

## 1、工厂模式

实际上提供了一种创建对象最佳的方式。

在工厂模式中，创建对象时不会向客户端暴露创建逻辑，并且是通过使用一个公共的接口来指向新创建的对象。

实现了创建者与调用者分离。

工厂模式又分为简单工厂模式、工厂方法模式、抽象工厂模式。

### （1）简单工厂模式

用来生产同一等级结构中的任意产品。就一个工厂类，里面就一个方法，通过if来判断new哪个类（不支持扩展增加产品）

````java
interface Car{
    void run();
}
class B implements Car {
    public void run(){System.out.println("我在开宝马");}
}
class A implements Car {
    public void run(){System.out.println("我在开奥迪");}
}

public class SimpleFactory {
    
    public static Car create(String name){
        if("".equals(name)){return null;}
        if("奥迪".equals(name)){return new A();}
        if("宝马".equals(name)){return new B();}
        return null;
    }
}
````



## （2）工厂方法模式

用来生产同一等级结构中的==固定产品==。每个工厂类只new一个对象（==支持扩展==增加产品，再来一个类实现这个模板工厂接口就行了）

````java
interface Car{
    void run();
}
interface Factory{
    Car create();
}
class B implements Car {
    public void run(){System.out.println("我在开宝马");}
}
class A implements Car {
    public void run(){System.out.println("我在开奥迪");}
}

public class BFactory implements Factory {
    public Car create(){return new B();}
}
public class AFactory implements Factory {
    public Car create(){return new A();}
}
````



## （3）抽象工厂模式

用来生产不同产品簇中的全部产品（支持扩展增加产品簇）

```java
//抽象产品
interface Car{
    void run();
}
interface Engine{
    void run();
}
//抽象工厂
interface Factory{
    Car createCar();
    Engine createEngine();
}
//具体产品
class B implements Car {
    public void run(){System.out.println("我在开宝马");}
}
class A implements Car {
    public void run(){System.out.println("我在开奥迪");}
}
class EngineA implements Engine{
    public void run(){System.out.println("转得快");}
}
class EngineB implements Engine{
    public void run(){System.out.println("转得慢");}
}
//具体工厂
public class BFactory implements Factory {
    public Car createCar(){return new B();}
    public Engine createEngine(){return new EngineB();}
}
public class AFactory implements Factory {
    public Car createCar(){return new A();}
    public Engine createEngine(){return new EngineA();}
}
```



## 2、单例模式

保证一个类只有一个实例，并且提供一个访问该实例的全局访问点

### （1）饿汉式

饿汉式是最简单的单例模式的写法，保证了线程的安全（类初始化的时间实例化），在很长的时间里，我都是饿汉模式来完成单例的，因为够简单，后来才知道饿汉式会有一点小问题，看下面的代码：

```java
public class Hungry {
  private byte[] data1 = new byte[1024];
  private byte[] data2 = new byte[1024];
  private byte[] data3 = new byte[1024];
    
  private final static Hungry hungry = new Hungry();

  private Hungry() {}
    
  public static Hungry getInstance() {
    return hungry;
 }
}
```

如果长时间没有用到`getInstance()`方法，这这个数组的内存就是浪费。我希望的是 只有用到了 `getInstance`方法，才会去初始化单例类，。所以就有了 第二种单例模式：懒汉式。

#### 静态内部类改进

饿汉式的改进版本，同样也是在==类中定义一个静态变量的内部类==，并直接初始化，既**保证了线程的安全性**，同时又**满足懒加载**。

```java
public class Holder {
  private Holder() {}
    
  public static Holder getInstance() {
    return InnerClass.holder;
  }
  private static class InnerClass {
    private static final Holder holder = new Holder();
  }
}
```



### （2）懒汉式

正常的 懒汉式单例：

```java
public class LazyMan {
  private LazyMan() {//无参构造
    System.out.println(Thread.currentThread().getName()+"Start");
 }
  private static LazyMan lazyMan;
    
  public static LazyMan getInstance() {
    if (lazyMan == null) {
      lazyMan = new LazyMan();
   }
    return lazyMan;
 }
    
  // 测试并发环境，发现单例失效
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread( ()->{LazyMan.getInstance();} ).start();
    }
  }
}
```

### （3）DCL懒汉式

```java
public class LazyMan {
  private LazyMan() {}
  private static LazyMan lazyMan;
    
  public static LazyMan getInstance() {
    if (lazyMan == null) {
      synchronized (LazyMan.class) {
        if (lazyMan == null) {
          lazyMan = new LazyMan();
       }
     }
   }
    return lazyMan;
 }
}
```

DCL懒汉式的单例，保证了线程的安全性，又符合了懒加载，只有在用到的时候，才会去初始化，调用效率也比较高，但是这种写法在极端情况还是可能会有一定的问题。因为`lazyMan = new LazyMan();` 创建对象的时候不是原子性操作，至少会经过三个步骤：

1. 分配对象内存空间
2. 执行构造方法初始化对象
3. 设置 instance 指向刚分配的内存地址

==由于指令重排，导致A线程执行 lazyMan = new LazyMan();的时候，可能先执行了第三步（还没执行第二步），此时线程B又进来了，发现lazyMan已经不为空了，直接返回了lazyMan，并且后面使用了返回的lazyMan，由于线程A还没有执行第二步，导致此时lazyMan还不完整，可能会有一些意想不到的错误，所以就有了下面一种单例模式。==

这种单例模式只是在上面DCL单例模式**增加一个==volatile==关键字**来避免指令重排：

```java
public class LazyMan {
  private volatile static LazyMan lazyMan;

  private LazyMan() {}
    
  public static LazyMan getInstance() {
    if (lazyMan == null) {
      synchronized (LazyMan.class) {
        if (lazyMan == null) {
          lazyMan = new LazyMan();
       }
     }
   }
   return lazyMan;
   }
}
```

### （4）万恶的反射

万恶的反射登场了，反射是一个比较霸道的东西，无视private修饰的构造方法，可以直接在外面
newInstance，破坏我们辛辛苦苦写的单例模式。

```java
public static void main(String[] args) {
    LazyMan lazyMan1 = LazyMan.getInstance();
    Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
    
    declaredConstructor.setAccessible(true);
    LazyMan lazyMan2 = declaredConstructor.newInstance();
    System.out.println(lazyMan1.hashCode());
    System.out.println(lazyMan2.hashCode());
    System.out.println(lazyMan1 == lazyMan2);/
}
```

我们分别打印出lazyMan1，lazyMan2的hashcode，lazyMan1是否相等lazyMan2，结果显而易见，==不相等==；

那么，怎么解决这种问题呢？

```java
public class LazyMan {
   private LazyMan() {//空构造
     synchronized (LazyMan.class) {
       if (lazyMan != null) {
         //在私有的构造函数中做一个判断，如果lazyMan不为空，说明lazyMan已经被创建过了
         //如果正常调用getInstance方法，是不会出现这种事情的，所以直接抛出异常！
         throw new RuntimeException("不要试图用反射破坏单例模式");
      }
    }
  }
  private volatile static LazyMan lazyMan;
    
  public static LazyMan getInstance() {
  	if (lazyMan == null) {
      synchronized (LazyMan.class) {
        if (lazyMan == null) {
          lazyMan = new LazyMan();
       }
     }
   }
   return lazyMan;
 }
}
```

但是这种写法还是有问题：

用反射创建对象，私有构造函数里面的判断起作用了，反射破坏单例模式失败。但是如果破坏者干脆不先调用getInstance方法，一上来就直接用反射创建对象，我们的判断就不生效了：

```java
public static void main(String[] args) {
  try {
    Constructor<LazyMan> declaredConstructor =
LazyMan.class.getDeclaredConstructor(null);
    declaredConstructor.setAccessible(true);
    LazyMan lazyMan1 = declaredConstructor.newInstance();
    LazyMan lazyMan2 = declaredConstructor.newInstance();
    System.out.println(lazyMan1.hashCode());
    System.out.println(lazyMan2.hashCode());
 } catch (Exception e) {
    e.printStackTrace();
 }
}
```

那么如何防止这种反射破坏呢？

```java
public class LazyMan {
  private static boolean flag = false; //用来判断有没有进去过
  private volatile static LazyMan lazyMan;

  private LazyMan() {//空构造
    synchronized (LazyMan.class) {
      //第一次进来 就把flag变成false。下次如果flag等于true就说明已经来过了
      //正常的调用是不会第二次跑到私有构造方法的，所以抛出异常。
      if (flag == false) {
        flag = true;
      } else {
        throw new RuntimeException("不要试图用反射破坏单例模式");
      }
   }
 }
    
  public static LazyMan getInstance() {
    if (lazyMan == null) {
      synchronized (LazyMan.class) {
        if (lazyMan == null) {
          lazyMan = new LazyMan();
       }
     }
    }
    return lazyMan;
    }
}
```

看起来很美好，但是还是不能完全防止反射破坏单例模式，因为可以利用反射修改flag的值。

```java
class Demo02{
  public static void main(String[] args) {
    try {
      // 通过反射创建对象
      Constructor<LazyMan> declaredConstructor =
LazyMan.class.getDeclaredConstructor(null);
      Field field = LazyMan.class.getDeclaredField("flag");
      field.setAccessible(true);
      // 通过反射实例化对象
      declaredConstructor.setAccessible(true);
      LazyMan lazyMan1 = declaredConstructor.newInstance();
      System.out.println(field.get(lazyMan1));
      System.out.println(lazyMan1.hashCode());
      //通过反射，修改字段的值！
      field.set(lazyMan1,false);
      LazyMan lazyMan2 = declaredConstructor.newInstance();
      System.out.println(field.get(lazyMan2));
      System.out.println(lazyMan2.hashCode());
   } catch (Exception e) {
      e.printStackTrace();
   }
 }
}
```

并没有一个很好的方案去避免反射破坏单例模式，所以轮到我们的枚举登场了。

## 3.5、枚举

枚举类型是Java5 中新增特性的一部分，它是一种特殊的数据类型，之所以特殊是因为它既是一种类
(class)类型却又比类类型多了些特殊的约束，但是这些约束的存在也造就了枚举类型的简洁性、安全性
以及便捷性。

```java
public enum EnumSingleton {
  INSTANCE;
  public EnumSingleton getInstance(){
    return INSTANCE;
 }
}
class Demo04{
  public static void main(String[] args) {
    EnumSingleton singleton1=EnumSingleton.INSTANCE;
    EnumSingleton singleton2=EnumSingleton.INSTANCE;
    System.out.println("正常情况下，实例化两个实例是否相同："+
	(singleton1==singleton2));
  }
}
```

枚举是目前最推荐的单例模式的写法

- 编写简单
- 保证线程的安全
- 有效的防止反射破坏单例模式

我们可以看下newInstance的源码，反编译查看下枚举的源码：

```java
javap -p EnumSingleton.class
Compiled from "EnumSingleton.java"
public final class 单例模式.EnumSingleton extends java.lang.Enum<单例模式.EnumSingleton> {
    public static final 单例模式.EnumSingleton INSTANCE;
    private static final 单例模式.EnumSingleton[] $VALUES;
    public static 单例模式.EnumSingleton[] values();
    public static 单例模式.EnumSingleton valueOf(java.lang.String);
    private 单例模式.EnumSingleton();
    public 单例模式.EnumSingleton getInstance();
    static {};
}
```

这个看的不清楚，我们可以下 jad 进行反编译，我们的素材中也都有！

```bash
jad -sjava EnumSingleton.class
# 会生成一个java文件
Parsing EnumSingleton.class... Generating EnumSingleton.java
```

我们点开里面的源码

````java
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:  EnumSingleton.java
package 53554F8B6A215F0F;
public final class EnumSingleton extends Enum
{
  public static EnumSingleton[] values()
 {
    return (EnumSingleton[])$VALUES.clone();
 }
  public static EnumSingleton valueOf(String name)
 {
    return (EnumSingleton)Enum.valueOf(53554F8B6A215F0F/EnumSingleton,
name);
 }
  private EnumSingleton(String s, int i)
 {
      super(s, i);
 }
  public EnumSingleton getInstance()
 {
    return INSTANCE;
 }
  public static final EnumSingleton INSTANCE;
  private static final EnumSingleton $VALUES[];
  static
 {
    INSTANCE = new EnumSingleton("INSTANCE", 0);
    $VALUES = (new EnumSingleton[] {
      INSTANCE
   });
 }
}
````

再次尝试破坏看一下！

```java
package 单例模式;
import java.lang.reflect.Constructor;
public enum EnumSingleton {
  INSTANCE;
  public EnumSingleton getInstance(){
    return INSTANCE;
 }
}
class Demo04{
  public static void main(String[] args) throws Exception {
    EnumSingleton singleton1=EnumSingleton.INSTANCE;
    EnumSingleton singleton2=EnumSingleton.INSTANCE;
    System.out.println("正常情况下，实例化两个实例是否相同："+
(singleton1==singleton2));
    //Constructor<EnumSingleton> constructor =
EnumSingleton.class.getDeclaredConstructor(); //自身的类没有无参构造方法
    Constructor<EnumSingleton> constructor =
EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
    constructor.setAccessible(true);
    EnumSingleton enumSingleton = constructor.newInstance();
 }
}
```

试图破坏，真的破坏不了！



# 4、生产者消费者模式

1. 用 synchronized 加锁，然后使用 object 原生的 wait() 和 notify() 做同步 
2. 用 Lock 加锁，然后用 condition 的 await() 和 signal() 做同步 
3. 直接使用 concurrent.BlockingQueue
4. 使用 PipedInputStream/PipedOutputStream
5. 使用信号量 semaphore

使用wait和notify/notifyAll来实现：

```java
import java.util.LinkedList;

public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;//最多10个元素
    private int count = 0;

    /**问题1：
     * 为什么下面对缓冲池的判断使用的是while而不是if?
     * 当缓冲池已满的话，再有生产者线程运行，线程就会陷入等待
     * 举个栗子，假设当前缓冲池满，生产者线程A,B陆续运行
     *如果是使用if的话：
     * A,B线程进入if方法体里，调用wait，统统陷入等待
     * 等到有一个消费者在结束时进行唤醒，此时A,B均被唤醒，那么他们此时都不会在进行缓冲池是否满的判断了，他们都会直接到if语句的下一句继续运行
     * 假设A先拿到锁，执行add操作，然后在结束时继续唤醒，当B拿到锁后，也是直接进行add操作，没有去判断此时缓冲池的情况，这样就会出问题
     * 如果是使用while的话
     * 在线程每次醒来后，都先去检查缓冲池的情况，若符合要求，才进行下一步操作，若不符合要求，还会继续等待
     *
     */
    public synchronized void put(T t) {
        while (lists.size() == MAX) {//想想这里为什么使用while而不是if？
            try {
                this.wait();//wait()大多数情况下都和while()在一起
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();//前面生产了，通知所有消费者线程进行消费
    }

    /**问题2：
     * 为什么最后调用的是notifyAll()而不是notify()?
     * 因为在该对象上等待的可能不仅有消费者，还有生产者，若随机叫醒的一个又是生产者的话，
     * 若此时缓冲池已满，生产者就陷入等待，消费者便永远也不会被唤醒，整个程序陷入死锁
     * 所以优先使用notifyAll()
     *
     */

    public synchronized T get() {
        T t = null;
        while (lists.size() == 0) {//想想这里为什么使用while而不是if
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t=lists.removeFirst();
        --count;
        this.notifyAll();//前面消费了，通知所有生产者线程进行生产
        return t;
    }


}
```

使用Lock和Condition来实现：

```java
package ThreadLearn.A005_Q;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;//最多10个元素
    private int count = 0;

    private Lock lock=new ReentrantLock();
    private Condition producer =lock.newCondition();
    private Condition consumer =lock.newCondition();
    public  void put(T t) {
            try {
                lock.lock();
                while(lists.size()==MAX){
                    producer.await();
                }
                lists.add(t);
                ++count;
                consumer.signalAll();//通知所有消费者线程进行消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }

    public synchronized T get() {
        T t = null;
            try {
                lock.lock();
                while(lists.size()==0){
                    consumer.await();
                }
                t=lists.removeFirst();
                --count;
                producer.signalAll();//通知生产者进行生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c=new MyContainer2<>();
        //启动消费者线程
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for(int j=0;j<5;j++) System.out.println(c.get());
            },"c"+i).start();
        }
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //启动生产者者线程
        for (int i = 0; i <2; i++) {
            new Thread(()->{
                for(int j=0;j<25;j++) c.put(Thread.currentThread().getName()+" "+ j);
            },"p"+i).start();
        }

    }
}
```

对比两种方式可以看出，Condition的方式可以更加精确的指定哪些线程被唤醒。

