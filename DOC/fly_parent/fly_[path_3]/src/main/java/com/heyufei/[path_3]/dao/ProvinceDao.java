package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Province;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProvinceDao extends JpaRepository<Province,String>,JpaSpecificationExecutor<Province>{
	
}
