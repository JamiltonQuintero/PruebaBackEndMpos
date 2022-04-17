package com.mpos.prueba.services;

import java.util.List;
import com.mpos.prueba.models.User;
import com.mpos.to.UserPostTO;

public interface UserService {
	
	void saveUpdateUser(UserPostTO userPostTO);
	
	User getUserById(Long id);
	
	User getUserByUsername(String name);
	
	List<User> getUsersByAutority(Long autorityId);
	
	void changeStateUserById(Long id,int newState);

}
