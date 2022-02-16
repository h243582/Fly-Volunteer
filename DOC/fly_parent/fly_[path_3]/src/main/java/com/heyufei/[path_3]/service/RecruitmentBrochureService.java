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

import com.heyufei.dao.RecruitmentBrochureDao;
import com.heyufei.pojo.RecruitmentBrochure;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RecruitmentBrochureService {

	@Autowired
	private RecruitmentBrochureDao recruitmentBrochureDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<RecruitmentBrochure> findAll() {
		return recruitmentBrochureDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<RecruitmentBrochure> findSearch(Map whereMap, int page, int size) {
		Specification<RecruitmentBrochure> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return recruitmentBrochureDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<RecruitmentBrochure> findSearch(Map whereMap) {
		Specification<RecruitmentBrochure> specification = createSpecification(whereMap);
		return recruitmentBrochureDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public RecruitmentBrochure findById(String id) {
		return recruitmentBrochureDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param recruitmentBrochure
	 */
	public void add(RecruitmentBrochure recruitmentBrochure) {
		recruitmentBrochure.setId( idWorker.nextId()+"" );
		recruitmentBrochureDao.save(recruitmentBrochure);
	}

	/**
	 * 修改
	 * @param recruitmentBrochure
	 */
	public void update(RecruitmentBrochure recruitmentBrochure) {
		recruitmentBrochureDao.save(recruitmentBrochure);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		recruitmentBrochureDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<RecruitmentBrochure> createSpecification(Map searchMap) {

		return new Specification<RecruitmentBrochure>() {

			@Override
			public Predicate toPredicate(Root<RecruitmentBrochure> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 简章名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 简章内容
                if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
                	predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
