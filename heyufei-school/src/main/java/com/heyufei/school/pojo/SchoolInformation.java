package com.heyufei.school.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学校具体信息
 */
@Data
@TableName("tb_school_information")
public class SchoolInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;
	/**
	 * 学校id
	 */
	private String tbSchoolId;
	/**
	 * 学校头像
	 */
	private String avatar;
	/**
	 * 学校信息更新时间
	 */
	private Date updateTime;
	/**
	 * 学校领导
	 */
	private String leaders;
	/**
	 * 学校简介
	 */
	private String introduce;
	/**
	 * 周边环境
	 */
	private String environment;
	/**
	 * 通讯地址
	 */
	private String postalAddress;
	/**
	 * 联系电话
	 */
	private String telephone;
	/**
	 * 重点实验室
	 */
	private String keyLaboratory;
	/**
	 * 重点学科
	 */
	private String keyDisciplines;
	/**
	 * 可授予的学位
	 */
	private String conferableDegrees;
	/**
	 * 师资力量
	 */
	private String faculty;
	/**
	 * 学生人数
	 */
	private String studentsNumber;
	/**
	 * 录取批次
	 */
	private String admissionBatch;
	/**
	 * 对艺术类招生的录取办法
	 */
	private String artEnrollment;
	/**
	 * 加分政策
	 */
	private String extraPoints;
	/**
	 * 对少数民族考生的特殊政策
	 */
	private String ethnicMinority;
	/**
	 * 对往届生的录取政策
	 */
	private String previousStudents;
	/**
	 * 转专业的实施办法
	 */
	private String transferMajor;
	/**
	 * 其它
	 */
	private String other;
	/**
	 * 奖学金设置
	 */
	private String scholarship;
	/**
	 * 困难生资助办法
	 */
	private String difficultStudent;
	/**
	 * 宿舍
	 */
	private String dormitory;
	/**
	 * 食堂
	 */
	private String canteen;
	/**
	 * 其它
	 */
	private String averageFood;
	/**
	 * 往年录取信息
	 */
	private String admissionInformation;

}
