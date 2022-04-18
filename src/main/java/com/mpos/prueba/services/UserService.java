package com.mpos.prueba.services;

import java.util.List;
import com.mpos.prueba.models.User;
import com.mpos.to.UserPostTO;
import com.mpos.to.UserPutTO;

public interface UserService {
	
	void saveUser(UserPostTO userPostTO);
	
	void updateUser(Long id, UserPutTO userPutTO);
	
	User getUserByUserId(Long id);
	
	User getUserByUsername(String name);
	
	List<User> getUsersByAutority(Long autorityId);
	
	void changeStateByUserId(Long id,int newState);
	
	void updateDateOfLastEntryByUser(String username);
	
	List<User> getAllUsers();

}
