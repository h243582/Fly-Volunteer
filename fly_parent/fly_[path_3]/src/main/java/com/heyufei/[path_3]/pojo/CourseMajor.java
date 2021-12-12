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
@Table(name="tb_course_major")
public class CourseMajor implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_course_id;//课程ID
	private Integer tb_major_id;//专业ID
	private Double course_difficulty;//课程难易度
	private Double course_practical;//课程实用性（于工作、个人成长) 

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTb_course_id() {		
		return tb_course_id;
	}
	public void setTb_course_id(Integer tb_course_id) {
		this.tb_course_id = tb_course_id;
	}

	public Integer getTb_major_id() {		
		return tb_major_id;
	}
	public void setTb_major_id(Integer tb_major_id) {
		this.tb_major_id = tb_major_id;
	}

	public Double getCourse_difficulty() {		
		return course_difficulty;
	}
	public void setCourse_difficulty(Double course_difficulty) {
		this.course_difficulty = course_difficulty;
	}

	public Double getCourse_practical() {		
		return course_practical;
	}
	public void setCourse_practical(Double course_practical) {
		this.course_practical = course_practical;
	}


	
}
