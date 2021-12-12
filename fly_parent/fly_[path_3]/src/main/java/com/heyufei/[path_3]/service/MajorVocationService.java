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

import com.heyufei.dao.MajorVocationDao;
import com.heyufei.pojo.MajorVocation;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorVocationService {

	@Autowired
	private MajorVocationDao majorVocationDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorVocation> findAll() {
		return majorVocationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorVocation> findSearch(Map whereMap, int page, int size) {
		Specification<MajorVocation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorVocationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorVocation> findSearch(Map whereMap) {
		Specification<MajorVocation> specification = createSpecification(whereMap);
		return majorVocationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorVocation findById(String id) {
		return majorVocationDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorVocation
	 */
	public void add(MajorVocation majorVocation) {
		majorVocation.setId( idWorker.nextId()+"" );
		majorVocationDao.save(majorVocation);
	}

	/**
	 * 修改
	 * @param majorVocation
	 */
	public void update(MajorVocation majorVocation) {
		majorVocationDao.save(majorVocation);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorVocationDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorVocation> createSpecification(Map searchMap) {

		return new Specification<MajorVocation>() {

			@Override
			public Predicate toPredicate(Root<MajorVocation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 就业方向
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
