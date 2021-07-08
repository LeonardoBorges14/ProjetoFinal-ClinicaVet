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

import com.vet.entities.Animal;
import com.vet.service.AnimalService;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

	@Autowired
	private AnimalService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Animal> findById(@PathVariable Long id) {
		Animal obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Animal>> findAll() {
		List<Animal> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<String> insert(@Valid @RequestBody Animal obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok("Sucesso! O Animal foi cadastrado!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
		Animal obj = service.update(id, animal);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){ 
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
