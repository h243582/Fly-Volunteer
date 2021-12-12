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

import com.heyufei.dao.MajorVocationMajorDao;
import com.heyufei.pojo.MajorVocationMajor;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorVocationMajorService {

	@Autowired
	private MajorVocationMajorDao majorVocationMajorDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorVocationMajor> findAll() {
		return majorVocationMajorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorVocationMajor> findSearch(Map whereMap, int page, int size) {
		Specification<MajorVocationMajor> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorVocationMajorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorVocationMajor> findSearch(Map whereMap) {
		Specification<MajorVocationMajor> specification = createSpecification(whereMap);
		return majorVocationMajorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorVocationMajor findById(String id) {
		return majorVocationMajorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorVocationMajor
	 */
	public void add(MajorVocationMajor majorVocationMajor) {
		majorVocationMajor.setId( idWorker.nextId()+"" );
		majorVocationMajorDao.save(majorVocationMajor);
	}

	/**
	 * 修改
	 * @param majorVocationMajor
	 */
	public void update(MajorVocationMajor majorVocationMajor) {
		majorVocationMajorDao.save(majorVocationMajor);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorVocationMajorDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorVocationMajor> createSpecification(Map searchMap) {

		return new Specification<MajorVocationMajor>() {

			@Override
			public Predicate toPredicate(Root<MajorVocationMajor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
