package com.generation.blogdoede.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.domain.model.Post;

/**
 * Repositório de métodos CRUD da model Post
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see Post
 * @see PostDTO
 * @see PostService
 * 
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	public List<Post> findAllByPostTitleContainingIgnoreCase (String postTitle);
}
