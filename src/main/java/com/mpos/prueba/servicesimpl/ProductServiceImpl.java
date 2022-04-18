package com.mpos.prueba.servicesimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mpos.prueba.enums.EStateProduct;
import com.mpos.prueba.models.Product;
import com.mpos.prueba.repositories.ProductCategoryRepository;
import com.mpos.prueba.repositories.ProductRepository;
import com.mpos.prueba.services.ProductService;
import com.mpos.prueba.utils.IMsmStrings;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.prueba.utils.UtilDate;
import com.mpos.to.ProductPostTO;
import com.mpos.to.ProductPutTO;


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
	public void saveProduct(ProductPostTO productPostTO) {
	
		Date currentDate = utilDate.getCurrentDate();	
		
		Product product = mapStructMapper.productPostTOToProduct(productPostTO);
		product.setProductCategory(productCategoryRepository.findById(productPostTO.getProductCategoryId()).get());
		product.setDateOfCreation(currentDate);
		product.setDateOfLastUpdate(currentDate);
		product.setState(EStateProduct.ACTIVE.getId());
		save(product);
	}
	
	@Override
	public void updateProduct(Long id, ProductPutTO productPutTO) {
	
		Date currentDate =utilDate.getCurrentDate();	
		
		Product product = productRepository.findById(id).get();
		product.setName(productPutTO.getName());
		product.setPrice(productPutTO.getPrice());
		if(productPutTO.getProductCategoryId() != product.getProductCategory().getId()) {
			product.setProductCategory(productCategoryRepository.findById(productPutTO.getProductCategoryId()).get());
		}	
		product.setDateOfLastUpdate(currentDate);
		save(product);
	}

	@Override
	public Product getProductById(Long id) {
		
		Product productById = findProductById(id, false);	
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
		return filterProductDiferentStateInactiveAndEliminated(lProductsByProductCategory);
	}

	@Override
	public void changeStateProductById(Long id,int newState) {
		Product productById =  findProductById(id, true);		
		productById.setState(newState);	
		save(productById);
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> lAllProducts = productRepository.findAll();
		return filterProductDiferentStateInactiveAndEliminated(lAllProducts);
	}
	
	
	private Product findProductById(Long id, boolean isChangeState) {
		Product productById =  productRepository.findById(id).get();
		if(!isChangeState) {
			if(EStateProduct.ELIMINATED.getId() == productById.isState() || EStateProduct.INACTIVE.getId() == productById.isState()) {
				throw new UsernameNotFoundException(String.format(IMsmStrings.MSM_NOT_FOUND_INACTIVE_OR_ELIMINATED, id));			
			}
		}
		return productById;
	}
	
	private void save(Product product) {
		productRepository.save(product);	
	}


	private List<Product> filterProductDiferentStateInactiveAndEliminated(List<Product> lProducts) {
		return lProducts.stream().filter(product -> product.isState() != EStateProduct.ELIMINATED.getId() && product.isState() != EStateProduct.INACTIVE.getId())
				.collect(Collectors.toList());	 
	}
	
}
