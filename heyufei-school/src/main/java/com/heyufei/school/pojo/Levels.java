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
@TableName("tb_levels")
public class Levels implements Serializable{

	private String id;//ID



	private String name;//学历层次名




}
