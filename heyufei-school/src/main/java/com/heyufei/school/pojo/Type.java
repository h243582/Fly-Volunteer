package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * 院校类型类
 * @author Administrator
 *
 */
@Data
@TableName("tb_type")
public class Type implements Serializable{

	private String id;//ID

	private String name;//院校类型名




}
