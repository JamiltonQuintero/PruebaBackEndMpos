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

@Entity
@Table(name = "product")
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

	public Product(Long id, String name, ProductCategory productCategory, float price, List<String> listOfTags,
			Date dateOfCreation, Date dateOfLastUpdate, int state) {
		super();
		this.id = id;
		this.name = name;
		this.productCategory = productCategory;
		this.price = price;
		this.listOfTags = listOfTags;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastUpdate = dateOfLastUpdate;
		this.state = state;
	}
		
	public Product(String name, ProductCategory productCategory, float price, List<String> listOfTags,
			Date dateOfCreation, Date dateOfLastUpdate, int state) {
		super();
		this.name = name;
		this.productCategory = productCategory;
		this.price = price;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastUpdate = dateOfLastUpdate;
		this.state = state;
	}



	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<String> getListOfTags() {
		return listOfTags;
	}

	public void setListOfTags(List<String> listOfTags) {
		this.listOfTags = listOfTags;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfLastUpdate() {
		return dateOfLastUpdate;
	}

	public void setDateOfLastUpdate(Date dateOfLastUpdate) {
		this.dateOfLastUpdate = dateOfLastUpdate;
	}

	public int isState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
		
}
