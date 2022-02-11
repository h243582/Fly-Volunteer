package com.heyufei.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.concurrent.TimeUnit;


@SpringBootTest
public class demo {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void contextLoads() {
        BoundValueOperations<String, String> str1 = redisTemplate.boundValueOps("str");

        //添加键值
        str1.set("何昱飞飞");
        //获取键值
        String string = str1.get();
        System.out.println(string);

    }

    @Test
    public void contextLoad2() {

        redisTemplate.opsForValue().set("email_code_" + "243582@qq.com", "888446" + "", 3, TimeUnit.MINUTES);//1分钟过期


    }


}