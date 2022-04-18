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

public class UserCompleteReportTO {
	
	@JsonProperty("fullName")
    private String fullName;
	
	@JsonProperty("username")
    private String username;
	
	@JsonProperty("password")
    private String password;
	
	@JsonProperty("email")
    private String email;
	
	@JsonProperty("dateOfCreation")
	private Date dateOfCreation;
	
	@JsonProperty("dateOfLastEntry")
	private Date dateOfLastEntry;
	
	@JsonProperty("lastPasswordResetDate")
    private Date lastPasswordResetDate;
	
	@JsonProperty("state")
    private int state;
    	
}
