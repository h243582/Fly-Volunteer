package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.MajorMapper;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.Major;
import com.heyufei.school.pojo.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Transactional
@Service
public class MajorService {
    @Resource
    MajorMapper majorMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Major> findAll() {
        List<Major> majorList = (List<Major>) redisTemplate.opsForValue().get("majorList");

        if (majorList == null) {
            majorList = majorMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("majorList",majorList);
            redisTemplate.boundValueOps("majorList").append(String.valueOf(majorList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("majorList", majorList, 30, TimeUnit.DAYS);
        }
        return majorList;
    }

    public Major findById(String id) {
        Major major = (Major) redisTemplate.opsForValue().get("major_" + id);

        if (major == null) {
            major = majorMapper.selectById(id);//从数据库中查询
//            redisTemplate.opsForValue().set("schoolInformation_"+id,information);
            redisTemplate.boundValueOps("major_" + id).append(String.valueOf(major));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("major_" + id, major, 30, TimeUnit.DAYS);
        }

        return major;
    }

    public List<Major> findSearch(Map<String, Object> map) {
        List<Major> majorList = (List<Major>) redisTemplate.opsForValue().get("majorSearchList");

        if (majorList == null) {
            majorList = majorMapper.selectByMap(map);//从数据库中查询

//            redisTemplate.opsForValue().set("majorList",majorList);
            redisTemplate.boundValueOps("majorSearchList").append(String.valueOf(majorList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("majorSearchList", majorList, 30, TimeUnit.DAYS);
        }
        return majorList;
    }

    public IPage<Major> findAllLimit(int currentPage, int pageSize) {
        IPage<Major> majorIPage = (IPage<Major>) redisTemplate.opsForValue().get("majorLimitList");

        if (majorIPage == null) {
            majorIPage = new Page<>(currentPage, pageSize);
            majorIPage = majorMapper.selectPage(majorIPage, null);

//            redisTemplate.opsForValue().set("majorList",majorList);
            redisTemplate.boundValueOps("majorLimitList").append(String.valueOf(majorIPage));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("majorLimitList", majorIPage, 30, TimeUnit.DAYS);
        }
        return majorIPage;
    }

    public int add(Major major) {
        redisTemplate.delete("majorList"); //删除缓存
        redisTemplate.delete("majorSearchList"); //删除缓存
        redisTemplate.delete("majorLimitList"); //删除缓存
        return majorMapper.insert(major);
    }

    public int update(Major major) {
        redisTemplate.delete("majorList"); //删除缓存
        redisTemplate.delete("majorSearchList"); //删除缓存
        redisTemplate.delete("majorLimitList"); //删除缓存
        redisTemplate.delete("major_" + major.getId());//删除缓存
        return majorMapper.updateById(major);
    }

    public void deleteById(String id) {
        redisTemplate.delete("majorList"); //删除缓存
        redisTemplate.delete("majorSearchList"); //删除缓存
        redisTemplate.delete("majorLimitList"); //删除缓存
        redisTemplate.delete("major_" + id);//删除缓存
        majorMapper.deleteById(id);
    }

}
