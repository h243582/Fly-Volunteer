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

import com.heyufei.dao.TypeDao;
import com.heyufei.pojo.Type;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class TypeService {

	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Type> findAll() {
		return typeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Type> findSearch(Map whereMap, int page, int size) {
		Specification<Type> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return typeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Type> findSearch(Map whereMap) {
		Specification<Type> specification = createSpecification(whereMap);
		return typeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Type findById(String id) {
		return typeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param type
	 */
	public void add(Type type) {
		type.setId( idWorker.nextId()+"" );
		typeDao.save(type);
	}

	/**
	 * 修改
	 * @param type
	 */
	public void update(Type type) {
		typeDao.save(type);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		typeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Type> createSpecification(Map searchMap) {

		return new Specification<Type>() {

			@Override
			public Predicate toPredicate(Root<Type> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 院校类型名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
