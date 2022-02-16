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

import com.heyufei.dao.CourseDao;
import com.heyufei.pojo.Course;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Course> findSearch(Map whereMap, int page, int size) {
		Specification<Course> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return courseDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Course> findSearch(Map whereMap) {
		Specification<Course> specification = createSpecification(whereMap);
		return courseDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Course findById(String id) {
		return courseDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param course
	 */
	public void add(Course course) {
		course.setId( idWorker.nextId()+"" );
		courseDao.save(course);
	}

	/**
	 * 修改
	 * @param course
	 */
	public void update(Course course) {
		courseDao.save(course);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		courseDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Course> createSpecification(Map searchMap) {

		return new Specification<Course>() {

			@Override
			public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 课程
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
