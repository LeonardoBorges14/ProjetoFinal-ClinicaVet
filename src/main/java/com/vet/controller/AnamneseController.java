package com.vet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vet.entities.Anamnese;
import com.vet.service.AnamneseService;

@RestController
@RequestMapping(value = "/anamnese")
public class AnamneseController {

	@Autowired
	private AnamneseService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Anamnese> findById(@PathVariable Long id) {
		Anamnese obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Anamnese>> findAll() {
		List<Anamnese> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<String> insert( @Valid @RequestBody Anamnese obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok("Sucesso! A Anamnese foi Cadastrada!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Anamnese> update(@PathVariable Long id, @RequestBody Anamnese anamnese) {
		Anamnese obj = service.update(id, anamnese);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){ 
		service.delete(id); 
		return ResponseEntity.noContent().build();
		
	}

}
