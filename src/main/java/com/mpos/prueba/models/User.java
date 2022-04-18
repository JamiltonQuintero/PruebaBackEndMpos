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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_mpos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}