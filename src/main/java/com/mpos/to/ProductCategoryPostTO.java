package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryPostTO {

	@JsonProperty("name")
	private String name;

	public ProductCategoryPostTO(String name) {
		super();
		this.name = name;
	}

	public ProductCategoryPostTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			
}
