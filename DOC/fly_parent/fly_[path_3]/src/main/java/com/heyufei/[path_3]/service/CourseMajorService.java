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

import com.heyufei.dao.CourseMajorDao;
import com.heyufei.pojo.CourseMajor;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CourseMajorService {

	@Autowired
	private CourseMajorDao courseMajorDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<CourseMajor> findAll() {
		return courseMajorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<CourseMajor> findSearch(Map whereMap, int page, int size) {
		Specification<CourseMajor> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return courseMajorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<CourseMajor> findSearch(Map whereMap) {
		Specification<CourseMajor> specification = createSpecification(whereMap);
		return courseMajorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public CourseMajor findById(String id) {
		return courseMajorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param courseMajor
	 */
	public void add(CourseMajor courseMajor) {
		courseMajor.setId( idWorker.nextId()+"" );
		courseMajorDao.save(courseMajor);
	}

	/**
	 * 修改
	 * @param courseMajor
	 */
	public void update(CourseMajor courseMajor) {
		courseMajorDao.save(courseMajor);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		courseMajorDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<CourseMajor> createSpecification(Map searchMap) {

		return new Specification<CourseMajor>() {

			@Override
			public Predicate toPredicate(Root<CourseMajor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
