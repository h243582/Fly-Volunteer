package com.heyufei.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heyufei.school.pojo.SchoolMajor;
import com.heyufei.school.pojo.dto.SchoolMajorDto;

import java.util.List;

public interface SchoolMajorMapper extends BaseMapper<SchoolMajor> {
    public List<SchoolMajorDto> findByIdDescComprehensiveSatisfaction(String id);

    public List<SchoolMajorDto> findByIdDescComprehensiveSatisfaction(String id);

}
