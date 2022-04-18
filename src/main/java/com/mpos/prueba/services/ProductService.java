package com.mpos.prueba.services;

import java.util.List;
import com.mpos.prueba.models.Product;
import com.mpos.to.ProductPostTO;
import com.mpos.to.ProductPutTO;

public interface ProductService {
	
	void saveProduct(ProductPostTO productPostTO);
	
	void updateProduct(Long id,ProductPutTO productPutTO);
	
	Product getProductById(Long id);
	
	Product getProductByName(String name);
	
	List<Product> getProductsByProductCategoryId(Long productCategoryId);
	
	void changeStateProductById(Long id, int newState);
	
	List<Product> getAllProducts();

}
