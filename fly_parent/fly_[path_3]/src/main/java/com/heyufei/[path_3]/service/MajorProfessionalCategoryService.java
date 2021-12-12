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

import com.heyufei.dao.MajorProfessionalCategoryDao;
import com.heyufei.pojo.MajorProfessionalCategory;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorProfessionalCategoryService {

	@Autowired
	private MajorProfessionalCategoryDao majorProfessionalCategoryDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorProfessionalCategory> findAll() {
		return majorProfessionalCategoryDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorProfessionalCategory> findSearch(Map whereMap, int page, int size) {
		Specification<MajorProfessionalCategory> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorProfessionalCategoryDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorProfessionalCategory> findSearch(Map whereMap) {
		Specification<MajorProfessionalCategory> specification = createSpecification(whereMap);
		return majorProfessionalCategoryDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorProfessionalCategory findById(String id) {
		return majorProfessionalCategoryDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorProfessionalCategory
	 */
	public void add(MajorProfessionalCategory majorProfessionalCategory) {
		majorProfessionalCategory.setId( idWorker.nextId()+"" );
		majorProfessionalCategoryDao.save(majorProfessionalCategory);
	}

	/**
	 * 修改
	 * @param majorProfessionalCategory
	 */
	public void update(MajorProfessionalCategory majorProfessionalCategory) {
		majorProfessionalCategoryDao.save(majorProfessionalCategory);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorProfessionalCategoryDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorProfessionalCategory> createSpecification(Map searchMap) {

		return new Specification<MajorProfessionalCategory>() {

			@Override
			public Predicate toPredicate(Root<MajorProfessionalCategory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 专业类名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 专业代码
                if (searchMap.get("major_code")!=null && !"".equals(searchMap.get("major_code"))) {
                	predicateList.add(cb.like(root.get("major_code").as(String.class), "%"+(String)searchMap.get("major_code")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
