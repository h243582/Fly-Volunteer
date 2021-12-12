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
@Table(name="tb_major_interpretation")
public class MajorInterpretation implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_major_id;//专业id
	private String title2;//标题题解
	private String from;//来自的平台
	private String author;//作者
	private String detail;//详细说明
	private String sponsor;//主办方
	private String prospects;//就业前景
	private String direction;//就业方向
	private String application_guide;//报考指南

	
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

	public String getTitle2() {		
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getFrom() {		
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public String getAuthor() {		
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDetail() {		
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSponsor() {		
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getProspects() {		
		return prospects;
	}
	public void setProspects(String prospects) {
		this.prospects = prospects;
	}

	public String getDirection() {		
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getApplication_guide() {		
		return application_guide;
	}
	public void setApplication_guide(String application_guide) {
		this.application_guide = application_guide;
	}


	
}
