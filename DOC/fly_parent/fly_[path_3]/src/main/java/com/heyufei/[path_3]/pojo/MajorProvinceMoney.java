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
@Table(name="tb_major_province_money")
public class MajorProvinceMoney implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_major_id;//专业id
	private Integer tb_province_id;//省id
	private Integer money;//月薪

	
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

	public Integer getTb_province_id() {		
		return tb_province_id;
	}
	public void setTb_province_id(Integer tb_province_id) {
		this.tb_province_id = tb_province_id;
	}

	public Integer getMoney() {		
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}


	
}
