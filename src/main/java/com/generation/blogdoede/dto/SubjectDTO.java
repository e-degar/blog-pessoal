package com.generation.blogdoede.dto;

import java.util.List;

import com.generation.blogdoede.domain.model.Post;

public class SubjectDTO {
	
	private Long subjectId;	
	private String subjectDesc;
	private List<Post> posts;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectDesc() {
		return subjectDesc;
	}

	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}
