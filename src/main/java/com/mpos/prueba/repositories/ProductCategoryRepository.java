package com.mpos.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	
	ProductCategory findByName(String productCategoryName);
	
	List<ProductCategory> findByProductsIn(Product product);

}
