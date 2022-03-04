package com.generation.blogdoede.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Model da tabela tb_user
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see UserDTO
 * @see UserCredentialsDTO
 * @see UserLoginDTO
 * @see UserService
 * 
 */

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O campo nome é obrigatório")
	@Size(min = 2, max = 255)
	private String name;
	
	@Schema(example = "email@email.com")
	@NotNull(message = "O campo email é obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@Size(min = 3, max = 180)
	private String biography;
	
	@NotNull(message = "O campo login é obrigatório")
	@Size(min = 3, max = 255)
	private String username;
	
	@NotNull(message = "O campo senha é obrigatório")
	@Size(min = 8, max = 255)
	private String passwd;
	
	@Size(min = 8, max = 255)
	private String picture;

	@NotNull
	private String user_role;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("author")
	private List<Post> posts;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
		
}
