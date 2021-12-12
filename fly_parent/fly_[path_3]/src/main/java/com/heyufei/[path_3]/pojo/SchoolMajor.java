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
@Table(name="tb_school_major")
public class SchoolMajor implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_school_id;//学校id
	private Integer tb_major_id;//专业id
	private String educational_system;//学制
	private String training_objectives;//培养目标
	private Double satisfaction;//推荐指数
	private Integer recommended_number;//推荐人数
	private Double comprehensive_satisfaction;//综合满意度
	private Integer comprehensive_people;//综合满意度人数
	private Double conditions_satisfaction;//办学条件满意度
	private Integer conditions_people;//办学条件满意度人数
	private Double quality_satisfaction;//教学质量满意度
	private Integer quality_people;//教学质量满意度人数
	private Double job_satisfaction;//就业满意度
	private Integer job_people;//就业满意度人数

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTb_school_id() {		
		return tb_school_id;
	}
	public void setTb_school_id(Integer tb_school_id) {
		this.tb_school_id = tb_school_id;
	}

	public Integer getTb_major_id() {		
		return tb_major_id;
	}
	public void setTb_major_id(Integer tb_major_id) {
		this.tb_major_id = tb_major_id;
	}

	public String getEducational_system() {		
		return educational_system;
	}
	public void setEducational_system(String educational_system) {
		this.educational_system = educational_system;
	}

	public String getTraining_objectives() {		
		return training_objectives;
	}
	public void setTraining_objectives(String training_objectives) {
		this.training_objectives = training_objectives;
	}

	public Double getSatisfaction() {		
		return satisfaction;
	}
	public void setSatisfaction(Double satisfaction) {
		this.satisfaction = satisfaction;
	}

	public Integer getRecommended_number() {		
		return recommended_number;
	}
	public void setRecommended_number(Integer recommended_number) {
		this.recommended_number = recommended_number;
	}

	public Double getComprehensive_satisfaction() {		
		return comprehensive_satisfaction;
	}
	public void setComprehensive_satisfaction(Double comprehensive_satisfaction) {
		this.comprehensive_satisfaction = comprehensive_satisfaction;
	}

	public Integer getComprehensive_people() {		
		return comprehensive_people;
	}
	public void setComprehensive_people(Integer comprehensive_people) {
		this.comprehensive_people = comprehensive_people;
	}

	public Double getConditions_satisfaction() {		
		return conditions_satisfaction;
	}
	public void setConditions_satisfaction(Double conditions_satisfaction) {
		this.conditions_satisfaction = conditions_satisfaction;
	}

	public Integer getConditions_people() {		
		return conditions_people;
	}
	public void setConditions_people(Integer conditions_people) {
		this.conditions_people = conditions_people;
	}

	public Double getQuality_satisfaction() {		
		return quality_satisfaction;
	}
	public void setQuality_satisfaction(Double quality_satisfaction) {
		this.quality_satisfaction = quality_satisfaction;
	}

	public Integer getQuality_people() {		
		return quality_people;
	}
	public void setQuality_people(Integer quality_people) {
		this.quality_people = quality_people;
	}

	public Double getJob_satisfaction() {		
		return job_satisfaction;
	}
	public void setJob_satisfaction(Double job_satisfaction) {
		this.job_satisfaction = job_satisfaction;
	}

	public Integer getJob_people() {		
		return job_people;
	}
	public void setJob_people(Integer job_people) {
		this.job_people = job_people;
	}


	
}
