# 一、SpringCloud版本

==版本一定要对上，不然就会报错==

![](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/7.2.png)

`springBoot：2.0.1.RELEASE`  ==----==  `SpringCloud： Finchley.M9`

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.1.RELEASE</version>
    <relativePath/>
</parent>


<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.M9</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

# 二、Eureka注册中心

==用来把 服务们 注册到 注册中心==，实现SpringCloud的服务发现功能。

Eureka包含两个组件：Eureka **Server**和Eureka **Client**。

## 1、Eureka **Server**

```xml
<dependency>
	<!--  客户端 -->
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-Server</artifactId>
</dependency>
```

```yml
server:
	port: 6868 #服务端口
eureka:
	client:
		registerWithEureka: false #是否将自己注册到Eureka服务中，本身就是所有无需注册
		fetchRegistry: false #是否从Eureka中获取注册信息
		serviceUrl: 		
			defaultZone: http://127.0.0.1:${server.port}/eureka/ #Eureka客户端与Eureka服务端进行交互的地址
```

```java
@SpringBootApplication
@EnableEurekaServer //客户端开启
public class EurekaServer {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
	}
}
```



各个服务启动后，会在Eureka Server中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。

<img src="https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/image-20211017192717068.png" alt="image-20211017192717068"  style="border: 1px solid red"/>



## 2、Eureka **Client**

```xml
<dependency>
	<!--  客户端 -->
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

```yml
server:
  port: 8091 #端口号
eureka:
  client:
    service-url:
      defaultZone: http://127.0.0.1:6868/eureka/ #服务器地址
  instance:
    prefer-ip-address: true  #能否跨服务器访问（就是说访问另一个服务）
```

```java
@SpringBootApplication
@EnableEurekaServer //服务端开启
public class EurekaServer {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
	}
}
```

Client是一个java客户端，用于简化与Eureka Server的交互，客户端同时也就别一个内置的、使用轮询(round-robin)负载算法的负载均衡器。

在应用启动后，将会向Server发送心跳,默认周期为30秒，如果Server在多个心跳周期内没有接收到某个节点的心跳，Server将会从服务注册表中把这个服务节点移除(默认90秒)。

Server之间通过复制的方式完成数据的同步，Eureka还提供了客户端缓存机制，即使所有的Eureka Server都挂掉，客户端依然可以利用缓存中的信息消费其他服务的API。综上，Eureka通过心跳检查、客户端缓存等机制，确保了系统的高可用性、灵活性和可伸缩性。

## 3、保护模式

​	如果在Eureka Server的首页看到以下这段提示，则说明Eureka已经进入了保护模式：

![](https://heyufei-1305336662.cos.ap-shanghai.myqcloud.com/my_img/7.5.png)

Eureka Server在运行期间，会统计心跳失败的比例在15分钟之内是否低于85%，如果出现低于的情况（在单机调试的时候很容易满足，实际在生产环境上通常是由于网络不稳定导致）】，Eureka Server会将当前的实例注册信息保护起来，同时提示这个警告。

保护模式主要用于一组客户端和Eureka Server之间存在网络分区场景下的保护。

一旦进入保护模式，Eureka Server将会尝试保护其服务注册表中的信息，不再删除服务注册表中的数据（也就是不会注销任何微服务）。

# 三、Feign实现**服务间**调用

## 