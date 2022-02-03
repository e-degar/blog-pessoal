package com.generation.blogdoede.controller;

import java.util.List;

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

import com.generation.blogdoede.dto.PostDTO;
import com.generation.blogdoede.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
	
	private @Autowired PostService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		return service.getAllPosts();
	}
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<PostDTO>> getPostByTitle(@PathVariable String title){
		return service.getPostByTitulo(title);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable Long id){
		return service.getPostById(id);
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> createNewPost(@RequestBody PostDTO post){
		return service.createNewPost(post);
	}
	
	@PutMapping
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO post){
		return service.updatePost(post);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable long id) {
		service.deletePost(id);
	}
	
}
