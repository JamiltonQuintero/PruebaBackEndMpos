package com.mpos.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByName(String productName);
	
	List<Product> findByProductCategoryIn(ProductCategory category);

}
