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
@Table(name="tb_city")
public class City implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//市名
	private Integer province_id;//省份id

	
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

	public Integer getProvince_id() {		
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}


	
}
