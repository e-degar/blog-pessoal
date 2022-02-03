package com.generation.blogdoede.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDTO {
	
private long userId;
	
	private String userName;

	private String userEmail;
	
	private String userLogin;
		
	private String userPicture;
	
	@JsonIgnoreProperties("user")
	private List<PostDTO> posts;

	public UserDTO(long userId, String userName, String userEmail, String userLogin, String userPicture,
			List<PostDTO> posts) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userLogin = userLogin;
		this.userPicture = userPicture;
		this.posts = posts;
	}
	
	public UserDTO() {}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}

}
