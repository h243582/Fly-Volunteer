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
@Table(name="tb_major_vocation")
public class MajorVocation implements Serializable{

	@Id
	private Integer id;//ID


	
	private String name;//就业方向

	
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


	
}
