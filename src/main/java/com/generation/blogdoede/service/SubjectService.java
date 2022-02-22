package com.generation.blogdoede.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generation.blogdoede.domain.model.Subject;
import com.generation.blogdoede.domain.repository.SubjectRepository;
import com.generation.blogdoede.dto.SubjectDTO;

/**
 * Implementação do SubjectService com os métodos relacionados com a model Subject
 * 
 * @author Edgar Soares Marinho
 * @date 03/02/2022
 * @version 0.1.1-SNAPSHOT
 * 
 */

@Service
public class SubjectService {
	
	private @Autowired ModelMapper mapper;
	private @Autowired SubjectRepository repo;
	
	public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
		List<Subject> allSubjects = repo.findAll();
		return foundSubjects(allSubjects);
	}
	
	public ResponseEntity<List<SubjectDTO>> getSubjectByName(String desc) {
		List<Subject> subjectsByName = repo.findAllByDescriptionContainingIgnoreCase(desc);	
		return foundSubjects(subjectsByName);
	}

	private ResponseEntity<List<SubjectDTO>> foundSubjects(List<Subject> subjects) {
		if (subjects.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200)
					.body(subjects.stream()
					.map(subject -> mapper.map(subject, SubjectDTO.class))
					.collect(Collectors.toList())); 
		}
	}

	public ResponseEntity<SubjectDTO> getSubjectById(Long id) {
		return repo.findById(id)
		.map(resp -> ResponseEntity.ok(mapper.map(resp, SubjectDTO.class)))
		.orElse(ResponseEntity.status(404).build());
	}

	public ResponseEntity<SubjectDTO> createNewSubject(SubjectDTO subject) {
		Subject created = repo.save(mapper.map(subject, Subject.class));
		return ResponseEntity
			.status(200)
			.body(mapper.map(created, SubjectDTO.class));
	}

	public ResponseEntity<SubjectDTO> updateSubject(SubjectDTO subject) {
		Subject updated = repo.save(mapper.map(subject, Subject.class));
		return ResponseEntity
				.status(200)
				.body(mapper.map(updated, SubjectDTO.class));
	}

	public void deleteSubject(long id) {
		repo.deleteById(id);	
	}
	
}
