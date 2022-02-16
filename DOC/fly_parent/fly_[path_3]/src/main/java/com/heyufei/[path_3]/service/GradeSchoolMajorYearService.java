package com.heyufei.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.heyufei.dao.GradeSchoolMajorYearDao;
import com.heyufei.pojo.GradeSchoolMajorYear;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class GradeSchoolMajorYearService {

	@Autowired
	private GradeSchoolMajorYearDao gradeSchoolMajorYearDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<GradeSchoolMajorYear> findAll() {
		return gradeSchoolMajorYearDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<GradeSchoolMajorYear> findSearch(Map whereMap, int page, int size) {
		Specification<GradeSchoolMajorYear> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return gradeSchoolMajorYearDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<GradeSchoolMajorYear> findSearch(Map whereMap) {
		Specification<GradeSchoolMajorYear> specification = createSpecification(whereMap);
		return gradeSchoolMajorYearDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public GradeSchoolMajorYear findById(String id) {
		return gradeSchoolMajorYearDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param gradeSchoolMajorYear
	 */
	public void add(GradeSchoolMajorYear gradeSchoolMajorYear) {
		gradeSchoolMajorYear.setId( idWorker.nextId()+"" );
		gradeSchoolMajorYearDao.save(gradeSchoolMajorYear);
	}

	/**
	 * 修改
	 * @param gradeSchoolMajorYear
	 */
	public void update(GradeSchoolMajorYear gradeSchoolMajorYear) {
		gradeSchoolMajorYearDao.save(gradeSchoolMajorYear);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		gradeSchoolMajorYearDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<GradeSchoolMajorYear> createSpecification(Map searchMap) {

		return new Specification<GradeSchoolMajorYear>() {

			@Override
			public Predicate toPredicate(Root<GradeSchoolMajorYear> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
