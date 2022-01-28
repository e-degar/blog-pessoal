package com.generation.blogdoede.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.generation.blogdoede.model.Usuario;
import com.generation.blogdoede.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAllUsers(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUserById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Usuario>> getUsersByName(@PathVariable String name){
		return ResponseEntity.ok(repository
				.findAllByNomeUsuarioContainingIgnoreCase(name));
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<List<Usuario>> getUsersByUsername(@PathVariable String username){
		return ResponseEntity.ok(repository
				.findAllByLoginUsuarioContainingIgnoreCase(username));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> createNewUser(@RequestBody Usuario usuario){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(repository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
