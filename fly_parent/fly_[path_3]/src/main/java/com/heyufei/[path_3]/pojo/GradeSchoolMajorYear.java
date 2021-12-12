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
@Table(name="tb_grade_school_major_year")
public class GradeSchoolMajorYear implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_school_major_id;//学校专业对应表id
	private Integer tb_year_id;//年份表id
	private Integer grade;//分数

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTb_school_major_id() {		
		return tb_school_major_id;
	}
	public void setTb_school_major_id(Integer tb_school_major_id) {
		this.tb_school_major_id = tb_school_major_id;
	}

	public Integer getTb_year_id() {		
		return tb_year_id;
	}
	public void setTb_year_id(Integer tb_year_id) {
		this.tb_year_id = tb_year_id;
	}

	public Integer getGrade() {		
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	
}
