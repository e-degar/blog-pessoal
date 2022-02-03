package com.generation.blogdoede.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model da tabela tb_posts
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see PostDTO
 * @see PostService
 * 
 */

@Entity
@Table(name = "tb_posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@NotNull
	@Size(min = 5, max = 150)
	private String postTitle;
	
	@NotNull
	@Size(min = 10, max = 1000)
	private String postContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	
	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("posts")
	private Subject subject;
	
	@NotNull
	@ManyToOne
	@JsonIgnoreProperties("posts")
	private User user;

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
