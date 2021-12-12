package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.CourseMajor;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CourseMajorDao extends JpaRepository<CourseMajor,String>,JpaSpecificationExecutor<CourseMajor>{
	
}
