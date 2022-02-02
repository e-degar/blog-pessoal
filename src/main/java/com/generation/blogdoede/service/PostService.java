package com.generation.blogdoede.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generation.blogdoede.commons.mappers.PostMapper;
import com.generation.blogdoede.domain.model.Post;
import com.generation.blogdoede.domain.repository.PostRepository;
import com.generation.blogdoede.dto.PostDTO;

@Service
public class PostService {

	private @Autowired PostMapper mapper;
	private @Autowired PostRepository repo;

	public ResponseEntity<List<PostDTO>> getAllPosts(){
		List<Post> posts = repo.findAll();
		
		if (posts.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200)
					.body(posts.stream()
					.map(mapper::toDTO)
					.collect(Collectors.toList())); 
		}
	}
	
}
