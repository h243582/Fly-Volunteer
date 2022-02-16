package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Department;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface DepartmentDao extends JpaRepository<Department,String>,JpaSpecificationExecutor<Department>{
	
}
