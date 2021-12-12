package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Course;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CourseDao extends JpaRepository<Course,String>,JpaSpecificationExecutor<Course>{
	
}
