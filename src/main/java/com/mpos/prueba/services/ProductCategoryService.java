package com.mpos.prueba.services;

import java.util.List;

import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;
import com.mpos.to.ProductCategoryPostTO;

public interface ProductCategoryService {
	
	void saveUpdateProductCategory(ProductCategoryPostTO productCategoryPostTO);
	
	ProductCategory getProductCategoryById(Long id);
	
	ProductCategory getProductCategoryByName(String name);
	
	List<ProductCategory> getProductCategoryByProduct(Product category);
	
	void changeStateProductCategoryById(Long id, int newState);

}
