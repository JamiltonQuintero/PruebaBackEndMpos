package com.mpos.prueba.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mpos.prueba.services.UserService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.to.UserGetTO;
import com.mpos.to.UserPostTO;
import com.mpos.to.UserPutTO;
import com.mpos.to.UserCompleteReportTO;

@RestController()
@RequestMapping(path = "/api/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserRestController {

	private static Logger _logger = LoggerFactory.getLogger(UserRestController.class);
	
    @Autowired
	UserService userService;
    
    @Autowired(required=true)
    MapStructMapper mapStructMapper;
     
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody(required = true) UserPostTO userPostTO) {
    	try {
    		userService.saveUser(userPostTO);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(), HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping(path = "/updateUser")
    public ResponseEntity<?> updateUser(@RequestParam(required = true) Long id,@RequestBody(required = true) UserPutTO userPutTO) {
    	try {
    		userService.updateUser(id, userPutTO);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam(required = true) Long id) {
    	try {
    		UserGetTO userById = mapStructMapper.userToUserGetTO(userService.getUserByUserId(id));
    	    return new ResponseEntity<>(userById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserByIdForCompleteReport")
    public ResponseEntity<?> getUserByIdForCompleteReport(@RequestParam(required = true) Long id) {
    	try {
    		UserCompleteReportTO userById = mapStructMapper.userToUserReportTO(userService.getUserByUserId(id));
    	    return new ResponseEntity<>(userById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam(required = true) String username) {
    	try {
    		UserGetTO userByUsername = mapStructMapper.userToUserGetTO(userService.getUserByUsername(username));
    	    return new ResponseEntity<>(userByUsername,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
    	try {
    		List<UserGetTO>  lAllUsers = mapStructMapper.usersToUsersGetTOs(userService.getAllUsers());
    	    return new ResponseEntity<>(lAllUsers,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUsersByAutorityId")
    public ResponseEntity<?> getUsersByAutorityId(@RequestParam(required = true) Long autorityId) {
    	try {
    		List<UserGetTO> usersByAutorityId =mapStructMapper.usersToUsersGetTOs(userService.getUsersByAutority(autorityId));
    	    return new ResponseEntity<>(usersByAutorityId,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }

    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/changeStateUserById")
    public ResponseEntity<?> changeStateUserById(@RequestParam(required = true) Long id, @RequestParam(required = true) int newState) {
    	try {
    		userService.changeStateByUserId(id, newState);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(ex1.toString(),HttpStatus.BAD_REQUEST);
    	}
    }

}
