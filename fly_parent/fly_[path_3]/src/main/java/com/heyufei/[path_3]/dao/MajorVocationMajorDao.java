package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorVocationMajor;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorVocationMajorDao extends JpaRepository<MajorVocationMajor,String>,JpaSpecificationExecutor<MajorVocationMajor>{
	
}
