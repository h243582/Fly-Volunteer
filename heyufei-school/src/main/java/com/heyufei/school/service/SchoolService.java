package com.heyufei.school.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import com.heyufei.school.mapper.SchoolMapper;
import com.heyufei.school.pojo.School;
import com.heyufei.school.pojo.dto.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;

@Service
public class SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部列表
     */
    public List<School> findAll() {
        List<School> schoolList = (List<School>) redisTemplate.opsForValue().get("schoolList");

        if (schoolList == null) {
            schoolList = schoolMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolList",schoolList);
            redisTemplate.boundValueOps("schoolList").append(String.valueOf(schoolList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolList", schoolList, 30, TimeUnit.DAYS);
        }

        return schoolList;
    }

    /**
     * 条件查询
     */
    public List<SchoolDto> findSearch(Map<String, Object> map) {
        List<SchoolDto> schoolDtoList = (List<SchoolDto>) redisTemplate.opsForValue().get("schoolDtoList");

        if (schoolDtoList == null) {
            schoolDtoList = schoolMapper.findSearch(map);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolList",schoolList);
            redisTemplate.boundValueOps("schoolDtoList").append(String.valueOf(schoolDtoList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolDtoList", schoolDtoList, 30, TimeUnit.DAYS);
        }

        return schoolDtoList;
    }

    /**
     * 条件查询出的数量
     */
    public Long findCount(Map<String, Object> map) {
        System.out.println(redisTemplate.opsForValue().get("schoolLength"));
        Long schoolLength = (Long) redisTemplate.opsForValue().get("schoolLength");

        if (schoolLength == null) {
            schoolLength = schoolMapper.findCount(map);//从数据库中查询
            System.out.println(schoolLength);

//            redisTemplate.opsForValue().set("schoolList",schoolList);
            redisTemplate.boundValueOps("schoolLength").append(String.valueOf(schoolLength));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolLength", schoolLength, 30, TimeUnit.DAYS);
        }

        return schoolLength;
    }


    /**
     * 根据ID查询实体
     */
    public School findById(String id) {
        return schoolMapper.selectById(id);
    }

    /**
     * 增加
     */
    public int add(School school) {
        redisTemplate.delete("schoolDtoList"); //删除缓存
        redisTemplate.delete("schoolList"); //删除缓存
        redisTemplate.delete("schoolLength"); //删除缓存

        school.setId(idWorker.nextId() + "");
        return schoolMapper.insert(school);
    }

    /**
     * 修改
     */
    public void update(School school) {
        redisTemplate.delete("schoolDtoList"); //删除缓存
        redisTemplate.delete("schoolList"); //删除缓存
        schoolMapper.updateById(school);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        redisTemplate.delete("schoolDtoList"); //删除缓存
        redisTemplate.delete("schoolList"); //删除缓存
        redisTemplate.delete("schoolLength"); //删除缓存

        schoolMapper.deleteById(id);
    }
}
