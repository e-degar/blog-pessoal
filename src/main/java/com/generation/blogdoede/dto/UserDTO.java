package com.generation.blogdoede.dto;

public class UserDTO {
	
private long userId;
	
	private String userName;

	private String userEmail;
	
	private String userLogin;
		
	private String userPicture;
	
	public UserDTO(long userId, String userName, String userEmail, String userLogin,
			String userPicture) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userLogin = userLogin;
		this.userPicture = userPicture;
	}

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

}
