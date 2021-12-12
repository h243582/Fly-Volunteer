package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.Levels;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface LevelsDao extends JpaRepository<Levels,String>,JpaSpecificationExecutor<Levels>{
	
}
