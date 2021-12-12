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

import com.heyufei.dao.SchoolMajorDao;
import com.heyufei.pojo.SchoolMajor;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SchoolMajorService {

	@Autowired
	private SchoolMajorDao schoolMajorDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<SchoolMajor> findAll() {
		return schoolMajorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<SchoolMajor> findSearch(Map whereMap, int page, int size) {
		Specification<SchoolMajor> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return schoolMajorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<SchoolMajor> findSearch(Map whereMap) {
		Specification<SchoolMajor> specification = createSpecification(whereMap);
		return schoolMajorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public SchoolMajor findById(String id) {
		return schoolMajorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param schoolMajor
	 */
	public void add(SchoolMajor schoolMajor) {
		schoolMajor.setId( idWorker.nextId()+"" );
		schoolMajorDao.save(schoolMajor);
	}

	/**
	 * 修改
	 * @param schoolMajor
	 */
	public void update(SchoolMajor schoolMajor) {
		schoolMajorDao.save(schoolMajor);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		schoolMajorDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<SchoolMajor> createSpecification(Map searchMap) {

		return new Specification<SchoolMajor>() {

			@Override
			public Predicate toPredicate(Root<SchoolMajor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学制
                if (searchMap.get("educational_system")!=null && !"".equals(searchMap.get("educational_system"))) {
                	predicateList.add(cb.like(root.get("educational_system").as(String.class), "%"+(String)searchMap.get("educational_system")+"%"));
                }
                // 培养目标
                if (searchMap.get("training_objectives")!=null && !"".equals(searchMap.get("training_objectives"))) {
                	predicateList.add(cb.like(root.get("training_objectives").as(String.class), "%"+(String)searchMap.get("training_objectives")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
