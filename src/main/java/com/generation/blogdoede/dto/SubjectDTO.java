package com.generation.blogdoede.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *  Classe responsável pelo DTO da model Subject
 * 
 *  @author Edgar Soares Marinho
 * 	@date 03/02/2022
 * 	@version 0.1.1-SNAPSHOT
 * 	@see Subject
 * 	@see SubjectService
 */

public class SubjectDTO {
	
	private Long id;	
	private String description;
	@JsonIgnoreProperties("subject")
	private List<PostDTO> posts;
	
	public SubjectDTO(Long id, String description, List<PostDTO> posts) {
		this.id = id;
		this.description = description;
		this.posts = posts;
	}

	public SubjectDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}
	
}
