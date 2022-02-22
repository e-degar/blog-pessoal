package com.generation.blogdoede.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.blogdoede.domain.model.User;
import com.generation.blogdoede.domain.repository.UserRepository;

/**
 * Implementação do UserDetailsService do spring security
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see UserDetailsService
 * @see UserRepository
 * @see UserModel
 * @see UserDetailsImplement
 * 
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(email);
		
		user.orElseThrow(() -> new UsernameNotFoundException(email + " não encontrado."));
		return user.map(UserDetailsImpl::new).get();
	}
	
}
