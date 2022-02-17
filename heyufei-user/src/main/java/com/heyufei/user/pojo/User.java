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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//ID
	private String email;//邮箱
	private String password;//密码
	private String nickname;//昵称
	private String avatar;//头像
	@Column(name = "is_vip")
	private Boolean isVip;//是否会员

//	@Column(name = "vip_day")
//	private Integer vipDay;//

	@Column(name = "register_date")
	private java.util.Date registerDate;//注册日期

	@Column(name = "update_date")
	private java.util.Date updateDate;//修改日期


}
