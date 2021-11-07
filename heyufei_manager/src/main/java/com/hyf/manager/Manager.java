package com.hyf.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import util.JwtUtil;

@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
@EnableZuulProxy
@SpringBootApplication
public class Manager {
    public static void main(String[] args) {
        SpringApplication.run(Manager.class, args);
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
