package com.heyufei.school.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyufei.school.mapper.SchoolInformationMapper;
import com.heyufei.school.pojo.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Transactional
@Service
public class SchoolInformationService {
    @Resource
    SchoolInformationMapper schoolInformationMapper;
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<SchoolInformation> findAll(){
        return schoolInformationMapper.selectList(null);
    }

    public SchoolInformation findById(String id){
        SchoolInformation information = (SchoolInformation) redisTemplate.opsForValue().get("schoolInformation_"+id);

        if (information == null){
            information = schoolInformationMapper.selectById(id);//从数据库中查询
//            redisTemplate.opsForValue().set("schoolInformation_"+id,information);
            redisTemplate.boundValueOps("schoolInformation_"+id).append(String.valueOf(information));//存入缓存中
            //设置缓存过期时间
            redisTemplate.opsForValue().set("schoolInformation_" + id, information,30, TimeUnit.DAYS);
        }

        return information;
    }

    public List<SchoolInformation> findSearch(Map<String, Object> map) {
        return schoolInformationMapper.selectByMap(map);
    }

    public IPage<SchoolInformation> findAllLimit(int currentPage, int pageSize){
        IPage<SchoolInformation> informationIPage = new Page<>(currentPage,pageSize);
        informationIPage = schoolInformationMapper.selectPage(informationIPage,null);
            return informationIPage;
    }

    public int add(SchoolInformation information){
        return schoolInformationMapper.insert(information);
    }

    public int update(SchoolInformation information){
        redisTemplate.delete("schoolInformation_"+information.getId());//删除缓存

        return schoolInformationMapper.updateById(information);
    }

    public void deleteById(String id){
        redisTemplate.delete("schoolInformation_"+id);//删除缓存
        schoolInformationMapper.deleteById(id);
    }

}
