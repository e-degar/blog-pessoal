package com.generation.blogdoede.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;
	
	@NotNull
	@Size(min = 5, max = 150)
	private String tituloPost;
	
	@NotNull
	@Size(min = 10, max = 1000)
	private String textoPost;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPost = new java.sql.Date(System.currentTimeMillis());

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getTituloPost() {
		return tituloPost;
	}

	public void setTituloPost(String tituloPost) {
		this.tituloPost = tituloPost;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public Date getDataPost() {
		return dataPost;
	}

	public void setDataPost(Date dataPost) {
		this.dataPost = dataPost;
	}
	
}
