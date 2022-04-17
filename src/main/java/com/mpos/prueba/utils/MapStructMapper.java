package com.mpos.prueba.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mpos.prueba.models.Product;
import com.mpos.prueba.models.ProductCategory;
import com.mpos.prueba.models.User;
import com.mpos.to.UserGetTO;
import com.mpos.to.UserPostTO;
import com.mpos.to.ProductCategoryCompleteReportTO;
import com.mpos.to.ProductCategoryGetTO;
import com.mpos.to.ProductCategoryPostTO;
import com.mpos.to.ProductCompleteReportTO;
import com.mpos.to.ProductGetTO;
import com.mpos.to.ProductPostTO;
import com.mpos.to.UserCompleteReportTO;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
	
	//** User
	
	UserGetTO userToUserGetTO(User user);
	
	User userGetTOToUser(UserGetTO userGetTO);
	
	UserPostTO userToUserPostTO(User user);
	
	User userPostTOToUser(UserPostTO userGetTO);
	
	UserCompleteReportTO userToUserReportTO(User user);
	
	User userReportTOToUser(UserCompleteReportTO userGetTO);
	
	List<UserGetTO> usersToUsersGetTOs(List<User> Users);
	
	//** Product
	
	ProductGetTO productToProductGetTO(Product product);
	
	Product productGetTOToProduct(ProductGetTO productGetTO);
	
	ProductPostTO productToProductPostTO(Product product);
	
	Product productPostTOToProduct(ProductPostTO productPostTO);
	
	ProductCompleteReportTO productToProductCompleteReportTO(Product product);
	
	Product productCompleteReportTOToProduct(ProductCompleteReportTO productCompleteReportTO);
	
	List<ProductGetTO> productsToProductsGetTOs(List<Product> products);
	
	
	//** ProductCategory
		
	ProductCategoryGetTO ProductCategoryToProductCategoryGetTO(ProductCategory productCategory);
	
	ProductCategory productCategoryGetTOToProductCategory(ProductCategoryGetTO productCategoryGetTO);
	
	ProductCategoryPostTO productCategoryToProductCategoryPostTO(ProductCategory product);
	
	ProductCategory ProductCategoryPostTOToProduct(ProductCategoryPostTO productCategoryPostTO);
	
	ProductCategoryCompleteReportTO productCategoryToProductCategoryCompleteReportTO(ProductCategory product);
	
	ProductCategory productCategoryCompleteReportTOToProduct(ProductCategoryCompleteReportTO productCategoryCompleteReportTO);

}
