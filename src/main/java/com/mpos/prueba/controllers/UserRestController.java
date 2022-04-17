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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mpos.prueba.services.UserService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.to.UserGetTO;
import com.mpos.to.UserPostTO;
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
    @PostMapping(path = "/saveUpdateUser")
    public ResponseEntity<?> saveUpdateUser(@RequestBody(required = true) UserPostTO userPostTO) {
    	try {
    		//userService.saveUpdateUser(MapStructMapper.INSTANCE.userPostTOToUser(userPostTO));
    		userService.saveUpdateUser(userPostTO);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam(required = true) Long id) {
    	try {
    		//UserGetTO userById = MapStructMapper.INSTANCE.userToUserGetTO(userService.getUserById(id));
    		UserGetTO userById = mapStructMapper.userToUserGetTO(userService.getUserById(id));
    	    return new ResponseEntity<>(userById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserByIdCompleteReport")
    public ResponseEntity<?> getUserByIdCompleteReport(@RequestParam(required = true) Long id) {
    	try {
    		//UserReportTO userById = MapStructMapper.INSTANCE.userToUserReportTO(userService.getUserById(id));
    		UserCompleteReportTO userById = mapStructMapper.userToUserReportTO(userService.getUserById(id));
    	    return new ResponseEntity<>(userById, HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(path = "/getUserByUsername")
    public ResponseEntity<?> getUserByUsername(@RequestParam(required = true) String username) {
    	try {
    		//UserGetTO userByUsername = MapStructMapper.INSTANCE.userToUserGetTO(userService.getUserByUsername(username));
    		UserGetTO userByUsername = mapStructMapper.userToUserGetTO(userService.getUserByUsername(username));
    	    return new ResponseEntity<>(userByUsername,HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }

    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(path = "/changeStateUserById")
    public ResponseEntity<?> changeStateUserById(@RequestParam(required = true) Long id, @RequestParam(required = true) int newState) {
    	try {
    		userService.changeStateUserById(id, newState);
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch (Exception ex1) {
    	    _logger.error(ex1.toString());
    	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }

}
