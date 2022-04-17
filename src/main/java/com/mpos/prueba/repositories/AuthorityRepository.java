package com.mpos.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpos.prueba.models.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long >{

}
