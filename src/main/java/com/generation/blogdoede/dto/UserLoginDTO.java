package com.generation.blogdoede.dto;

import javax.validation.constraints.NotBlank;

public class UserLoginDTO {
	
	private @NotBlank String username;
	private @NotBlank String passwd;

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

}
