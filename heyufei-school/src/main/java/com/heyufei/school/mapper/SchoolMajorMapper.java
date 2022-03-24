package com.heyufei.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heyufei.school.pojo.SchoolMajor;
import com.heyufei.school.pojo.dto.SchoolMajorDto;

import java.util.List;

public interface SchoolMajorMapper extends BaseMapper<SchoolMajor> {
    /**
     * 综合满意度
     */
    public List<SchoolMajorDto> findByIdDescComprehensiveSatisfaction(String id);

    /**
     * 推荐指数
     */
    public List<SchoolMajorDto> findByIdDescRecommendSatisfaction(String id);

    /**
     * 专业推荐人数
     */
    public List<SchoolMajorDto> findByIdDescRecommendNumber(String id);


}
