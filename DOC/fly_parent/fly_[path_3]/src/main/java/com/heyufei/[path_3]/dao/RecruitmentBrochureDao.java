package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.RecruitmentBrochure;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitmentBrochureDao extends JpaRepository<RecruitmentBrochure,String>,JpaSpecificationExecutor<RecruitmentBrochure>{
	
}