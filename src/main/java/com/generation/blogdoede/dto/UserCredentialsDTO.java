package com.generation.blogdoede.dto;

/**
 *  Classe responsável pelo DTO de credenciais do Usuário
 * 
 *  @author Edgar Soares Marinho
 * 	@date 03/02/2022
 * 	@version 0.1.1-SNAPSHOT
 * 	@see User
 * 	@see UserDTO
 * 	@see UserLoginDTO
 * 	@see UserService
 * 
 */

public class UserCredentialsDTO {
	
	private String basicToken;
	private String name;
	private String username;
	private Long id;
	private String email;
	private String picture;
	private String user_role;
	
	public UserCredentialsDTO(String basicToken, String name, String username, Long id, String email, String picture,
			String user_role) {
		this.basicToken = basicToken;
		this.name = name;
		this.username = username;
		this.id = id;
		this.email = email;
		this.picture = picture;
		this.user_role = user_role;
	}

	public String getBasicToken() {
		return basicToken;
	}

	public void setBasicToken(String basicToken) {
		this.basicToken = basicToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
			
}
