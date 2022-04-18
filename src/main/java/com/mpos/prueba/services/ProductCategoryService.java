package com.mpos.prueba.services;

import java.util.List;

import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;
import com.mpos.to.ProductCategoryPostTO;
import com.mpos.to.ProductCategoryPutTO;

public interface ProductCategoryService {
	
	void saveProductCategory(ProductCategoryPostTO productCategoryPostTO);
	
	void updateProductCategory(Long id, ProductCategoryPutTO productCategoryPutTO);
	
	ProductCategory getProductCategoryById(Long id);
	
	ProductCategory getProductCategoryByName(String name);
		
	List<ProductCategory> getProductCategoryByProduct(Product category);
	
	void changeStateProductCategoryById(Long id, int newState);
	
	List<ProductCategory> getAllProductsCategory();

}
