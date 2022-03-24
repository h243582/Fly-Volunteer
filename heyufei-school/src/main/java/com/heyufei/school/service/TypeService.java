package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.TypeMapper;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.Province;
import com.heyufei.school.pojo.Type;
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
public class TypeService {
    @Resource
    TypeMapper typeMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Type> findAll(){
        List<Type> typeList = (List<Type>) redisTemplate.opsForValue().get("typeList");

        if (typeList == null) {
            typeList = typeMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("typeList",typeList);
            redisTemplate.boundValueOps("typeList").append(String.valueOf(typeList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("typeList", typeList, 30, TimeUnit.DAYS);
        }
        return typeList;
    }

    public Type findById(String id){
        return typeMapper.selectById(id);
    }

    public List<Type> findSearch(Map<String, Object> map) {
        return typeMapper.selectByMap(map);
    }

    public IPage<Type> findAllLimit(int currentPage, int pageSize){
        IPage<Type> typeIPage = new Page<>(currentPage,pageSize);
        typeIPage = typeMapper.selectPage(typeIPage,null);
            return typeIPage;
    }

    public int add(Type type){
        redisTemplate.delete("typeList"); //删除缓存

        Map<String, Object> map = new HashMap<>();
        map.put("name", type.getName());
        if ((findSearch(map).size()) <= 0) {
            type.setId(idWorker.nextId() + "");
            return typeMapper.insert(type);
        }else {
            return 0;
        }

    }

    public int update(Type type){
        redisTemplate.delete("typeList"); //删除缓存
       return typeMapper.updateById(type);
    }

    public void deleteById(String id){
        redisTemplate.delete("typeList"); //删除缓存
        typeMapper.deleteById(id);
    }

}
