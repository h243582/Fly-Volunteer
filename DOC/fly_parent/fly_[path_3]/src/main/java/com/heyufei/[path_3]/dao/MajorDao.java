package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Major;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorDao extends JpaRepository<Major,String>,JpaSpecificationExecutor<Major>{
	
}