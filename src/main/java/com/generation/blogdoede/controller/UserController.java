package com.generation.blogdoede.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogdoede.domain.model.User;
import com.generation.blogdoede.dto.UserCredentialsDTO;
import com.generation.blogdoede.dto.UserLoginDTO;
import com.generation.blogdoede.service.UserService;

/**
 * Implementação dos endpoints relacionados com a model User
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * 
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {
	
	private @Autowired UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser (@Valid @RequestBody User newUser){
		return service.registrarUsuario(newUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserCredentialsDTO> getCredentials (@Valid @RequestBody UserLoginDTO dto){
		return service.getCredentials(dto);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/verify")
		public ResponseEntity verifyPasswd (@Valid @RequestBody UserLoginDTO dto){
		return service.verifyPasswd(dto);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAll(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		return service.findById(id);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		return service.updateUser(user);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
}
