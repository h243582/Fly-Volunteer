package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.LevelsMapper;
import com.heyufei.school.pojo.DepartmentType;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.Levels;
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
public class LevelsService {
    @Resource
    LevelsMapper levelsMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Levels> findAll() {
        List<Levels> levelsList = (List<Levels>) redisTemplate.opsForValue().get("levelsList");

        if (levelsList == null) {
            levelsList = levelsMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("levelsList",levelsList);
            redisTemplate.boundValueOps("levelsList").append(String.valueOf(levelsList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("levelsList", levelsList, 30, TimeUnit.DAYS);
        }
        return levelsList;
    }

    public Levels findById(String id) {
        return levelsMapper.selectById(id);
    }

    public List<Levels> findSearch(Map<String, Object> map) {
        return levelsMapper.selectByMap(map);
    }
    public IPage<Levels> findAllLimit(int currentPage, int pageSize){
        IPage<Levels> levelsPage = new Page<>(currentPage,pageSize);
        levelsPage = levelsMapper.selectPage(levelsPage,null);
        return levelsPage;
    }
    public int add(Levels levels) {
        redisTemplate.delete("levelsList"); //删除缓存
        Map<String, Object> map = new HashMap<>();
        map.put("name", levels.getName());
        if ((findSearch(map).size()) <= 0) {
            levels.setId(idWorker.nextId() + "");
            return levelsMapper.insert(levels);
        } else {
            return 0;
        }
    }

    public int update(Levels levels) {
        redisTemplate.delete("levelsList"); //删除缓存
        return levelsMapper.updateById(levels);
    }

    public void deleteById(String id) {
        redisTemplate.delete("levelsList"); //删除缓存
        levelsMapper.deleteById(id);
    }

}
