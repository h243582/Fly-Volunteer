package com.heyufei.school.pojo.dto;


import lombok.Data;

@Data
public class SchoolDto {

    private String id;

    private String schoolName;
    private String province;
    private String department;
    private String schoolType;
    private String level;

    private Boolean isTopUniversity;
    private Boolean isTopDiscipline;
    private Boolean hasGraduateSchool;
    private String satisfaction;



}
