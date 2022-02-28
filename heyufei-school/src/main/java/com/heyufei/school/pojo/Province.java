package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * 省份类
 * @author Administrator
 *
 */
@Data
@TableName("tb_province")
public class Province implements Serializable{

	private String id;//ID



	private String name;//省份名




}
