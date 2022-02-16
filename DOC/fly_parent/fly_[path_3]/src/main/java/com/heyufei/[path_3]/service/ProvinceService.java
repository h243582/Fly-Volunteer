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

import com.heyufei.dao.ProvinceDao;
import com.heyufei.pojo.Province;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Province> findAll() {
		return provinceDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Province> findSearch(Map whereMap, int page, int size) {
		Specification<Province> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return provinceDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Province> findSearch(Map whereMap) {
		Specification<Province> specification = createSpecification(whereMap);
		return provinceDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Province findById(String id) {
		return provinceDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param province
	 */
	public void add(Province province) {
		province.setId( idWorker.nextId()+"" );
		provinceDao.save(province);
	}

	/**
	 * 修改
	 * @param province
	 */
	public void update(Province province) {
		provinceDao.save(province);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		provinceDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Province> createSpecification(Map searchMap) {

		return new Specification<Province>() {

			@Override
			public Predicate toPredicate(Root<Province> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 省份名
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
