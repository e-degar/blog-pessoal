package com.generation.blogdoede.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.generation.blogdoede.model.Tema;
import com.generation.blogdoede.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tema>> getAllTemas(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getTemaById(@PathVariable Long id){
		return repository
				.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/desc/{desc}")
	public ResponseEntity<List<Tema>> getTemaByName(@PathVariable String desc){
		return ResponseEntity.ok(repository
				.findAllByDescTemaContainingIgnoreCase(desc)); 
	}
	
	@PostMapping
	public ResponseEntity<Tema> createNewTema(@RequestBody Tema tema){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> updateTema(@RequestBody Tema tema){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
