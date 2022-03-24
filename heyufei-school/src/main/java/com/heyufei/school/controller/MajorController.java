package com.heyufei.school.controller;

import com.heyufei.school.pojo.Major;
import com.heyufei.school.service.MajorService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/school/major")
public class MajorController {

    @Autowired
    private MajorService majorService;


    /**
     * 查询全部数据
     */
    @RequestMapping(method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功", majorService.findAll());
    }
    /**
     * 分页查询全部数据
     */
    @RequestMapping(value = "/{currentPage}/{pageSize}", method= RequestMethod.GET)
    public Result findAllLimit(@PathVariable int currentPage, @PathVariable int pageSize){
        return new Result(true,StatusCode.OK,"查询成功", majorService.findAllLimit(currentPage,pageSize));
    }
    /**
     * 根据ID查询
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", majorService.findById(id));
    }

    /**
     * 根据名字查询
     */
    @RequestMapping(value="/findSearch",method= RequestMethod.POST)
    public Result findSearch(@RequestBody Map<String,Object> map){
        return new Result(true,StatusCode.OK,"查询成功", majorService.findSearch(map));
    }


    /**
     * 增加
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody Major major  ){
        int add = majorService.add(major);
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
    public Result update(@RequestBody Major major, @PathVariable String id ){
        major.setId(id);
        if (majorService.update(major)!=0){
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
        majorService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
