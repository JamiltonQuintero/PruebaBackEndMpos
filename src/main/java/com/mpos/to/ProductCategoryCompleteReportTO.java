package com.mpos.to;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
