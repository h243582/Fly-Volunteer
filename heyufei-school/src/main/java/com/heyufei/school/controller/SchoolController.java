package com.heyufei.school.controller;

import java.util.Map;

import com.heyufei.school.mapper.SchoolMapper;
import com.heyufei.school.pojo.School;
import com.heyufei.school.pojo.dto.SchoolDto;
import com.heyufei.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import entity.PageResult;
import entity.Result;
import entity.StatusCode;

import javax.annotation.Resource;


@RestController
@CrossOrigin
@RequestMapping("/school")
public class SchoolController {

    @Resource
    private SchoolMapper schoolMapper;

    @Autowired
    private SchoolService schoolService;


    /**
     * 查询全部数据
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", schoolService.findAll());
    }

    /**
     * 查询全部列表并且连表 条件查询
      "currentPage":0,
      "pageSize":100,
      "schoolName": "北京大学",
      "provinceId": "1",
      "departmentId": "20",
      "typeId": "2",
      "levelsId": "3",
      "topUniversity": false,
      "topDiscipline": false,
      "graduateSchool": false,
      "satisfaction": 4.0
     */
    @RequestMapping(value = "/findSearch", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map<String, Object> map) {
        try{
            map.put("currentPage", ((Integer) (map.get("currentPage")) - 1)*(Integer) (map.get("pageSize")));
        }catch (Exception ignored){};

        return new Result(true, StatusCode.OK, "查询成功",new PageResult<SchoolDto>( schoolService.findCount(map),schoolService.findSearch(map) ) );
    }



    @RequestMapping(value = "/findCount", method = RequestMethod.POST)
    public Result findCount(@RequestBody Map<String, Object> map) {
        return new Result(true, StatusCode.OK, "查询成功", schoolService.findCount(map));
    }

    /**
     * 根据ID查询
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", schoolService.findById(id));
    }



    /**
     * 增加
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody School school) {

        int flag = schoolService.add(school);
        if (flag>0){
            return new Result(true,StatusCode.OK,"增加成功",school);
        }else {
            return new Result(false,StatusCode.ERROR,"增加失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody School school, @PathVariable String id) {
        school.setId(id);
        School schoolTemp = schoolService.findById(id);
        if (schoolTemp == null) {
            return new Result(false, StatusCode.ERROR, "不存在");

        } else {
            schoolService.update(school);
            return new Result(true, StatusCode.OK, "修改成功");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        schoolService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
