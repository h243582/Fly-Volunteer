package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorLevelsType;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorLevelsTypeDao extends JpaRepository<MajorLevelsType,String>,JpaSpecificationExecutor<MajorLevelsType>{
	
}
