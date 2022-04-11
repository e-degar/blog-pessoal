package com.generation.blogdoede.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model da tabela tb_subject
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see SubjectDTO
 * @see SubjectService
 * 
 */

@Entity
@Table(name = "tb_subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O nome do assunto não pode ser vazio")
	@Size(min = 3, max = 50, message = "Quantidade de caracteres não permitida")
	private String description;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("subject")
	private List<Post> posts;

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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
