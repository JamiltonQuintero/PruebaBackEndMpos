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
import com.mpos.prueba.services.ProductCategoryService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.to.ProductCategoryCompleteReportTO;
import com.mpos.to.ProductCategoryGetTO;
import com.mpos.to.ProductCategoryPostTO;
import com.mpos.to.ProductCategoryPutTO;


@RestController
@RequestMapping(path = "/api/productCategory")
public class ProductCategoryRestController {
	
	private static Logger _logger = LoggerFactory.getLogger(ProductCategoryRestController.class);

    
    @Autowired
	ProductCategoryService productCategoryService;
    
    @Autowired(required=true)
	MapStructMapper mapStructMapper;
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/saveProductCategory")
    public ResponseEntity<?> saveProductCategory(@RequestBody(required = true) ProductCategoryPostTO productCategoryPostTO) {
    	try {
    		
    		productCategoryService.saveProductCategory(productCategoryPostTO);
    	    
    		return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping(path = "/updateProductCategory")
    public ResponseEntity<?> updateProductCategory(@RequestParam(required = true) Long id, @RequestBody(required = true) ProductCategoryPutTO productCategoryPutTO) {
    	try {
    		
    		productCategoryService.updateProductCategory(id, productCategoryPutTO);
    	    
    		return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductCategoryByIdForCompleteReport")
    public ResponseEntity<?> getProductCategoryByIdForCompleteReport(@RequestParam(required = true) Long id) {
    	try {
    		
    	    ProductCategoryCompleteReportTO productCategoryById = mapStructMapper.productCategoryToProductCategoryCompleteReportTO(productCategoryService.getProductCategoryById(id));
    	    
    	    return new ResponseEntity<>(productCategoryById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductCategoryById")
    public ResponseEntity<?> getProductCategoryById(@RequestParam(required = true) Long id) {
    	try {
    		
    	    ProductCategoryGetTO productCategoryById = mapStructMapper.productCategoryToProductCategoryGetTO(productCategoryService.getProductCategoryById(id));
    	    
    	    return new ResponseEntity<>(productCategoryById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getProductCategoryByName")
    public ResponseEntity<?> getProductCategoryByName(@RequestParam(required = true) String name) {
    	try {
    	   
    		ProductCategoryGetTO productCategoryByName = mapStructMapper.productCategoryToProductCategoryGetTO(productCategoryService.getProductCategoryByName(name));
    	     	    
    		return new ResponseEntity<>(productCategoryByName,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getAllProductsCategory")
    public ResponseEntity<?> getAllProductsCategory() {
    	try {
    		
    		List<ProductCategoryGetTO> lProductCategory = mapStructMapper.productCategoryToProductCategoryGetTOs(productCategoryService.getAllProductsCategory());
    	    
    	    return new ResponseEntity<>(lProductCategory, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
      
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/changeStateProductCategoryById")
    public ResponseEntity<?> changeStateProductCategoryById(@RequestParam(required = true) Long id, @RequestParam(required = true) int newState) {
    	try {
    		productCategoryService.changeStateProductCategoryById(id, newState);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }


}
