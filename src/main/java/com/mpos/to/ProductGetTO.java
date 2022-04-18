package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductGetTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productCategory")
	private ProductCategoryGetTO productCategory;
	
	@JsonProperty("price")
	private float price;

}
