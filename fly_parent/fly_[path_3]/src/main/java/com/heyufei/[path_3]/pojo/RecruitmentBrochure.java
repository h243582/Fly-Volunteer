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
@Table(name="tb_recruitment_brochure")
public class RecruitmentBrochure implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_school_id;//学校id
	private String name;//简章名
	private java.util.Date release_time;//发布时间
	private String content;//简章内容

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTb_school_id() {		
		return tb_school_id;
	}
	public void setTb_school_id(Integer tb_school_id) {
		this.tb_school_id = tb_school_id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getRelease_time() {		
		return release_time;
	}
	public void setRelease_time(java.util.Date release_time) {
		this.release_time = release_time;
	}

	public String getContent() {		
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
}
