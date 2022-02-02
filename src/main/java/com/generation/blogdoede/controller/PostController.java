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

import com.generation.blogdoede.domain.model.Post;
import com.generation.blogdoede.domain.repository.PostRepository;
import com.generation.blogdoede.dto.PostDTO;
import com.generation.blogdoede.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
	
	@Autowired
	private PostRepository repository;
	private @Autowired PostService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		return service.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Post>> getPostByTitulo(@PathVariable String titulo){
		return ResponseEntity
				.ok(repository.findAllByPostTitleContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Post> createNewPost(@RequestBody Post postagem){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Post> updatePost(@RequestBody Post postagem){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
