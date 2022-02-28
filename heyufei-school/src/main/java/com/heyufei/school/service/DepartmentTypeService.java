package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.DepartmentTypeMapper;
import com.heyufei.school.pojo.DepartmentType;
import com.heyufei.school.pojo.DepartmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentTypeService {
    @Resource
    DepartmentTypeMapper departmentTypeMapper;
    @Autowired
    private IdWorker idWorker;


    public List<DepartmentType> findAll() {
        return departmentTypeMapper.selectList(null);
    }

    public DepartmentType findById(String id) {
        return departmentTypeMapper.selectById(id);
    }

    public List<DepartmentType> findSearch(Map<String, Object> map) {
        return departmentTypeMapper.selectByMap(map);
    }
    public IPage<DepartmentType> findAllLimit(int currentPage, int pageSize){
        IPage<DepartmentType> departmentTypePage = new Page<>(currentPage,pageSize);
        departmentTypePage = departmentTypeMapper.selectPage(departmentTypePage,null);
        return departmentTypePage;
    }
    public int add(DepartmentType departmentType) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", departmentType.getName());
        if ((findSearch(map).size()) <= 0) {
            departmentType.setId(idWorker.nextId() + "");
            return departmentTypeMapper.insert(departmentType);
        } else {
            return 0;
        }
    }

    public int update(DepartmentType departmentType) {
        return departmentTypeMapper.updateById(departmentType);
    }

    public void deleteById(String id) {
        departmentTypeMapper.deleteById(id);
    }

}
