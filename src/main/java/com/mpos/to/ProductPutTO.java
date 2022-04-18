package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPutTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productCategoryId")
	private Long productCategoryId;
	
	@JsonProperty("price")
	private float price;

	public ProductPutTO(String name, Long productCategoryId, float price) {
		super();
		this.name = name;
		this.productCategoryId = productCategoryId;
		this.price = price;
	}

	public ProductPutTO() {
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
