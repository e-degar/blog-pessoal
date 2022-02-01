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

import com.generation.blogdoede.dto.UserCredentialsDTO;
import com.generation.blogdoede.dto.UserLoginDTO;
import com.generation.blogdoede.model.Usuario;
import com.generation.blogdoede.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user")
public class UsuarioController {
	
	private @Autowired UsuarioService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> registerUser (@Valid @RequestBody Usuario novoUsuario){
		return service.registrarUsuario(novoUsuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserCredentialsDTO> getCredentials (@Valid @RequestBody UserLoginDTO dto){
		return service.getCredentials(dto);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll(){
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
		return service.findById(id);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Usuario> updateUser(@Valid @RequestBody Usuario user){
		return service.updateUser(user);
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
	
}
