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

public class ProductPutTO {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productCategoryId")
	private Long productCategoryId;
	
	@JsonProperty("price")
	private float price;

}
