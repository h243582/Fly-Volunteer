package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 专业具体名称表
 *
 */
@Data
@TableName("tb_major")
public class Major implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 专业名
	 */
	private String name;
	/**
	 * 专业代码
	 */
	private String majorCode;
	/**
	 * 专业满意度
	 */
	private BigDecimal satisfaction;
	/**
	 * 从属专业类
	 */
	private Integer tbMajorProfessionalCategoryId;

}
