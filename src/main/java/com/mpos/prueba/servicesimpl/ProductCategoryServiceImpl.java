package com.mpos.prueba.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpos.prueba.enums.EState;
import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;
import com.mpos.prueba.repositories.ProductCategoryRepository;
import com.mpos.prueba.services.ProductCategoryService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.prueba.utils.UtilDate;
import com.mpos.to.ProductCategoryPostTO;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private UtilDate utilDate;
    
    @Autowired(required=true)
    MapStructMapper mapStructMapper;
    
	@Override
	public void saveUpdateProductCategory(ProductCategoryPostTO productCategoryPostTO) {
		
		Date currentDate =utilDate.getCurrentDate();	
		
		ProductCategory productCategory = mapStructMapper.ProductCategoryPostTOToProduct(productCategoryPostTO);
		productCategory.setDateOfCreation(currentDate);
		productCategory.setDateOfLastUpdate(currentDate);
		productCategory.setState(EState.ACTIVE.getId());
		save(productCategory);
	
	}

	@Override
	public ProductCategory getProductCategoryById(Long id) {
		ProductCategory productCategoryById = findProductCategoryById(id);
		return productCategoryById;
	}

	@Override
	public ProductCategory getProductCategoryByName(String name) {
		ProductCategory productCategoryByName = productCategoryRepository.findByName(name);
		return productCategoryByName;
	}

	@Override
	public List<ProductCategory> getProductCategoryByProduct(Product product) {
		
		List<ProductCategory> lProductsCategoriesByProduct = productCategoryRepository.findByProductsIn(product);
		return lProductsCategoriesByProduct;
	}

	@Override
	public void changeStateProductCategoryById(Long id, int newState) {
		ProductCategory productCategoryById =  findProductCategoryById(id);		
		productCategoryById.setState(newState);	
		save(productCategoryById);
	}
	
	
	private ProductCategory findProductCategoryById(Long id) {
		ProductCategory productCategoryById =  productCategoryRepository.findById(id).get();	
		return productCategoryById;
	}
	
	private void save(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);	
	}

}
