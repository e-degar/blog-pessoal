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
	private long userId;
	
	@NotNull(message = "O campo nome é obrigatório")
	@Size(min = 2, max = 255)
	private String userName;
	
	@Schema(example = "email@email.com")
	@NotNull(message = "O campo email é obrigatório")
	@Email(message = "Email inválido")
	private String userEmail;
	
	@NotNull(message = "O campo login é obrigatório")
	@Size(min = 3, max = 255)
	private String userLogin;
	
	@NotNull(message = "O campo senha é obrigatório")
	@Size(min = 8, max = 255)
	private String userPasswd;
	
	@Size(min = 8, max = 255)
	private String userPicture;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Post> posts;

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

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
		
}
