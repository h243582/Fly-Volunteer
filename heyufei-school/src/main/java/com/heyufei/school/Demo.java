package com.heyufei.school;

import com.heyufei.school.mapper.SchoolMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.IdWorker;

@SpringBootTest
public class Demo {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;


    @Test
    public void contextLoads() {
//        System.out.println(schoolMapper.findAll(null,null));

    }
}
