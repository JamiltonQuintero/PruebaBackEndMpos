package com.mpos.prueba.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NAME", length = 50, unique = true)
	private String name;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_category_id", nullable=false)
	private ProductCategory productCategory;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "LIST_OF_TAGS")
	@ElementCollection(targetClass=String.class)
	private List<String> listOfTags;
	
	@Column(name = "DATE_OF_CREATION")
	private Date dateOfCreation;
	
	@Column(name = "DATE_OF_LAST_UPDATE")
	private Date dateOfLastUpdate;
	
	@Column(name = "STATE")
	private int state;

}
