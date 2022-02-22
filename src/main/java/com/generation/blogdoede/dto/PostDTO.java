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

	private Long id;
	private String title;
	private String content;
	private Date creation_date = new java.sql.Timestamp(System.currentTimeMillis());
	@JsonIgnoreProperties("posts")
	private SubjectDTO subject;
	@JsonIgnoreProperties("posts")
	private UserDTO author;
	
	public PostDTO(Long id, String title, String content, Date creation_date, SubjectDTO subject, UserDTO author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.creation_date = creation_date;
		this.subject = subject;
		this.author = author;
	}

	public PostDTO() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public SubjectDTO getSubject() {
		return subject;
	}
	
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}
	
}
