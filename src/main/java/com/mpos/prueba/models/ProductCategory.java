package com.mpos.prueba.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {
	
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NAME", length = 50, unique = true)
	private String name;
    
    @Column(name = "DATE_OF_CREATION")
	private Date dateOfCreation;
    
    @Column(name = "DATE_OF_LAST_UPDATE")
	private Date dateOfLastUpdate;
    
    @Column(name = "STATE")
	private int state;
     
    @OneToMany(mappedBy="productCategory")
    private List<Product> products;
     
	public ProductCategory(Long id, String name, Date dateOfCreation, Date dateOfLastUpdate,
			int state, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfCreation = dateOfCreation;
		this.dateOfLastUpdate = dateOfLastUpdate;
		this.state = state;
		this.products = products;
	}
		
	public ProductCategory() {
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	   
}
