package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.ProvinceMapper;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Transactional
@Service
public class ProvinceService {
    @Resource
    ProvinceMapper provinceMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Province> findAll() {
        List<Province> provinceList = (List<Province>) redisTemplate.opsForValue().get("provinceList");

        if (provinceList == null) {
            provinceList = provinceMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("provinceList",provinceList);
            redisTemplate.boundValueOps("provinceList").append(String.valueOf(provinceList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("provinceList", provinceList, 30, TimeUnit.DAYS);
        }
        return provinceList;
    }

    public Province findById(String id) {
        return provinceMapper.selectById(id);
    }

    public List<Province> findSearch(Map<String, Object> map) {
        return provinceMapper.selectByMap(map);
    }

    public IPage<Province> findAllLimit(int currentPage, int pageSize) {
        IPage<Province> provinceIPage = new Page<>(currentPage, pageSize);
        provinceIPage = provinceMapper.selectPage(provinceIPage, null);
        return provinceIPage;
    }

    public int add(Province province) {
        redisTemplate.delete("provinceList"); //删除缓存
        Map<String, Object> map = new HashMap<>();
        map.put("name", province.getName());
        if ((findSearch(map).size()) <= 0) {
            province.setId(idWorker.nextId() + "");
            return provinceMapper.insert(province);
        } else {
            return 0;
        }
    }

    public int update(Province province) {
        redisTemplate.delete("provinceList"); //删除缓存
        return provinceMapper.updateById(province);
    }

    public void deleteById(String id) {
        redisTemplate.delete("provinceList"); //删除缓存
        provinceMapper.deleteById(id);
    }

}
