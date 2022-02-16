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

import com.heyufei.dao.MajorLevelsTypeDao;
import com.heyufei.pojo.MajorLevelsType;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorLevelsTypeService {

	@Autowired
	private MajorLevelsTypeDao majorLevelsTypeDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<MajorLevelsType> findAll() {
		return majorLevelsTypeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<MajorLevelsType> findSearch(Map whereMap, int page, int size) {
		Specification<MajorLevelsType> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorLevelsTypeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<MajorLevelsType> findSearch(Map whereMap) {
		Specification<MajorLevelsType> specification = createSpecification(whereMap);
		return majorLevelsTypeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public MajorLevelsType findById(String id) {
		return majorLevelsTypeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param majorLevelsType
	 */
	public void add(MajorLevelsType majorLevelsType) {
		majorLevelsType.setId( idWorker.nextId()+"" );
		majorLevelsTypeDao.save(majorLevelsType);
	}

	/**
	 * 修改
	 * @param majorLevelsType
	 */
	public void update(MajorLevelsType majorLevelsType) {
		majorLevelsTypeDao.save(majorLevelsType);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		majorLevelsTypeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<MajorLevelsType> createSpecification(Map searchMap) {

		return new Specification<MajorLevelsType>() {

			@Override
			public Predicate toPredicate(Root<MajorLevelsType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 专业层次类型名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
