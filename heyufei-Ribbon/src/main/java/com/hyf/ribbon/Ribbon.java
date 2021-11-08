package com.hyf.ribbon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Ribbon {

    /**
     * RestTemplate 是由 Spring Web 模块提供的工具类，与 SpringCloud 无关，是独立存在的
     * SpringCloud 对 RestTemplate 进行了一定的扩展，所以 RestTemplate 具备了负载均衡的功能  ,默认轮训
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ribbon.class, args);
    }
}