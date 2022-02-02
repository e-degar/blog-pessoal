package com.generation.blogdoede.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.generation.blogdoede.commons.mappers.SubjectMapper;
import com.generation.blogdoede.domain.model.Subject;
import com.generation.blogdoede.domain.repository.SubjectRepository;
import com.generation.blogdoede.dto.SubjectDTO;

@Service
public class SubjectService {
	
	private @Autowired SubjectMapper mapper;
	private @Autowired SubjectRepository repo;
	
	public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
		List<Subject> allSubjects = repo.findAll();
		return foundSubjects(allSubjects);
	}
	
	public ResponseEntity<List<SubjectDTO>> getSubjectByName(String desc) {
		List<Subject> subjectsByName = repo.findAllBySubjectDescContainingIgnoreCase(desc);	
		return foundSubjects(subjectsByName);
	}

	private ResponseEntity<List<SubjectDTO>> foundSubjects(List<Subject> subjects) {
		if (subjects.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200)
					.body(subjects.stream()
					.map(mapper::subjectToDTO)
					.collect(Collectors.toList())); 
		}
	}

	public ResponseEntity<SubjectDTO> getSubjectById(Long id) {
		return repo.findById(id)
		.map(resp -> ResponseEntity.ok(mapper.subjectToDTO(resp)))
		.orElse(ResponseEntity.status(404).build());
	}

	public ResponseEntity<SubjectDTO> createNewSubject(SubjectDTO subject) {
		Subject created = repo.save(mapper.toModel(subject));
		return ResponseEntity
			.status(200)
			.body(mapper.subjectToDTO(created));
	}

	public ResponseEntity<SubjectDTO> updateSubject(SubjectDTO subject) {
		Subject updated = repo.save(mapper.toModel(subject));
		return ResponseEntity
				.status(200)
				.body(mapper.subjectToDTO(updated));
	}

	public void deleteSubject(long id) {
		repo.deleteById(id);	
	}
	
	

	
	
}
