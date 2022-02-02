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
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostDTO>> getPostByTitulo(@PathVariable String titulo){
		return service.getPostByTitulo(titulo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable Long id){
		return service.getPostById(id);
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> createNewPost(@RequestBody Post postagem){
		return service.createNewPost(postagem);
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
