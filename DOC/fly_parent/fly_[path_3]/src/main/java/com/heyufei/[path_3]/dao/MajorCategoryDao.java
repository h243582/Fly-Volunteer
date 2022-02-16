package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorCategory;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorCategoryDao extends JpaRepository<MajorCategory,String>,JpaSpecificationExecutor<MajorCategory>{
	
}
