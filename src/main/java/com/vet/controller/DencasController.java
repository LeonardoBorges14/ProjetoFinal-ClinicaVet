package com.vet.controller;

import java.util.List;

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

import com.vet.entities.Doencas;
import com.vet.service.DoencasService;

@RestController
@RequestMapping(value = "/doencas")
public class DencasController {

	@Autowired
	private DoencasService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Doencas> findById(@PathVariable Long id) {
		Doencas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Doencas>> findAll() {
		List<Doencas> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Doencas obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok("Sucesso! A Doenca foi cadastrada!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Doencas> update(@PathVariable Long id, @RequestBody Doencas doencas) {
		Doencas obj = service.update(id, doencas);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){ 
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
