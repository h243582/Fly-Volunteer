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

import com.heyufei.dao.MajorInterpretationDao;
import com.heyufei.pojo.MajorInterpretation;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorInterpretationService {

	@Autowired
	private MajorInterpretationDao majorInterpretationDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorInterpretation> findAll() {
		return majorInterpretationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorInterpretation> findSearch(Map whereMap, int page, int size) {
		Specification<MajorInterpretation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorInterpretationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorInterpretation> findSearch(Map whereMap) {
		Specification<MajorInterpretation> specification = createSpecification(whereMap);
		return majorInterpretationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorInterpretation findById(String id) {
		return majorInterpretationDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorInterpretation
	 */
	public void add(MajorInterpretation majorInterpretation) {
		majorInterpretation.setId( idWorker.nextId()+"" );
		majorInterpretationDao.save(majorInterpretation);
	}

	/**
	 * 修改
	 * @param majorInterpretation
	 */
	public void update(MajorInterpretation majorInterpretation) {
		majorInterpretationDao.save(majorInterpretation);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorInterpretationDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorInterpretation> createSpecification(Map searchMap) {

		return new Specification<MajorInterpretation>() {

			@Override
			public Predicate toPredicate(Root<MajorInterpretation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 标题题解
                if (searchMap.get("title2")!=null && !"".equals(searchMap.get("title2"))) {
                	predicateList.add(cb.like(root.get("title2").as(String.class), "%"+(String)searchMap.get("title2")+"%"));
                }
                // 来自的平台
                if (searchMap.get("from")!=null && !"".equals(searchMap.get("from"))) {
                	predicateList.add(cb.like(root.get("from").as(String.class), "%"+(String)searchMap.get("from")+"%"));
                }
                // 作者
                if (searchMap.get("author")!=null && !"".equals(searchMap.get("author"))) {
                	predicateList.add(cb.like(root.get("author").as(String.class), "%"+(String)searchMap.get("author")+"%"));
                }
                // 详细说明
                if (searchMap.get("detail")!=null && !"".equals(searchMap.get("detail"))) {
                	predicateList.add(cb.like(root.get("detail").as(String.class), "%"+(String)searchMap.get("detail")+"%"));
                }
                // 主办方
                if (searchMap.get("sponsor")!=null && !"".equals(searchMap.get("sponsor"))) {
                	predicateList.add(cb.like(root.get("sponsor").as(String.class), "%"+(String)searchMap.get("sponsor")+"%"));
                }
                // 就业前景
                if (searchMap.get("prospects")!=null && !"".equals(searchMap.get("prospects"))) {
                	predicateList.add(cb.like(root.get("prospects").as(String.class), "%"+(String)searchMap.get("prospects")+"%"));
                }
                // 就业方向
                if (searchMap.get("direction")!=null && !"".equals(searchMap.get("direction"))) {
                	predicateList.add(cb.like(root.get("direction").as(String.class), "%"+(String)searchMap.get("direction")+"%"));
                }
                // 报考指南
                if (searchMap.get("application_guide")!=null && !"".equals(searchMap.get("application_guide"))) {
                	predicateList.add(cb.like(root.get("application_guide").as(String.class), "%"+(String)searchMap.get("application_guide")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
