package com.generation.blogdoede.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class SubjectDTO {
	
	private Long subjectId;	
	private String subjectDesc;
	@JsonIgnoreProperties("subject")
	private List<PostDTO> posts;
	
	public SubjectDTO(Long subjectId, String subjectDesc, List<PostDTO> posts) {
		this.subjectId = subjectId;
		this.subjectDesc = subjectDesc;
		this.posts = posts;
	}
	
	public SubjectDTO() {}

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

	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}
	
}
