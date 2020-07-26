package com.acxiom.ecplatform.modules.sample.domain;

import com.acxiom.ecplatform.common.annotation.PrimaryKey;

import java.io.Serializable;

public class SampleTestEO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5047210670923370377L;

	@PrimaryKey
	private Integer id;

	private Integer type;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
