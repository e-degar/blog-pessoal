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
	private Long id;
	private String email;
	
	public UserCredentialsDTO(String basicToken, Long id, String email) {
		this.basicToken = basicToken;
		this.id = id;
		this.email = email;
	}

	public String getBasicToken() {
		return basicToken;
	}

	public void setBasicToken(String basicToken) {
		this.basicToken = basicToken;
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
		
}
