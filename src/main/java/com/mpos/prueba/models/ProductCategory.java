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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
