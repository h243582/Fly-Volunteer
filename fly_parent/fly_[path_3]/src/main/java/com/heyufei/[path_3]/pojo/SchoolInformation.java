package com.heyufei.pojo;

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
@Table(name="tb_school_information")
public class SchoolInformation implements Serializable{

	@Id
	private Integer id;//ID


	
	private String tb_school_id;//学校id
	private java.util.Date update_time;//学校信息更新时间
	private String leaders;//学校领导
	private String introduce;//学校简介
	private String environment;//周边环境
	private String postal_address;//通讯地址
	private String telephone;//联系电话
	private String key_laboratory;//重点实验室
	private String key_disciplines;//重点学科
	private String conferable_degrees;//可授予的学位
	private String faculty;//师资力量
	private String students_number;//学生人数
	private String admission_batch;//录取批次
	private String art_enrollment;//对艺术类招生的录取办法
	private String extra_points;//加分政策
	private String ethnic_minority;//对少数民族考生的特殊政策
	private String previous_students;//对往届生的录取政策
	private String transfer_major;//转专业的实施办法
	private String other;//其它
	private String scholarship;//奖学金设置
	private String difficult_student;//困难生资助办法
	private String dormitory;//宿舍
	private String canteen;//食堂
	private String average_food;//其它
	private String admission_information;//往年录取信息

	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTb_school_id() {		
		return tb_school_id;
	}
	public void setTb_school_id(String tb_school_id) {
		this.tb_school_id = tb_school_id;
	}

	public java.util.Date getUpdate_time() {		
		return update_time;
	}
	public void setUpdate_time(java.util.Date update_time) {
		this.update_time = update_time;
	}

	public String getLeaders() {		
		return leaders;
	}
	public void setLeaders(String leaders) {
		this.leaders = leaders;
	}

	public String getIntroduce() {		
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getEnvironment() {		
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPostal_address() {		
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	public String getTelephone() {		
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getKey_laboratory() {		
		return key_laboratory;
	}
	public void setKey_laboratory(String key_laboratory) {
		this.key_laboratory = key_laboratory;
	}

	public String getKey_disciplines() {		
		return key_disciplines;
	}
	public void setKey_disciplines(String key_disciplines) {
		this.key_disciplines = key_disciplines;
	}

	public String getConferable_degrees() {		
		return conferable_degrees;
	}
	public void setConferable_degrees(String conferable_degrees) {
		this.conferable_degrees = conferable_degrees;
	}

	public String getFaculty() {		
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getStudents_number() {		
		return students_number;
	}
	public void setStudents_number(String students_number) {
		this.students_number = students_number;
	}

	public String getAdmission_batch() {		
		return admission_batch;
	}
	public void setAdmission_batch(String admission_batch) {
		this.admission_batch = admission_batch;
	}

	public String getArt_enrollment() {		
		return art_enrollment;
	}
	public void setArt_enrollment(String art_enrollment) {
		this.art_enrollment = art_enrollment;
	}

	public String getExtra_points() {		
		return extra_points;
	}
	public void setExtra_points(String extra_points) {
		this.extra_points = extra_points;
	}

	public String getEthnic_minority() {		
		return ethnic_minority;
	}
	public void setEthnic_minority(String ethnic_minority) {
		this.ethnic_minority = ethnic_minority;
	}

	public String getPrevious_students() {		
		return previous_students;
	}
	public void setPrevious_students(String previous_students) {
		this.previous_students = previous_students;
	}

	public String getTransfer_major() {		
		return transfer_major;
	}
	public void setTransfer_major(String transfer_major) {
		this.transfer_major = transfer_major;
	}

	public String getOther() {		
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}

	public String getScholarship() {		
		return scholarship;
	}
	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}

	public String getDifficult_student() {		
		return difficult_student;
	}
	public void setDifficult_student(String difficult_student) {
		this.difficult_student = difficult_student;
	}

	public String getDormitory() {		
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getCanteen() {		
		return canteen;
	}
	public void setCanteen(String canteen) {
		this.canteen = canteen;
	}

	public String getAverage_food() {		
		return average_food;
	}
	public void setAverage_food(String average_food) {
		this.average_food = average_food;
	}

	public String getAdmission_information() {		
		return admission_information;
	}
	public void setAdmission_information(String admission_information) {
		this.admission_information = admission_information;
	}


	
}
