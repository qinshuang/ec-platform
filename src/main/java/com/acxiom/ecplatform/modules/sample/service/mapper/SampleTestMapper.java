package com.acxiom.ecplatform.modules.sample.service.mapper;

import com.acxiom.ecplatform.common.mapper.BaseMapper;
import com.acxiom.ecplatform.modules.sample.domain.SampleTestEO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SampleTestMapper extends BaseMapper<SampleTestEO>{
	SampleTestEO getUserByName(@Param(value = "name") String name);

}
