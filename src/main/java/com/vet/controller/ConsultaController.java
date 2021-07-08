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

import com.vet.entities.Consulta;
import com.vet.service.ConsultaService;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Long id) {
		Consulta obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Consulta>> findAll() {
		List<Consulta> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<String> insert(@Valid @RequestBody Consulta obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok("Sucesso! A Consulta foi cadastrada!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta consulta) {
		Consulta obj = service.update(id, consulta);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){ 
		service.delete(id); 
		return ResponseEntity.noContent().build();
		
	}

}
