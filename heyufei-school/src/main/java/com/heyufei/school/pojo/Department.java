package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * 学校从属部门类
 * @author Administrator
 *
 */
@Data
@TableName("tb_department")
public class Department implements Serializable{

	private String id;//ID

	private String name;//部门名

	@TableField("tb_department_type_id")
	private String departmentTypeId;//主管部门类别




}
