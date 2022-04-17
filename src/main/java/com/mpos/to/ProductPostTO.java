package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPostTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productCategoryId")
	private Long productCategoryId;
	
	@JsonProperty("price")
	private float price;

	public ProductPostTO(String name, Long productCategoryId, float price) {
		super();
		this.name = name;
		this.productCategoryId = productCategoryId;
		this.price = price;
	}

	public ProductPostTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
