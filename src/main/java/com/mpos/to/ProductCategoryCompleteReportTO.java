package com.mpos.to;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCategoryCompleteReportTO {
	
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("dateOfCreation")
	private Date dateOfCreation;
	
	@JsonProperty("dateOfLastUpdate")
	private Date dateOfLastUpdate;
	
	@JsonProperty("state")
	private int state;
}
