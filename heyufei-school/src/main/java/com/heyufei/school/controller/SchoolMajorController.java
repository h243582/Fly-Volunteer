package com.heyufei.school.controller;

import com.heyufei.school.pojo.SchoolMajor;
import com.heyufei.school.service.SchoolMajorService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/school/schoolMajor")
public class SchoolMajorController {

    @Autowired
    private SchoolMajorService schoolMajorService;


    /**
     * 查询全部数据
     */
    @RequestMapping(method= RequestMethod.GET)
    public Result findAll(){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findAll());
    }

    /**
     * 分页查询全部数据
     */
    @RequestMapping(value = "/{currentPage}/{pageSize}", method= RequestMethod.GET)
    public Result findAllLimit(@PathVariable int currentPage, @PathVariable int pageSize){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findAllLimit(currentPage,pageSize));
    }

    /**
     * 根据ID查询综合满意度降序
     */
    @RequestMapping(value="/comprehensiveSatisfaction/{id}",method= RequestMethod.GET)
    public Result findByIdDescComprehensiveSatisfaction(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findByIdDescComprehensiveSatisfaction(id));
    }

    /**
     * 根据ID查询推荐满意度降序
     */
    @RequestMapping(value="/recommendSatisfaction/{id}",method= RequestMethod.GET)
    public Result findByIdDescRecommendSatisfaction(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findByIdDescRecommendSatisfaction(id));
    }

    /**
     * 根据ID查询推荐指数降序
     */
    @RequestMapping(value="/recommendNumber/{id}",method= RequestMethod.GET)
    public Result findByIdDescRecommendNumber(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findByIdDescRecommendNumber(id));
    }


    /**
     * 根据名字查询
     */
    @RequestMapping(value="/findSearch",method= RequestMethod.POST)
    public Result findSearch(@RequestBody Map<String,Object> map){
        return new Result(true,StatusCode.OK,"查询成功", schoolMajorService.findSearch(map));
    }


    /**
     * 增加
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody SchoolMajor schoolMajor  ){
        int add = schoolMajorService.add(schoolMajor);
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
    public Result update(@RequestBody SchoolMajor schoolMajor, @PathVariable String id ){
        schoolMajor.setId(id);
        if (schoolMajorService.update(schoolMajor)!=0){
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
        schoolMajorService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
