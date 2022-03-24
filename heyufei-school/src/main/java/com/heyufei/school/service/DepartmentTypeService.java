package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.DepartmentTypeMapper;
import com.heyufei.school.pojo.Department;
import com.heyufei.school.pojo.DepartmentType;
import com.heyufei.school.pojo.DepartmentType;
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
public class DepartmentTypeService {

    @Resource
    DepartmentTypeMapper departmentTypeMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<DepartmentType> findAll() {
        List<DepartmentType> departmentList = (List<DepartmentType>) redisTemplate.opsForValue().get("departmentList");

        if (departmentList == null) {
            departmentList = departmentTypeMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("departmentList",departmentList);
            redisTemplate.boundValueOps("departmentList").append(String.valueOf(departmentList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("departmentList", departmentList, 30, TimeUnit.DAYS);
        }
        return departmentList;
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
        redisTemplate.delete("departmentList"); //删除缓存

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
        redisTemplate.delete("departmentList"); //删除缓存
        return departmentTypeMapper.updateById(departmentType);
    }

    public void deleteById(String id) {
        redisTemplate.delete("departmentList"); //删除缓存
        departmentTypeMapper.deleteById(id);
    }

}
