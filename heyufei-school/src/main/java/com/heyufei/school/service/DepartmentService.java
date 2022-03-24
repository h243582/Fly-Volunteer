package com.heyufei.school.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heyufei.school.mapper.DepartmentMapper;
import com.heyufei.school.pojo.Department;
import com.heyufei.school.pojo.School;
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
public class DepartmentService {
    @Resource
    DepartmentMapper departmentMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Department> findAll() {
        List<Department> departmentList = (List<Department>) redisTemplate.opsForValue().get("departmentList");

        if (departmentList == null) {
            departmentList = departmentMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("departmentList",departmentList);
            redisTemplate.boundValueOps("departmentList").append(String.valueOf(departmentList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("departmentList", departmentList, 30, TimeUnit.DAYS);
        }
        return departmentList;
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
        redisTemplate.delete("departmentList"); //删除缓存

        department.setId(idWorker.nextId() + "");
        return departmentMapper.insert(department);
    }

    public int update(Department department) {
        redisTemplate.delete("departmentList"); //删除缓存
        return departmentMapper.updateById(department);
    }

    public void deleteById(String id) {
        redisTemplate.delete("departmentList"); //删除缓存
        departmentMapper.deleteById(id);
    }

}
