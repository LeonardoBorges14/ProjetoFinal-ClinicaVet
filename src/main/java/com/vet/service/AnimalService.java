package com.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.entities.Animal;
import com.vet.repository.AnimalRepository;
import com.vet.service.exception.ResourceNotFoundException;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public Animal findById(Long id) {
		Optional<Animal> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Animal de id " + id + "não encontrado!"));
	}
	
	public List<Animal> findAll() {
		return repository.findAll();
	}
	
	public Animal insert (Animal obj) { 
		return repository.save(obj);
	}

	public Animal update(Long id, Animal animal) {
		Animal obj = findById(id);
		obj.setDataCadastro(animal.getDataCadastro());
		obj.setDataNascimento(animal.getDataNascimento());
		obj.setEstado(animal.getEstado());
		obj.setExame(animal.getExame());
		obj.setConsulta(animal.getConsulta());
		obj.setFoto(animal.getFoto());
		obj.setNome(animal.getNome());
		obj.setPelagem(animal.getPelagem());
		obj.setPeso(animal.getPeso());
		obj.setRaca(animal.getRaca());
		obj.setTipo(animal.getTipo());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
