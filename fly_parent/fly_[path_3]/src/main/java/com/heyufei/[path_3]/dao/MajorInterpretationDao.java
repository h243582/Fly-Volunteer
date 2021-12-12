package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.MajorInterpretation;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MajorInterpretationDao extends JpaRepository<MajorInterpretation,String>,JpaSpecificationExecutor<MajorInterpretation>{
	
}
