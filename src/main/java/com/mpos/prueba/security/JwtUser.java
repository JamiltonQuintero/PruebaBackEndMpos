package com.mpos.prueba.security;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1215456216545L;

    private final Long id;
    private final String fullName;
    private final String username;
    private final String password;
    private final String email;
	private final Date dateOfCreation;
	private final Date dateOfLastEntry;
	private final Date lastPasswordResetDate;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean state;




    public JwtUser(Long id, String fullName, String username, String password, String email, Date dateOfCreation,
			Date dateOfLastEntry, Date lastPasswordResetDate, Collection<? extends GrantedAuthority> authorities, boolean state) {
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

	@JsonIgnore
    public Long getId() {
        return id;
    }
	
    public String getFullName() {
		return fullName;
	}

	@Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

	@Override
	public boolean isEnabled() {
		return state;
	}
    
    @JsonIgnore
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	
	@JsonIgnore
	public Date getDateOfLastEntry() {
		return dateOfLastEntry;
	}
	
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
