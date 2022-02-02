package com.generation.blogdoede.dto;

import java.util.Date;

import com.generation.blogdoede.domain.model.Subject;
import com.generation.blogdoede.domain.model.User;

public class PostDTO {

	private Long postId;
	private String postTitle;
	private String postContent;
	private Date postDate;
	private Subject subject;
	private User user;
	
	public PostDTO(Long postId, String postTitle, String postContent, Date postDate, Subject subject, User user) {
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.subject = subject;
		this.user = user;
	}

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
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
