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

import com.heyufei.dao.MajorSimilarMajorDao;
import com.heyufei.pojo.MajorSimilarMajor;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorSimilarMajorService {

	@Autowired
	private MajorSimilarMajorDao majorSimilarMajorDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorSimilarMajor> findAll() {
		return majorSimilarMajorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorSimilarMajor> findSearch(Map whereMap, int page, int size) {
		Specification<MajorSimilarMajor> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorSimilarMajorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorSimilarMajor> findSearch(Map whereMap) {
		Specification<MajorSimilarMajor> specification = createSpecification(whereMap);
		return majorSimilarMajorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorSimilarMajor findById(String id) {
		return majorSimilarMajorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorSimilarMajor
	 */
	public void add(MajorSimilarMajor majorSimilarMajor) {
		majorSimilarMajor.setId( idWorker.nextId()+"" );
		majorSimilarMajorDao.save(majorSimilarMajor);
	}

	/**
	 * 修改
	 * @param majorSimilarMajor
	 */
	public void update(MajorSimilarMajor majorSimilarMajor) {
		majorSimilarMajorDao.save(majorSimilarMajor);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorSimilarMajorDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorSimilarMajor> createSpecification(Map searchMap) {

		return new Specification<MajorSimilarMajor>() {

			@Override
			public Predicate toPredicate(Root<MajorSimilarMajor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
