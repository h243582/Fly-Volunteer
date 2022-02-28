package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.LevelsMapper;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.Levels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LevelsService {
    @Resource
    LevelsMapper levelsMapper;
    @Autowired
    private IdWorker idWorker;


    public List<Levels> findAll() {
        return levelsMapper.selectList(null);
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
        return levelsMapper.updateById(levels);
    }

    public void deleteById(String id) {
        levelsMapper.deleteById(id);
    }

}
