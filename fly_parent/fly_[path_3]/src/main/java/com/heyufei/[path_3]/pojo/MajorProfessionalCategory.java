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
@Table(name="tb_major_professional_category")
public class MajorProfessionalCategory implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//专业类名
	private String major_code;//专业代码
	private Integer tb_major_category_id;//从属门类

	
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

	public Integer getTb_major_category_id() {		
		return tb_major_category_id;
	}
	public void setTb_major_category_id(Integer tb_major_category_id) {
		this.tb_major_category_id = tb_major_category_id;
	}


	
}
