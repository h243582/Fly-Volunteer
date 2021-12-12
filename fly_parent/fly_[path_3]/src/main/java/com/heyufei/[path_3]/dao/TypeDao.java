package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Type;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface TypeDao extends JpaRepository<Type,String>,JpaSpecificationExecutor<Type>{
	
}
