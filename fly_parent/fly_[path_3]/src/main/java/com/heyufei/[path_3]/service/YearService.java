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

import com.heyufei.dao.YearDao;
import com.heyufei.pojo.Year;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class YearService {

	@Autowired
	private YearDao yearDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Year> findAll() {
		return yearDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Year> findSearch(Map whereMap, int page, int size) {
		Specification<Year> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return yearDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Year> findSearch(Map whereMap) {
		Specification<Year> specification = createSpecification(whereMap);
		return yearDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Year findById(String id) {
		return yearDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param year
	 */
	public void add(Year year) {
		year.setId( idWorker.nextId()+"" );
		yearDao.save(year);
	}

	/**
	 * 修改
	 * @param year
	 */
	public void update(Year year) {
		yearDao.save(year);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		yearDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Year> createSpecification(Map searchMap) {

		return new Specification<Year>() {

			@Override
			public Predicate toPredicate(Root<Year> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
