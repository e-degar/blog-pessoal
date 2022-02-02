package com.generation.blogdoede.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	public List<Subject> findAllBySubjectDescContainingIgnoreCase (String subjectDesc);
}