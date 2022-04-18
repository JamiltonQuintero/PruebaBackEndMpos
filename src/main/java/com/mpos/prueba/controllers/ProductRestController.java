package com.mpos.prueba.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mpos.prueba.services.ProductService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.to.ProductCompleteReportTO;
import com.mpos.to.ProductGetTO;
import com.mpos.to.ProductPostTO;
import com.mpos.to.ProductPutTO;

@RestController
@RequestMapping(path = "/api/product")
public class ProductRestController {
	
	private static Logger _logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	ProductService productService;
	
	@Autowired(required=true)
	MapStructMapper mapStructMapper;
	
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductPostTO productPostTO) {
    	try {
    		productService.saveProduct(productPostTO);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping(path = "/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestParam(required = true) Long id, @RequestBody ProductPutTO productPutTO) {
    	try {
    		productService.updateProduct(id, productPutTO);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductById")
    public ResponseEntity<?> getProductById(@RequestParam(required = true) Long id) {
    	try {
    		ProductGetTO productById = mapStructMapper.productToProductGetTO(productService.getProductById(id));   		
    	    return new ResponseEntity<>(productById,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductByIdForCompleteReport")
    public ResponseEntity<?> getProductByIdForCompleteReport(@RequestParam(required = true) Long id) {
    	try {
    		ProductCompleteReportTO productById = mapStructMapper.productToProductCompleteReportTO(productService.getProductById(id));   		
    	    return new ResponseEntity<>(productById,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductByName")
    public ResponseEntity<?> getProductByName(@RequestParam(required = true) String name) {
    	try {
    		
    		ProductGetTO productByName = mapStructMapper.productToProductGetTO(productService.getProductByName(name));   		
    	
    	    return new ResponseEntity<>(productByName, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getAllProducts")
    public ResponseEntity<?> getAllProducts() {
    	try {
    		
    		List<ProductGetTO> lAllProducts = mapStructMapper.productsToProductsGetTOs(productService.getAllProducts());   		
    	
    	    return new ResponseEntity<>(lAllProducts, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductsByProductCategory")
    public ResponseEntity<?> getProductsByProductCategory(@RequestParam(required = true) Long productCategoryId) {
    	try {
    		List<ProductGetTO> lProductsByProductCategory = mapStructMapper.productsToProductsGetTOs(productService.getProductsByProductCategoryId(productCategoryId));
    	    return new ResponseEntity<>(lProductsByProductCategory, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/changeStateProductById")
    public ResponseEntity<?> changeStateProductById(@RequestParam(required = true) Long id, @RequestParam(required = true) int newState) {
    	try {
    		productService.changeStateProductById(id, newState);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
}
