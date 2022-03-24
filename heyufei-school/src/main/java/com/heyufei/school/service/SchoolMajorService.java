package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.SchoolMajorMapper;
import com.heyufei.school.pojo.Levels;
import com.heyufei.school.pojo.SchoolInformation;
import com.heyufei.school.pojo.SchoolMajor;
import com.heyufei.school.pojo.dto.SchoolMajorDto;
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
public class SchoolMajorService {
    @Resource
    SchoolMajorMapper schoolMajorMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<SchoolMajor> findAll(){
        List<SchoolMajor> schoolMajorList = (List<SchoolMajor>) redisTemplate.opsForValue().get("schoolMajorList");

        if (schoolMajorList == null) {
            schoolMajorList = schoolMajorMapper.selectList(null);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolMajorList",schoolMajorList);
            redisTemplate.boundValueOps("schoolMajorList").append(String.valueOf(schoolMajorList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolMajorList", schoolMajorList, 30, TimeUnit.DAYS);
        }
        return schoolMajorList;
    }



    public List<SchoolMajor> findSearch(Map<String, Object> map) {
        return schoolMajorMapper.selectByMap(map);
    }

    public IPage<SchoolMajor> findAllLimit(int currentPage, int pageSize){
        IPage<SchoolMajor> schoolMajorIPage = new Page<>(currentPage,pageSize);
        schoolMajorIPage = schoolMajorMapper.selectPage(schoolMajorIPage,null);
            return schoolMajorIPage;
    }

    public int add(SchoolMajor schoolMajor){
        redisTemplate.delete("schoolMajorList"); //删除缓存
        redisTemplate.delete("schoolMajorDtoList_"+schoolMajor.getTbSchoolId()); //删除缓存
        return schoolMajorMapper.insert(schoolMajor);
    }

    public int update(SchoolMajor schoolMajor){
        redisTemplate.delete("schoolMajorList"); //删除缓存
        redisTemplate.delete("schoolMajorDtoList_"+schoolMajor.getTbSchoolId()); //删除缓存
        return schoolMajorMapper.updateById(schoolMajor);
    }

    public void deleteById(String id){
        redisTemplate.delete("schoolMajorList"); //删除缓存
        redisTemplate.delete("schoolMajorDtoList_"+id); //删除缓存
        schoolMajorMapper.deleteById(id);
    }



    public List<SchoolMajorDto> findByIdDescComprehensiveSatisfaction(String id){
        List<SchoolMajorDto> schoolMajorDtoList = (List<SchoolMajorDto>) redisTemplate.opsForValue().get("schoolMajorComprehensiveSatisfactionList_"+id);

        if (schoolMajorDtoList == null) {
            schoolMajorDtoList = schoolMajorMapper.findByIdDescComprehensiveSatisfaction(id);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolMajorList",schoolMajorList);
            redisTemplate.boundValueOps("schoolMajorComprehensiveSatisfactionList_"+id).append(String.valueOf(schoolMajorDtoList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolMajorComprehensiveSatisfactionList_"+id, schoolMajorDtoList, 30, TimeUnit.DAYS);
        }
        return schoolMajorDtoList;
    }

    public List<SchoolMajorDto> findByIdDescRecommendSatisfaction(String id){
        List<SchoolMajorDto> schoolMajorDtoList = (List<SchoolMajorDto>) redisTemplate.opsForValue().get("schoolMajorRecommendSatisfactionList_"+id);

        if (schoolMajorDtoList == null) {
            schoolMajorDtoList = schoolMajorMapper.findByIdDescRecommendSatisfaction(id);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolMajorList",schoolMajorList);
            redisTemplate.boundValueOps("schoolMajorRecommendSatisfactionList_"+id).append(String.valueOf(schoolMajorDtoList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolMajorRecommendSatisfactionList_"+id, schoolMajorDtoList, 30, TimeUnit.DAYS);
        }
        return schoolMajorDtoList;
    }

    public List<SchoolMajorDto> findByIdDescRecommendNumber(String id){
        List<SchoolMajorDto> schoolMajorDtoList = (List<SchoolMajorDto>) redisTemplate.opsForValue().get("schoolMajorRecommendNumberList_"+id);

        if (schoolMajorDtoList == null) {
            schoolMajorDtoList = schoolMajorMapper.findByIdDescRecommendNumber(id);//从数据库中查询

//            redisTemplate.opsForValue().set("schoolMajorList",schoolMajorList);
            redisTemplate.boundValueOps("schoolMajorRecommendNumberList_"+id).append(String.valueOf(schoolMajorDtoList));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolMajorRecommendNumberList_"+id, schoolMajorDtoList, 30, TimeUnit.DAYS);
        }
        return schoolMajorDtoList;
    }
}
