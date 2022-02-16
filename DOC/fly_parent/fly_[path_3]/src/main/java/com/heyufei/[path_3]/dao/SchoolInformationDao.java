package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.SchoolInformation;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SchoolInformationDao extends JpaRepository<SchoolInformation,String>,JpaSpecificationExecutor<SchoolInformation>{
	
}
