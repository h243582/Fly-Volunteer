package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorProfessionalCategory;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorProfessionalCategoryDao extends JpaRepository<MajorProfessionalCategory,String>,JpaSpecificationExecutor<MajorProfessionalCategory>{
	
}
