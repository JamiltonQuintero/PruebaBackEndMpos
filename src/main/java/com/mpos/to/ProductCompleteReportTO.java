package com.mpos.to;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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
	
}
