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
import com.generation.blogdoede.model.Postagem;
import com.generation.blogdoede.repository.PostagemRepository;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Postagem>> getAllPosts(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getPostById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getPostByTitulo(@PathVariable String titulo){
		return ResponseEntity
				.ok(repository.findAllByTituloPostContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> createNewPost(@RequestBody Postagem postagem){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> updatePost(@RequestBody Postagem postagem){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
