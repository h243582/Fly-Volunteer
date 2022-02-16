package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.SchoolMajor;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SchoolMajorDao extends JpaRepository<SchoolMajor,String>,JpaSpecificationExecutor<SchoolMajor>{
	
}
