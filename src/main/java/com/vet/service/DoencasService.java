package com.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.entities.Doencas;
import com.vet.repository.DoencasRepository;
import com.vet.service.exception.ResourceNotFoundException;

@Service
public class DoencasService {

	@Autowired
	private DoencasRepository repository;

	public Doencas findById(Long id) {
		Optional<Doencas> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(
				"Doença de id " + id + " não encontrada!"));
	}
	
	public List<Doencas> findAll() {
		return repository.findAll();
	}
	
	public Doencas insert (Doencas obj) { 
		return repository.save(obj);
	}

	public Doencas update(Long id, Doencas Doencas) {
		Doencas obj = findById(id);
		obj.setNome(Doencas.getNome());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
