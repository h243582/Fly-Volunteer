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
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//ID


	
	private String email;//邮箱
	private String password;//密码
	private String nickname;//昵称
	private String avatar;//头像
	private java.util.Date register_date;//注册日期
	private java.util.Date update_date;//修改日期
	private Integer is_vip;//是否会员

	
	public String getId() {		
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {		
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {		
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {		
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public java.util.Date getRegister_date() {		
		return register_date;
	}
	public void setRegister_date(java.util.Date register_date) {
		this.register_date = register_date;
	}

	public java.util.Date getUpdate_date() {		
		return update_date;
	}
	public void setUpdate_date(java.util.Date update_date) {
		this.update_date = update_date;
	}

	public Integer getIs_vip() {		
		return is_vip;
	}
	public void setIs_vip(Integer is_vip) {
		this.is_vip = is_vip;
	}


	
}
