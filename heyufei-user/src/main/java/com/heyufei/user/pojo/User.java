package com.heyufei.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private int id;//ID
	private String mobile;//手机号码
	private String password;//密码
	private String nickname;//昵称
	private String avatar;//头像
	@Column(name = "is_vip")
	private Integer isVip;//是否会员

	@Column(name = "register_date")
	private java.util.Date registerDate;//注册日期
	@Column(name = "update_date")
	private java.util.Date updateDate;//修改日期
	@Column(name = "last_date")
	private java.util.Date lastDate;//最后登录时间

//	public User(String mobile, String password, String nickname, String avatar, Integer isVip) {
//		this.mobile = mobile;
//		this.password = password;
//		this.nickname = nickname;
//		this.avatar = avatar;
//		this.isVip = isVip;
//	}
//
//	public User(String mobile, String password, String nickname, String avatar, Integer isVip, Date registerDate, Date updateDate, Date lastDate) {
//		this.mobile = mobile;
//		this.password = password;
//		this.nickname = nickname;
//		this.avatar = avatar;
//		this.isVip = isVip;
//		this.registerDate = registerDate;
//		this.updateDate = updateDate;
//		this.lastDate = lastDate;
//	}
}
