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

import com.heyufei.dao.MajorInformationDao;
import com.heyufei.pojo.MajorInformation;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorInformationService {

	@Autowired
	private MajorInformationDao majorInformationDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorInformation> findAll() {
		return majorInformationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorInformation> findSearch(Map whereMap, int page, int size) {
		Specification<MajorInformation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorInformationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorInformation> findSearch(Map whereMap) {
		Specification<MajorInformation> specification = createSpecification(whereMap);
		return majorInformationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorInformation findById(String id) {
		return majorInformationDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorInformation
	 */
	public void add(MajorInformation majorInformation) {
		majorInformation.setId( idWorker.nextId()+"" );
		majorInformationDao.save(majorInformation);
	}

	/**
	 * 修改
	 * @param majorInformation
	 */
	public void update(MajorInformation majorInformation) {
		majorInformationDao.save(majorInformation);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorInformationDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorInformation> createSpecification(Map searchMap) {

		return new Specification<MajorInformation>() {

			@Override
			public Predicate toPredicate(Root<MajorInformation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 专业介绍
                if (searchMap.get("introduce")!=null && !"".equals(searchMap.get("introduce"))) {
                	predicateList.add(cb.like(root.get("introduce").as(String.class), "%"+(String)searchMap.get("introduce")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
