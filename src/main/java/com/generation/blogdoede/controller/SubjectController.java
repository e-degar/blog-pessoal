package com.generation.blogdoede.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogdoede.dto.SubjectDTO;
import com.generation.blogdoede.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubjectController {

	private @Autowired SubjectService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
		return service.getAllSubjects();
	}
	
	@GetMapping("/desc/{desc}")
	public ResponseEntity<List<SubjectDTO>> getSubjectByName(@PathVariable String desc){
		return service.getSubjectByName(desc); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long id){
		return service.getSubjectById(id);
	}
	
	@PostMapping
	public ResponseEntity<SubjectDTO> createNewSubject(@RequestBody SubjectDTO subject){
		return service.createNewSubject(subject);
	}
	
	@PutMapping
	public ResponseEntity<SubjectDTO> updateSubject(@RequestBody SubjectDTO subject){
		return service.updateSubject(subject);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSubject(@PathVariable long id) {
		service.deleteSubject(id);
	}
	
}
