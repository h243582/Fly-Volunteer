package com.heyufei.school.controller;
import java.util.List;
import java.util.Map;

import com.heyufei.school.pojo.Province;
import com.heyufei.school.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import entity.PageResult;
import entity.Result;
import entity.StatusCode;


@RestController
@CrossOrigin
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private ProvinceService provinceService;


	/**
	 * 查询全部数据
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",provinceService.findAll());
	}
	/**
	 * 分页查询全部数据
	 */
	@RequestMapping(value = "/{currentPage}/{pageSize}", method= RequestMethod.GET)
	public Result findAllLimit(@PathVariable int currentPage, @PathVariable int pageSize){
		return new Result(true,StatusCode.OK,"查询成功", provinceService.findAllLimit(currentPage,pageSize));
	}
	/**
	 * 根据ID查询
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",provinceService.findById(id));
	}

	/**
	 * 根据名字查询
	 */
	@RequestMapping(value="/findSearch",method= RequestMethod.POST)
	public Result findSearch(@RequestBody Map<String,Object> map){
		return new Result(true,StatusCode.OK,"查询成功",provinceService.findSearch(map));
	}


	/**
	 * 增加
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Province province  ){
		int flag = provinceService.add(province);
		if (flag>0){
			return new Result(true,StatusCode.OK,"增加成功");
		}else {
			return new Result(false,StatusCode.ERROR,"增加失败");
		}
	}

	/**
	 * 修改
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Province province, @PathVariable String id ){
		province.setId(id);
		if (provinceService.update(province)!=0){
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
		provinceService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

}
