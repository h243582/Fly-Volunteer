package com.heyufei.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.heyufei.pojo.GradeSchoolMajorYear;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface GradeSchoolMajorYearDao extends JpaRepository<GradeSchoolMajorYear,String>,JpaSpecificationExecutor<GradeSchoolMajorYear>{
	
}
