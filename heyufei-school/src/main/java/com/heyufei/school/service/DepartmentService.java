package com.heyufei.school.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heyufei.school.mapper.DepartmentMapper;
import com.heyufei.school.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;
    @Autowired
    private IdWorker idWorker;


    public List<Department> findAll() {
        return departmentMapper.selectList(null);
    }

    public Department findById(String id) {
        return departmentMapper.selectById(id);
    }

    public List<Department> findSearch(Map<String, Object> map) {
        return departmentMapper.selectByMap(map);
    }

    public IPage<Department> findAllLimit(int currentPage, int pageSize){
        IPage<Department> departmentIPage = new Page<>(currentPage,pageSize);
        departmentIPage = departmentMapper.selectPage(departmentIPage,null);
        return departmentIPage;
    }
    public int add(Department department) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", department.getName());
        if ((findSearch(map).size()) <= 0) {
            department.setId(idWorker.nextId() + "");
            return departmentMapper.insert(department);
        } else {
            return 0;
        }
    }

    public int update(Department department) {
        return departmentMapper.updateById(department);
    }

    public void deleteById(String id) {
        departmentMapper.deleteById(id);
    }

}
