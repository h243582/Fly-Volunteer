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

import com.heyufei.dao.MajorProvinceMoneyDao;
import com.heyufei.pojo.MajorProvinceMoney;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorProvinceMoneyService {

	@Autowired
	private MajorProvinceMoneyDao majorProvinceMoneyDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorProvinceMoney> findAll() {
		return majorProvinceMoneyDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorProvinceMoney> findSearch(Map whereMap, int page, int size) {
		Specification<MajorProvinceMoney> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorProvinceMoneyDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorProvinceMoney> findSearch(Map whereMap) {
		Specification<MajorProvinceMoney> specification = createSpecification(whereMap);
		return majorProvinceMoneyDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorProvinceMoney findById(String id) {
		return majorProvinceMoneyDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorProvinceMoney
	 */
	public void add(MajorProvinceMoney majorProvinceMoney) {
		majorProvinceMoney.setId( idWorker.nextId()+"" );
		majorProvinceMoneyDao.save(majorProvinceMoney);
	}

	/**
	 * 修改
	 * @param majorProvinceMoney
	 */
	public void update(MajorProvinceMoney majorProvinceMoney) {
		majorProvinceMoneyDao.save(majorProvinceMoney);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorProvinceMoneyDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorProvinceMoney> createSpecification(Map searchMap) {

		return new Specification<MajorProvinceMoney>() {

			@Override
			public Predicate toPredicate(Root<MajorProvinceMoney> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
