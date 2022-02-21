package com.heyufei.school.pojo.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class SchoolDto {
//    sc.id, sc.name, pr.name provinceName, de.name departmentName, type.name schoolType, le.name,
//       top_university, sc.top_discipline, sc.graduate_school, sc.satisfaction
select sc.id, sc.name, pr.name provinceName, de.name departmentName, type.name schoolType, le.name,
    top_university, sc.top_discipline, sc.graduate_school, sc.satisfaction
    from tb_school sc,tb_province pr,tb_department de,tb_type type,tb_levels le
    where sc.tb_province_id = pr.id and sc.tb_department_id = de.id and sc.tb_type_id = type.id and sc.tb_levels_id = le.id

    limit 1,50;





    private String

}
