package com.generation.blogdoede.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogdoede.domain.model.Subject;

/**
 * Repositório de métodos CRUD da model Subject
 * 
 * @author Edgar Soares Marinho
 * @since 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * @see Subject
 * @see SubjectDTO
 * @see SubjectService
 * 
 */

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	public List<Subject> findAllBySubjectDescContainingIgnoreCase (String subjectDesc);
}
