package com.heyufei.school.dao;

import com.heyufei.school.pojo.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SchoolDao extends JpaRepository<School,String>,JpaSpecificationExecutor<School>{
	
}
