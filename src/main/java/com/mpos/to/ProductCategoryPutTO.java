package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryPutTO {

	@JsonProperty("name")
	private String name;

	public ProductCategoryPutTO(String name) {
		super();
		this.name = name;
	}

	public ProductCategoryPutTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			
}
