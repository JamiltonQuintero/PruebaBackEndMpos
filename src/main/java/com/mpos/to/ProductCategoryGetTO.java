package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryGetTO {

	@JsonProperty("name")
	private String name;
	
	public ProductCategoryGetTO(String name) {
		super();
		this.name = name;
	}

	public ProductCategoryGetTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
