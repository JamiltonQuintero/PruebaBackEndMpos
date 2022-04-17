package com.mpos.prueba.services;

import java.util.List;
import com.mpos.prueba.models.Product;
import com.mpos.to.ProductPostTO;

public interface ProductService {
	
	void saveUpdateProduct(ProductPostTO productPostTO);
	
	Product getProductById(Long id);
	
	Product getProductByName(String name);
	
	List<Product> getProductsByProductCategoryId(Long productCategoryId);
	
	void changeStateProductById(Long id, int newState);

}
