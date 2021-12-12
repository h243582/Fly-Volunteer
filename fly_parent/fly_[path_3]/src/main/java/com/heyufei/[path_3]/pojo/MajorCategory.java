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
@Table(name="tb_major_category")
public class MajorCategory implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//门类名
	private Integer tb_major_levels_type_id;//从属专业层次类型

	
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

	public Integer getTb_major_levels_type_id() {		
		return tb_major_levels_type_id;
	}
	public void setTb_major_levels_type_id(Integer tb_major_levels_type_id) {
		this.tb_major_levels_type_id = tb_major_levels_type_id;
	}


	
}
