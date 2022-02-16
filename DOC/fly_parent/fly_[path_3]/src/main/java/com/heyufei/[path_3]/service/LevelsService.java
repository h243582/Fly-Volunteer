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

import com.heyufei.dao.LevelsDao;
import com.heyufei.pojo.Levels;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class LevelsService {

	@Autowired
	private LevelsDao levelsDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Levels> findAll() {
		return levelsDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Levels> findSearch(Map whereMap, int page, int size) {
		Specification<Levels> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return levelsDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Levels> findSearch(Map whereMap) {
		Specification<Levels> specification = createSpecification(whereMap);
		return levelsDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Levels findById(String id) {
		return levelsDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param levels
	 */
	public void add(Levels levels) {
		levels.setId( idWorker.nextId()+"" );
		levelsDao.save(levels);
	}

	/**
	 * 修改
	 * @param levels
	 */
	public void update(Levels levels) {
		levelsDao.save(levels);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		levelsDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Levels> createSpecification(Map searchMap) {

		return new Specification<Levels>() {

			@Override
			public Predicate toPredicate(Root<Levels> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学历层次名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
