package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorProvinceMoney;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorProvinceMoneyDao extends JpaRepository<MajorProvinceMoney,String>,JpaSpecificationExecutor<MajorProvinceMoney>{
	
}
