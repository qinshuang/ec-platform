package com.acxiom.ecplatform.modules.sample.service;

import com.acxiom.ecplatform.modules.sample.domain.SampleTestEO;

public interface ISampleTestService {

	int addUserTest();
	
	SampleTestEO getUserByName(String name);
}
