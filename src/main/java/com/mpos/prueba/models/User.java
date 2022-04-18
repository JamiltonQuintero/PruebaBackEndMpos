package com.mpos.prueba.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_mpos")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "FULL_NAME", length = 50)
    private String fullName;
    
    @Column(name = "USERNAME", length = 50, unique = true)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    private String password;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "DATE_OF_CREATION")
	private Date dateOfCreation;
     
    @Column(name = "DATE_OF_LAST_ENTRY")
	private Date dateOfLastEntry;
    
    @Column(name = "LASTPASSWORDRESETDATE")
    private Date lastPasswordResetDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;
    
    @Column(name = "STATE")
	private int state;

    
	public User(Long id, String fullName, String username, String password, String email, Date dateOfCreation,
			Date dateOfLastEntry, Date lastPasswordResetDate, List<Authority> authorities, int state) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastEntry = dateOfLastEntry;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.authorities = authorities;
		this.state = state;
	}


	public User(String fullName, String username, String password, String email, Date dateOfCreation,
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
	
	
	public User(String fullName, String username, String password, String email) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String fullName, String username, String email) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
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

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public int isState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
    
}