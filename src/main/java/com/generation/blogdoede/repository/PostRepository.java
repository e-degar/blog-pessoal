package com.generation.blogdoede.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.blogdoede.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	public List<Post> findAllByPostTitleContainingIgnoreCase (String postTitle);
}
