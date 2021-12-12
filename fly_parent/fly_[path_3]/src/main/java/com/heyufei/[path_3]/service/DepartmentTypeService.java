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

import com.heyufei.dao.DepartmentTypeDao;
import com.heyufei.pojo.DepartmentType;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class DepartmentTypeService {

	@Autowired
	private DepartmentTypeDao departmentTypeDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<DepartmentType> findAll() {
		return departmentTypeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<DepartmentType> findSearch(Map whereMap, int page, int size) {
		Specification<DepartmentType> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return departmentTypeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<DepartmentType> findSearch(Map whereMap) {
		Specification<DepartmentType> specification = createSpecification(whereMap);
		return departmentTypeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public DepartmentType findById(String id) {
		return departmentTypeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param departmentType
	 */
	public void add(DepartmentType departmentType) {
		departmentType.setId( idWorker.nextId()+"" );
		departmentTypeDao.save(departmentType);
	}

	/**
	 * 修改
	 * @param departmentType
	 */
	public void update(DepartmentType departmentType) {
		departmentTypeDao.save(departmentType);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		departmentTypeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<DepartmentType> createSpecification(Map searchMap) {

		return new Specification<DepartmentType>() {

			@Override
			public Predicate toPredicate(Root<DepartmentType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 主管部门类别
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
