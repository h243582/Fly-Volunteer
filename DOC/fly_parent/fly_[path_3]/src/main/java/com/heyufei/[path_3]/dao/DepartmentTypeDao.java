package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.DepartmentType;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface DepartmentTypeDao extends JpaRepository<DepartmentType,String>,JpaSpecificationExecutor<DepartmentType>{
	
}
