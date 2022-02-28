package com.heyufei.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heyufei.school.pojo.School;
import com.heyufei.school.pojo.dto.SchoolDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface SchoolMapper extends BaseMapper<School> {

    List<SchoolDto> findSearch(Map<String, Object> map);

    Long findCount(Map<String, Object> map);


}
