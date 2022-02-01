package com.generation.blogdoede.dto;

public class UserCredentialsDTO {
	
	private String basicToken;
	private Long id;
	private String username;
	
	public UserCredentialsDTO(String basicToken, Long id, String username) {
		super();
		this.basicToken = basicToken;
		this.id = id;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
