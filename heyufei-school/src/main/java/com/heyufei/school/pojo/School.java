package com.heyufei.school.pojo;

import lombok.Data;

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
@Data
@Table(name="tb_school")
public class School implements Serializable{

	@Id
	private String id;//ID


	
	private String name;//院校名称
	private String tb_province_id;//院校所在地
	private String tb_department_id;//教育行政主管部门
	private String tb_type_id;//院校类型
	private String tb_levels_id;//学历层次
	private Boolean top_university;//一流大学建设高校
	private Boolean top_discipline;//一流学科建设高校
	private Boolean graduate_school;//研究生院
	private Double satisfaction;//满意度


	
}
