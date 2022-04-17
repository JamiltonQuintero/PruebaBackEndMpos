package com.mpos.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPostTO {
	
	@JsonProperty("fullName")
    private String fullName;
	
	@JsonProperty("username")
    private String username;
	
	@JsonProperty("password")
    private String password;
	
	@JsonProperty("email")
    private String email;
    
	public UserPostTO(String fullName, String username, String password, String email) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public UserPostTO() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
