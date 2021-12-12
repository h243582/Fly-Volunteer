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

import com.heyufei.dao.SchoolDao;
import com.heyufei.pojo.School;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SchoolService {

	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<School> findAll() {
		return schoolDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<School> findSearch(Map whereMap, int page, int size) {
		Specification<School> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return schoolDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<School> findSearch(Map whereMap) {
		Specification<School> specification = createSpecification(whereMap);
		return schoolDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public School findById(String id) {
		return schoolDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param school
	 */
	public void add(School school) {
		school.setId( idWorker.nextId()+"" );
		schoolDao.save(school);
	}

	/**
	 * 修改
	 * @param school
	 */
	public void update(School school) {
		schoolDao.save(school);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		schoolDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<School> createSpecification(Map searchMap) {

		return new Specification<School>() {

			@Override
			public Predicate toPredicate(Root<School> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 院校名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
