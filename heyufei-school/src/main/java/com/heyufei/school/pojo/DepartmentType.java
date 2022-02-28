package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * 主管部门类别类
 * @author Administrator
 *
 */
@Data
@TableName("tb_department_type")
public class DepartmentType implements Serializable{


	private String id;//ID

	private String name;//主管部门类别





}
