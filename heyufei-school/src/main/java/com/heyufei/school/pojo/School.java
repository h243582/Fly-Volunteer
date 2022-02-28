package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Data
@TableName("tb_school")
public class School implements Serializable{

	@TableId
	private String id;//ID



	private String name;//院校名称
	@TableField("tb_province_id")
	private String provinceId;//院校所在地
	@TableField("tb_department_id")
	private String departmentId;//教育行政主管部门
	@TableField("tb_type_id")
	private String typeId;//院校类型
	@TableField("tb_levels_id")
	private String levelsId;//学历层次
	@TableField("top_university")
	private Boolean topUniversity;//一流大学建设高校
	@TableField("top_discipline")
	private Boolean topDiscipline;//一流学科建设高校
	@TableField("graduate_school")
	private Boolean graduateSchool;//研究生院
	private Double satisfaction;//满意度



}
