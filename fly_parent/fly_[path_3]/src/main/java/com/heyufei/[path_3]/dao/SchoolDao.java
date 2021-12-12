package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.School;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SchoolDao extends JpaRepository<School,String>,JpaSpecificationExecutor<School>{
	
}
