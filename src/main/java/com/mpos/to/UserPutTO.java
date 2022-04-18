package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPutTO {
	
	@JsonProperty("fullName")
    private String fullName;
	
	@JsonProperty("username")
    private String username;
	
	@JsonProperty("email")
    private String email;
    
	public UserPutTO(String fullName, String username, String email) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
	}

	public UserPutTO() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
