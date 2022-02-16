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
@Table(name="tb_major_vocation_major")
public class MajorVocationMajor implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_major_id;//专业表id
	private Integer tb_major_vocation_id;//就业职业表id

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTb_major_id() {		
		return tb_major_id;
	}
	public void setTb_major_id(Integer tb_major_id) {
		this.tb_major_id = tb_major_id;
	}

	public Integer getTb_major_vocation_id() {		
		return tb_major_vocation_id;
	}
	public void setTb_major_vocation_id(Integer tb_major_vocation_id) {
		this.tb_major_vocation_id = tb_major_vocation_id;
	}


	
}
