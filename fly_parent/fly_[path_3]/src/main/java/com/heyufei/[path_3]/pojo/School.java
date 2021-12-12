package com.heyufei.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_school")
public class School implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//院校名称
	private Integer tb_province_id;//院校所在地
	private Integer tb_department_id;//教育行政主管部门
	private Integer tb_type_id;//院校类型
	private Integer tb_levels_id;//学历层次
	private BIT top_university;//一流大学建设高校
	private BIT top_discipline;//一流学科建设高校
	private BIT graduate_school;//研究生院
	private Double satisfaction;//满意度

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getTb_province_id() {		
		return tb_province_id;
	}
	public void setTb_province_id(Integer tb_province_id) {
		this.tb_province_id = tb_province_id;
	}

	public Integer getTb_department_id() {		
		return tb_department_id;
	}
	public void setTb_department_id(Integer tb_department_id) {
		this.tb_department_id = tb_department_id;
	}

	public Integer getTb_type_id() {		
		return tb_type_id;
	}
	public void setTb_type_id(Integer tb_type_id) {
		this.tb_type_id = tb_type_id;
	}

	public Integer getTb_levels_id() {		
		return tb_levels_id;
	}
	public void setTb_levels_id(Integer tb_levels_id) {
		this.tb_levels_id = tb_levels_id;
	}

	public BIT getTop_university() {		
		return top_university;
	}
	public void setTop_university(BIT top_university) {
		this.top_university = top_university;
	}

	public BIT getTop_discipline() {		
		return top_discipline;
	}
	public void setTop_discipline(BIT top_discipline) {
		this.top_discipline = top_discipline;
	}

	public BIT getGraduate_school() {		
		return graduate_school;
	}
	public void setGraduate_school(BIT graduate_school) {
		this.graduate_school = graduate_school;
	}

	public Double getSatisfaction() {		
		return satisfaction;
	}
	public void setSatisfaction(Double satisfaction) {
		this.satisfaction = satisfaction;
	}


	
}
