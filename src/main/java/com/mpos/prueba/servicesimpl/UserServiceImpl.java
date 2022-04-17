package com.mpos.prueba.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mpos.prueba.enums.EState;
import com.mpos.prueba.models.User;
import com.mpos.prueba.repositories.AuthorityRepository;
import com.mpos.prueba.repositories.UserRepository;
import com.mpos.prueba.security.JwtUserFactory;
import com.mpos.prueba.services.UserService;
import com.mpos.prueba.utils.MapStructMapper;
import com.mpos.prueba.utils.UtilDate;
import com.mpos.to.UserPostTO;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder encoder;
      
    @Autowired
    private UtilDate utilDate;

    @Autowired(required=true)
    MapStructMapper mapStructMapper;
    
    @Autowired
    AuthorityRepository authorityRepository;
    
	@Override
	public void saveUpdateUser(UserPostTO userPostTO) {	
		
		Date currentDate =utilDate.getCurrentDate();
		User user = mapStructMapper.userPostTOToUser(userPostTO);
		user.setPassword(encoder.encode(user.getPassword()));
		user.setLastPasswordResetDate(currentDate);
		user.setDateOfCreation(currentDate);
		user.setDateOfLastEntry(currentDate);
		user.setState(EState.ACTIVE.getId());
		save(user);	
	}

	@Override
	public User getUserById(Long id) {
		User userById =  findUserById(id);
		return userById;
	}

	@Override
	public User getUserByUsername(String name) {
		User userByName =  userRepository.findByUsername(name);
		return userByName;
	}

	
	
	
	@Override
	public List<User> getUsersByAutority(Long autorityId) {	
		List<User> lUsersByAuthority = userRepository.findByAuthoritiesIn(authorityRepository.findById(autorityId).get());
		return lUsersByAuthority;
	}

	@Override
	public void changeStateUserById(Long id, int newState) {		
		User userById =  findUserById(id);		
		userById.setState(newState);	
		save(userById);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
	}
	
	
	private User findUserById(Long id) {
		User userById =  userRepository.findById(id).get();	
		return userById;
	}
	
	private void save(User user) {
		userRepository.save(user);	
	}
		
}
