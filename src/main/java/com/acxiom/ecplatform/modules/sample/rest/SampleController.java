package com.acxiom.ecplatform.modules.sample.rest;

import com.acxiom.ecplatform.modules.sample.service.ISampleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample/test")
public class SampleController {
	
	@Autowired
	private ISampleTestService sampleTestService;

	// 新增
	@ResponseBody
	@RequestMapping(value = "/add")
	public Integer add() {
		return sampleTestService.addUserTest();
	}

	@ResponseBody
	@RequestMapping(value = "/getUserByName")
	public String getUserByName(@RequestParam("name") String name) {
		return sampleTestService.getUserByName(name).toString();
	}
}
