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

import com.heyufei.dao.SchoolInformationDao;
import com.heyufei.pojo.SchoolInformation;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SchoolInformationService {

	@Autowired
	private SchoolInformationDao schoolInformationDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<SchoolInformation> findAll() {
		return schoolInformationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<SchoolInformation> findSearch(Map whereMap, int page, int size) {
		Specification<SchoolInformation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return schoolInformationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<SchoolInformation> findSearch(Map whereMap) {
		Specification<SchoolInformation> specification = createSpecification(whereMap);
		return schoolInformationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public SchoolInformation findById(String id) {
		return schoolInformationDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param schoolInformation
	 */
	public void add(SchoolInformation schoolInformation) {
		schoolInformation.setId( idWorker.nextId()+"" );
		schoolInformationDao.save(schoolInformation);
	}

	/**
	 * 修改
	 * @param schoolInformation
	 */
	public void update(SchoolInformation schoolInformation) {
		schoolInformationDao.save(schoolInformation);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		schoolInformationDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<SchoolInformation> createSpecification(Map searchMap) {

		return new Specification<SchoolInformation>() {

			@Override
			public Predicate toPredicate(Root<SchoolInformation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 学校id
                if (searchMap.get("tb_school_id")!=null && !"".equals(searchMap.get("tb_school_id"))) {
                	predicateList.add(cb.like(root.get("tb_school_id").as(String.class), "%"+(String)searchMap.get("tb_school_id")+"%"));
                }
                // 学校领导
                if (searchMap.get("leaders")!=null && !"".equals(searchMap.get("leaders"))) {
                	predicateList.add(cb.like(root.get("leaders").as(String.class), "%"+(String)searchMap.get("leaders")+"%"));
                }
                // 学校简介
                if (searchMap.get("introduce")!=null && !"".equals(searchMap.get("introduce"))) {
                	predicateList.add(cb.like(root.get("introduce").as(String.class), "%"+(String)searchMap.get("introduce")+"%"));
                }
                // 周边环境
                if (searchMap.get("environment")!=null && !"".equals(searchMap.get("environment"))) {
                	predicateList.add(cb.like(root.get("environment").as(String.class), "%"+(String)searchMap.get("environment")+"%"));
                }
                // 通讯地址
                if (searchMap.get("postal_address")!=null && !"".equals(searchMap.get("postal_address"))) {
                	predicateList.add(cb.like(root.get("postal_address").as(String.class), "%"+(String)searchMap.get("postal_address")+"%"));
                }
                // 联系电话
                if (searchMap.get("telephone")!=null && !"".equals(searchMap.get("telephone"))) {
                	predicateList.add(cb.like(root.get("telephone").as(String.class), "%"+(String)searchMap.get("telephone")+"%"));
                }
                // 重点实验室
                if (searchMap.get("key_laboratory")!=null && !"".equals(searchMap.get("key_laboratory"))) {
                	predicateList.add(cb.like(root.get("key_laboratory").as(String.class), "%"+(String)searchMap.get("key_laboratory")+"%"));
                }
                // 重点学科
                if (searchMap.get("key_disciplines")!=null && !"".equals(searchMap.get("key_disciplines"))) {
                	predicateList.add(cb.like(root.get("key_disciplines").as(String.class), "%"+(String)searchMap.get("key_disciplines")+"%"));
                }
                // 可授予的学位
                if (searchMap.get("conferable_degrees")!=null && !"".equals(searchMap.get("conferable_degrees"))) {
                	predicateList.add(cb.like(root.get("conferable_degrees").as(String.class), "%"+(String)searchMap.get("conferable_degrees")+"%"));
                }
                // 师资力量
                if (searchMap.get("faculty")!=null && !"".equals(searchMap.get("faculty"))) {
                	predicateList.add(cb.like(root.get("faculty").as(String.class), "%"+(String)searchMap.get("faculty")+"%"));
                }
                // 学生人数
                if (searchMap.get("students_number")!=null && !"".equals(searchMap.get("students_number"))) {
                	predicateList.add(cb.like(root.get("students_number").as(String.class), "%"+(String)searchMap.get("students_number")+"%"));
                }
                // 录取批次
                if (searchMap.get("admission_batch")!=null && !"".equals(searchMap.get("admission_batch"))) {
                	predicateList.add(cb.like(root.get("admission_batch").as(String.class), "%"+(String)searchMap.get("admission_batch")+"%"));
                }
                // 对艺术类招生的录取办法
                if (searchMap.get("art_enrollment")!=null && !"".equals(searchMap.get("art_enrollment"))) {
                	predicateList.add(cb.like(root.get("art_enrollment").as(String.class), "%"+(String)searchMap.get("art_enrollment")+"%"));
                }
                // 加分政策
                if (searchMap.get("extra_points")!=null && !"".equals(searchMap.get("extra_points"))) {
                	predicateList.add(cb.like(root.get("extra_points").as(String.class), "%"+(String)searchMap.get("extra_points")+"%"));
                }
                // 对少数民族考生的特殊政策
                if (searchMap.get("ethnic_minority")!=null && !"".equals(searchMap.get("ethnic_minority"))) {
                	predicateList.add(cb.like(root.get("ethnic_minority").as(String.class), "%"+(String)searchMap.get("ethnic_minority")+"%"));
                }
                // 对往届生的录取政策
                if (searchMap.get("previous_students")!=null && !"".equals(searchMap.get("previous_students"))) {
                	predicateList.add(cb.like(root.get("previous_students").as(String.class), "%"+(String)searchMap.get("previous_students")+"%"));
                }
                // 转专业的实施办法
                if (searchMap.get("transfer_major")!=null && !"".equals(searchMap.get("transfer_major"))) {
                	predicateList.add(cb.like(root.get("transfer_major").as(String.class), "%"+(String)searchMap.get("transfer_major")+"%"));
                }
                // 其它
                if (searchMap.get("other")!=null && !"".equals(searchMap.get("other"))) {
                	predicateList.add(cb.like(root.get("other").as(String.class), "%"+(String)searchMap.get("other")+"%"));
                }
                // 奖学金设置
                if (searchMap.get("scholarship")!=null && !"".equals(searchMap.get("scholarship"))) {
                	predicateList.add(cb.like(root.get("scholarship").as(String.class), "%"+(String)searchMap.get("scholarship")+"%"));
                }
                // 困难生资助办法
                if (searchMap.get("difficult_student")!=null && !"".equals(searchMap.get("difficult_student"))) {
                	predicateList.add(cb.like(root.get("difficult_student").as(String.class), "%"+(String)searchMap.get("difficult_student")+"%"));
                }
                // 宿舍
                if (searchMap.get("dormitory")!=null && !"".equals(searchMap.get("dormitory"))) {
                	predicateList.add(cb.like(root.get("dormitory").as(String.class), "%"+(String)searchMap.get("dormitory")+"%"));
                }
                // 食堂
                if (searchMap.get("canteen")!=null && !"".equals(searchMap.get("canteen"))) {
                	predicateList.add(cb.like(root.get("canteen").as(String.class), "%"+(String)searchMap.get("canteen")+"%"));
                }
                // 其它
                if (searchMap.get("average_food")!=null && !"".equals(searchMap.get("average_food"))) {
                	predicateList.add(cb.like(root.get("average_food").as(String.class), "%"+(String)searchMap.get("average_food")+"%"));
                }
                // 往年录取信息
                if (searchMap.get("admission_information")!=null && !"".equals(searchMap.get("admission_information"))) {
                	predicateList.add(cb.like(root.get("admission_information").as(String.class), "%"+(String)searchMap.get("admission_information")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
