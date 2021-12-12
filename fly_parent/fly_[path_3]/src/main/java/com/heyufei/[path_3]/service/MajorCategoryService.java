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

import com.heyufei.dao.MajorCategoryDao;
import com.heyufei.pojo.MajorCategory;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorCategoryService {

	@Autowired
	private MajorCategoryDao majorCategoryDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorCategory> findAll() {
		return majorCategoryDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorCategory> findSearch(Map whereMap, int page, int size) {
		Specification<MajorCategory> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorCategoryDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorCategory> findSearch(Map whereMap) {
		Specification<MajorCategory> specification = createSpecification(whereMap);
		return majorCategoryDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorCategory findById(String id) {
		return majorCategoryDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorCategory
	 */
	public void add(MajorCategory majorCategory) {
		majorCategory.setId( idWorker.nextId()+"" );
		majorCategoryDao.save(majorCategory);
	}

	/**
	 * 修改
	 * @param majorCategory
	 */
	public void update(MajorCategory majorCategory) {
		majorCategoryDao.save(majorCategory);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorCategoryDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorCategory> createSpecification(Map searchMap) {

		return new Specification<MajorCategory>() {

			@Override
			public Predicate toPredicate(Root<MajorCategory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 门类名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
