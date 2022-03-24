package com.heyufei.school.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 学校和专业对应表
 *
 */
@Data
public class SchoolMajorDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 专业id
	 */
	private Integer tbMajorId;
	/**
	 * 学制
	 */
	private String educationalSystem;
	/**
	 * 培养目标
	 */
	private String trainingObjectives;


	/**
	 * 推荐指数
	 */
	private BigDecimal recommendSatisfaction;
	/**
	 * 推荐人数
	 */
	private Integer recommendedNumber;


	/**
	 * 综合满意度
	 */
	private BigDecimal comprehensiveSatisfaction;
	/**
	 * 综合满意度人数
	 */
	private Integer comprehensiveNumber;


	/**
	 * 办学条件满意度
	 */
	private BigDecimal conditionsSatisfaction;
	/**
	 * 办学条件满意度人数
	 */
	private Integer conditionsNumber;


	/**
	 * 教学质量满意度
	 */
	private BigDecimal qualitySatisfaction;
	/**
	 * 教学质量满意度人数
	 */
	private Integer qualityNumber;


	/**
	 * 就业满意度
	 */
	private BigDecimal jobSatisfaction;
	/**
	 * 就业满意度人数
	 */
	private Integer jobNumber;
}
