package com.mpos.prueba.servicesimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mpos.prueba.enums.EState;
import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;
import com.mpos.prueba.repositories.ProductCategoryRepository;
import com.mpos.prueba.services.ProductCategoryService;
import com.mpos.prueba.utils.IMsmStrings;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.prueba.utils.UtilDate;
import com.mpos.to.ProductCategoryPostTO;
import com.mpos.to.ProductCategoryPutTO;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private UtilDate utilDate;
    
    @Autowired(required=true)
    MapStructMapper mapStructMapper;
    
	@Override
	public void saveProductCategory(ProductCategoryPostTO productCategoryPostTO) {
		
		Date currentDate =utilDate.getCurrentDate();	
		
		ProductCategory productCategory = mapStructMapper.productCategoryPostTOToProduct(productCategoryPostTO);
		productCategory.setDateOfCreation(currentDate);
		productCategory.setDateOfLastUpdate(currentDate);
		productCategory.setState(EState.ACTIVE.getId());
		save(productCategory);
	
	}
	
	@Override
	public void updateProductCategory(Long id, ProductCategoryPutTO productCategoryPutTO) {
		
		Date currentDate = utilDate.getCurrentDate();		
		ProductCategory productCategory = productCategoryRepository.findById(id).get();
		productCategory.setName(productCategoryPutTO.getName());
		productCategory.setDateOfLastUpdate(currentDate);
		save(productCategory);	
	}

	@Override
	public ProductCategory getProductCategoryById(Long id) {
		ProductCategory productCategoryById = findProductCategoryById(id, false);
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
		return filterProductCategoryDiferentStateInactiveAndEliminated(lProductsCategoriesByProduct);
	}

	@Override
	public void changeStateProductCategoryById(Long id, int newState) {
		ProductCategory productCategoryById =  findProductCategoryById(id, true);		
		productCategoryById.setState(newState);	
		save(productCategoryById);
	}
	
	@Override
	public List<ProductCategory> getAllProductsCategory() {
		
		List<ProductCategory> lAllProductCategory = productCategoryRepository.findAll();
		
		return filterProductCategoryDiferentStateInactiveAndEliminated(lAllProductCategory);
	}
	
	private ProductCategory findProductCategoryById(Long id, boolean isChangeState) {
		
		ProductCategory productCategoryById =  productCategoryRepository.findById(id).get();
		if(!isChangeState) {
			if(EState.ELIMINATED.getId() == productCategoryById.getState() || EState.INACTIVE.getId() == productCategoryById.getState()) {
				throw new UsernameNotFoundException(String.format(IMsmStrings.MSM_NOT_FOUND_INACTIVE_OR_ELIMINATED, id));			
			}
		}
		
		return productCategoryById;
	}
	
	private void save(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);	
	}


	private List<ProductCategory> filterProductCategoryDiferentStateInactiveAndEliminated(List<ProductCategory> lProductCategory) {
		return lProductCategory.stream().filter(productCategory -> productCategory.getState() != EState.ELIMINATED.getId() && productCategory.getState() != EState.INACTIVE.getId())
		.collect(Collectors.toList());
		 
	}

}
