package com.generation.blogdoede.dto;

import javax.validation.constraints.NotBlank;

/**
 *  Classe responsável pelo DTO de login da model Usuário
 * 
 *  @author Edgar Soares Marinho
 * 	@date 03/02/2022
 * 	@version 0.1.1-SNAPSHOT
 * 	@see User
 * 	@see UserDTO
 * 	@see UserCredentialsDTO
 * 	@see UserService
 * 
 */

public class UserLoginDTO {
	
	private @NotBlank String email;
	private @NotBlank String passwd;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
