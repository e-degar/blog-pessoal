package com.generation.blogdoede.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *  Classe responsável pelo DTO da model Usuário
 * 
 *  @author Edgar Soares Marinho
 * 	@date 03/02/2022
 * 	@version 0.1.1-SNAPSHOT
 * 	@see User
 * 	@see UserLoginDTO
 * 	@see UserCredentialsDTO
 * 
 */

public class UserDTO {
	
private long id;
	
	private String name;

	private String email;

	private String biography;
	
	private String username;
		
	private String picture;

	private String user_role;
	
	@JsonIgnoreProperties("author")
	private List<PostDTO> posts;
	
	public UserDTO(long id, String name, String email, String biography, String username, String picture,
			String user_role, List<PostDTO> posts) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.biography = biography;
		this.username = username;
		this.picture = picture;
		this.user_role = user_role;
		this.posts = posts;
	}

	public UserDTO() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}

}
