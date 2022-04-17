package com.mpos.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductGetTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productCategory")
	private ProductCategoryGetTO productCategory;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("listOfTags")
	private List<String> listOfTags;
	
	public ProductGetTO(String name, ProductCategoryGetTO productCategory, float price, List<String> listOfTags) {
		super();
		this.name = name;
		this.productCategory = productCategory;
		this.price = price;
		this.listOfTags = listOfTags;
	}
	
	public ProductGetTO() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductCategoryGetTO getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategoryGetTO productCategory) {
		this.productCategory = productCategory;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<String> getListOfTags() {
		return listOfTags;
	}
	public void setListOfTags(List<String> listOfTags) {
		this.listOfTags = listOfTags;
	}

}
