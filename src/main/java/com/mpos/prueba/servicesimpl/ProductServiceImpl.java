package com.mpos.prueba.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpos.prueba.enums.EState;
import com.mpos.prueba.models.Product;
import com.mpos.prueba.repositories.ProductCategoryRepository;
import com.mpos.prueba.repositories.ProductRepository;
import com.mpos.prueba.services.ProductService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.prueba.utils.UtilDate;
import com.mpos.to.ProductPostTO;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    
    @Autowired
    private UtilDate utilDate;
    
    @Autowired(required=true)
    MapStructMapper mapStructMapper;
    
    @Autowired
    ProductCategoryRepository categoryRepository;
    
	@Override
	public void saveUpdateProduct(ProductPostTO productPostTO) {
	
		Date currentDate =utilDate.getCurrentDate();	
		
		Product product = mapStructMapper.productPostTOToProduct(productPostTO);
		product.setProductCategory(productCategoryRepository.findById(productPostTO.getProductCategoryId()).get());
		product.setDateOfCreation(currentDate);
		product.setDateOfLastUpdate(currentDate);
		product.setState(EState.ACTIVE.getId());
		save(product);
	}

	@Override
	public Product getProductById(Long id) {
		
		Product productById = findProductById(id);	
		return productById;		
	}

	@Override
	public Product getProductByName(String name) {
		
		Product productByName = productRepository.findByName(name);
		
		return productByName;
	}

	
	@Override
	public List<Product> getProductsByProductCategoryId(Long productCategoryId) {
		
		List<Product> lProductsByProductCategory = productRepository.findByProductCategoryIn(categoryRepository.findById(productCategoryId).get());	
		return lProductsByProductCategory;
	}

	@Override
	public void changeStateProductById(Long id,int newState) {
		Product productById =  findProductById(id);		
		productById.setState(newState);	
		save(productById);
	}
	
	
	private Product findProductById(Long id) {
		Product userById =  productRepository.findById(id).get();	
		return userById;
	}
	
	private void save(Product product) {
		productRepository.save(product);	
	}



}
