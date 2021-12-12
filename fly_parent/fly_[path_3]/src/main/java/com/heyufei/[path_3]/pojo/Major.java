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
@Table(name="tb_major")
public class Major implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//专业名
	private String major_code;//专业代码
	private Double satisfaction;//专业满意度
	private Integer tb_major_professional_category_id;//从属专业类

	
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

	public String getMajor_code() {		
		return major_code;
	}
	public void setMajor_code(String major_code) {
		this.major_code = major_code;
	}

	public Double getSatisfaction() {		
		return satisfaction;
	}
	public void setSatisfaction(Double satisfaction) {
		this.satisfaction = satisfaction;
	}

	public Integer getTb_major_professional_category_id() {		
		return tb_major_professional_category_id;
	}
	public void setTb_major_professional_category_id(Integer tb_major_professional_category_id) {
		this.tb_major_professional_category_id = tb_major_professional_category_id;
	}


	
}
