package com.generation.blogdoede.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.domain.model.User;

/**
 * Repositório de métodos CRUD da model User
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see User
 * @see UserDTO
 * @see UserService
 * @see UserCredentialsDTO
 * @see UserLoginDTO
 * 
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
	public Optional<User> findByUserLoginContainingIgnoreCase (String userLogin);
	
	public Optional<User> findByUserEmail (String userEmail);
}
