package com.generation.blogdoede.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generation.blogdoede.domain.model.Post;
import com.generation.blogdoede.domain.repository.PostRepository;
import com.generation.blogdoede.dto.PostDTO;

@Service
public class PostService {


	private @Autowired PostRepository repo;
	private @Autowired ModelMapper mapper;

	public ResponseEntity<List<PostDTO>> getAllPosts(){
		List<Post> allPosts = repo.findAll();	
		return foundPosts(allPosts);
	}

	public ResponseEntity<List<PostDTO>> getPostByTitulo(String titulo) {
		List<Post> postsByTitle = repo.findAllByPostTitleContainingIgnoreCase(titulo);		
		return foundPosts(postsByTitle);
	}
	
	private ResponseEntity<List<PostDTO>> foundPosts(List<Post> posts){
		if (posts.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200)
					.body(posts.stream()
					.map(post -> mapper.map(post, PostDTO.class))
					.collect(Collectors.toList())); 
		}
	}
	
	public ResponseEntity<PostDTO> getPostById(Long id) {
		return repo.findById(id)
				.map(resp -> ResponseEntity.ok(mapper.map(resp, PostDTO.class)))
				.orElse(ResponseEntity.status(404).build());
	}

	public ResponseEntity<PostDTO> createNewPost(PostDTO post) {
		Post created = repo.save(mapper.map(post, Post.class));
		return ResponseEntity
				.status(201)
				.body(mapper.map(created, PostDTO.class));
	}

	public ResponseEntity<PostDTO> updatePost(PostDTO post) {
		Post updated = repo.save(mapper.map(post, Post.class));
		return ResponseEntity
				.status(200)
				.body(mapper.map(updated, PostDTO.class));
	}

	public void deletePost(long id) {
		repo.deleteById(id);	
	}

}
