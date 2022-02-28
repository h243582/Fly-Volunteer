package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.ProvinceMapper;
import com.heyufei.school.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProvinceService {
    @Resource
    ProvinceMapper provinceMapper;
    @Autowired
    private IdWorker idWorker;


    public List<Province> findAll() {
        return provinceMapper.selectList(null);
    }

    public Province findById(String id) {
        return provinceMapper.selectById(id);
    }

    public List<Province> findSearch(Map<String, Object> map) {
        return provinceMapper.selectByMap(map);
    }
    public IPage<Province> findAllLimit(int currentPage, int pageSize){
        IPage<Province> provinceIPage = new Page<>(currentPage,pageSize);
        provinceIPage = provinceMapper.selectPage(provinceIPage,null);
        return provinceIPage;
    }
    public int add(Province province) {
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
        return provinceMapper.updateById(province);
    }

    public void deleteById(String id) {
        provinceMapper.deleteById(id);
    }

}
