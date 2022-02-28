package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.TypeMapper;
import com.heyufei.school.pojo.Province;
import com.heyufei.school.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeService {
    @Resource
    TypeMapper typeMapper;
    @Autowired
    private IdWorker idWorker;

    public List<Type> findAll(){
        return typeMapper.selectList(null);
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
       return typeMapper.updateById(type);
    }

    public void deleteById(String id){
        typeMapper.deleteById(id);
    }

}
