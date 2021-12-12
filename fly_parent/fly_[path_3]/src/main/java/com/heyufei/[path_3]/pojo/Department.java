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
@Table(name="tb_department")
public class Department implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//部门名
	private Integer tb_department_type_id;//主管部门类别

	
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

	public Integer getTb_department_type_id() {		
		return tb_department_type_id;
	}
	public void setTb_department_type_id(Integer tb_department_type_id) {
		this.tb_department_type_id = tb_department_type_id;
	}


	
}
