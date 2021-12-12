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
@Table(name="tb_major_similar_major")
public class MajorSimilarMajor implements Serializable{

	@Id
	private Integer id;//ID


	
	private Integer tb_major_id;//专业id
	private Integer tb_major_id_similar;//相似专业id

	
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

	public Integer getTb_major_id_similar() {		
		return tb_major_id_similar;
	}
	public void setTb_major_id_similar(Integer tb_major_id_similar) {
		this.tb_major_id_similar = tb_major_id_similar;
	}


	
}
