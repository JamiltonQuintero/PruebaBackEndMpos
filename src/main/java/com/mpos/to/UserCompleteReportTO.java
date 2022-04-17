package com.mpos.to;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    
	public UserCompleteReportTO(String fullName, String username, String password, String email, Date dateOfCreation,
			Date dateOfLastEntry, Date lastPasswordResetDate, int state) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastEntry = dateOfLastEntry;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.state = state;
	}

	public UserCompleteReportTO() {
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

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfLastEntry() {
		return dateOfLastEntry;
	}

	public void setDateOfLastEntry(Date dateOfLastEntry) {
		this.dateOfLastEntry = dateOfLastEntry;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
		
}
