package com.mpos.prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mpos.prueba.models.Authority;
import com.mpos.prueba.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
    List<User> findByAuthoritiesIn(Authority authority);
}
