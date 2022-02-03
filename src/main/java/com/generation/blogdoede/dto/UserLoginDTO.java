package com.generation.blogdoede.dto;

import javax.validation.constraints.NotBlank;

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
