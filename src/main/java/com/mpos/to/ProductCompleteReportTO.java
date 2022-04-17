package com.mpos.to;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCompleteReportTO {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private float price;
	
	@JsonProperty("productCategory")
	private ProductCategoryGetTO productCategory;
	
	@JsonProperty("listOfTags")
	private List<String> listOfTags;
	
	@JsonProperty("dateOfCreation")
	private Date dateOfCreation;
	
	@JsonProperty("dateOfLastUpdate")
    private Date dateOfLastUpdate;
	
	@JsonProperty("state")
    private int state;

	public ProductCompleteReportTO(Long id, String name, float price, ProductCategoryGetTO productCategory,
			List<String> listOfTags, Date dateOfCreation, Date dateOfLastUpdate, int state) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productCategory = productCategory;
		this.listOfTags = listOfTags;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastUpdate = dateOfLastUpdate;
		this.state = state;
	}

	public ProductCompleteReportTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public ProductCategoryGetTO getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryGetTO productCategory) {
		this.productCategory = productCategory;
	}

	public List<String> getListOfTags() {
		return listOfTags;
	}

	public void setListOfTags(List<String> listOfTags) {
		this.listOfTags = listOfTags;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfLastUpdate() {
		return dateOfLastUpdate;
	}

	public void setDateOfLastUpdate(Date dateOfLastUpdate) {
		this.dateOfLastUpdate = dateOfLastUpdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
