package com.acxiom.ecplatform.modules.sample.service.impl;

import com.acxiom.ecplatform.modules.sample.domain.SampleTestEO;
import com.acxiom.ecplatform.modules.sample.service.mapper.SampleTestMapper;
import com.acxiom.ecplatform.modules.sample.service.ISampleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleTestServiceImpl implements ISampleTestService {

	@Autowired
	private SampleTestMapper sampleTestMapper;

	@Override
	public int addUserTest() {
		SampleTestEO entity = new SampleTestEO();
		entity.setName("test");
		entity.setType(3);
		return sampleTestMapper.add(entity);
	}

	@Override
	public SampleTestEO getUserByName(String name) {
		return sampleTestMapper.getUserByName(name);
	}

}
