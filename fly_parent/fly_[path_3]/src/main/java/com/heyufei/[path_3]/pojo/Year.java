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
@Table(name="tb_year")
public class Year implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer year;//年份

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {		
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}


	
}
