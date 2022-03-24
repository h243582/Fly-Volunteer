package com.heyufei.school.controller;

import com.heyufei.school.pojo.SchoolInformation;
import com.heyufei.school.service.SchoolInformationService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/school/schoolInformation")
public class SchoolInformationController {

    @Autowired
    private SchoolInformationService schoolInformationService;


    /**
     * 查询全部数据
     */
    @RequestMapping(method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功", schoolInformationService.findAll());
    }
    /**
     * 分页查询全部数据
     */
    @RequestMapping(value = "/{currentPage}/{pageSize}", method= RequestMethod.GET)
    public Result findAllLimit(@PathVariable int currentPage, @PathVariable int pageSize){
        return new Result(true,StatusCode.OK,"查询成功", schoolInformationService.findAllLimit(currentPage,pageSize));
    }
    /**
     * 根据ID查询
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", schoolInformationService.findById(id));
    }

    /**
     * 根据名字查询
     */
    @RequestMapping(value="/findSearch",method= RequestMethod.POST)
    public Result findSearch(@RequestBody Map<String,Object> map){
        return new Result(true,StatusCode.OK,"查询成功", schoolInformationService.findSearch(map));
    }


    /**
     * 增加
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody SchoolInformation schoolInformation  ){
        int add = schoolInformationService.add(schoolInformation);
        if (add>0){
            return new Result(true,StatusCode.OK,"增加成功");
        }else {
            return new Result(false,StatusCode.ERROR,"增加失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody SchoolInformation schoolInformation, @PathVariable String id ){
        schoolInformation.setId(id);
        if (schoolInformationService.update(schoolInformation)!=0){
            return new Result(true,StatusCode.OK,"修改成功");
        }else {
            return new Result(false,StatusCode.ERROR,"修改失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        schoolInformationService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
