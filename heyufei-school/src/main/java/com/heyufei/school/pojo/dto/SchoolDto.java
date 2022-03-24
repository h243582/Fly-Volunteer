package com.heyufei.school.pojo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class SchoolDto implements Serializable {

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
