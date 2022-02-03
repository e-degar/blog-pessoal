package com.generation.blogdoede.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *  Classe responsável pelo DTO da model Post
 * 
 *  @author Edgar Soares Marinho
 * 	@date 03/02/2022
 * 	@version 0.1.1-SNAPSHOT
 * 	@see Post
 * 	@see PostService
 * 
 */

public class PostDTO {

	private Long postId;
	private String postTitle;
	private String postContent;
	private Date postDate = new java.sql.Timestamp(System.currentTimeMillis());
	@JsonIgnoreProperties("posts")
	private SubjectDTO subject;
	@JsonIgnoreProperties("posts")
	private UserDTO user;
	
	public PostDTO(Long postId, String postTitle, String postContent, SubjectDTO subject, UserDTO user) {
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.subject = subject;
		this.user = user;
	}
	
	public PostDTO() {}

	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getPostTitle() {
		return postTitle;
	}
	
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	
	public String getPostContent() {
		return postContent;
	}
	
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	public SubjectDTO getSubject() {
		return subject;
	}
	
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}
