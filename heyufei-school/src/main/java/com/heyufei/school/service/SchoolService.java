package com.heyufei.school.service;

import java.util.List;
import java.util.Map;


import com.heyufei.school.mapper.SchoolMapper;
import com.heyufei.school.pojo.School;
import com.heyufei.school.pojo.dto.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.IdWorker;

import javax.annotation.Resource;


@Service
public class SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部列表
     */
    public List<School> findAll() {
        return schoolMapper.selectList(null);
    }

    /**
     * 条件查询
     */
    public List<SchoolDto> findSearch(Map<String, Object> map) {
        return schoolMapper.findSearch(map);
    }

    /**
     * 条件查询出的数量
     */
    public Long findCount(Map<String, Object> map) {
        return schoolMapper.findCount(map);
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
        school.setId(idWorker.nextId() + "");
        return schoolMapper.insert(school);
    }

    /**
     * 修改
     */
    public void update(School school) {
        schoolMapper.updateById(school);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        schoolMapper.deleteById(id);
    }


}
