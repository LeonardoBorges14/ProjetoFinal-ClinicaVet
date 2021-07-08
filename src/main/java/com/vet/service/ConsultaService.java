package com.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.entities.Consulta;
import com.vet.repository.ConsultaRepository;
import com.vet.service.exception.ResourceNotFoundException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	public Consulta findById(Long id) {
		Optional<Consulta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(
				"Consulta de id " + id + " não encontrada!"));
	}
	
	public List<Consulta> findAll() {
		return repository.findAll();
	}
	
	public Consulta insert (Consulta obj) { 
		return repository.save(obj);
	}

	public Consulta update(Long id, Consulta consulta) {
		Consulta obj = findById(id);
		obj.setData(consulta.getData());
		obj.setHistorico(consulta.getHistorico());
		obj.setObservacoes(consulta.getObservacoes());
		obj.setQueixa(consulta.getQueixa());
		obj.setAnamnese(consulta.getAnamnese());
		obj.setAnimalConsulta(consulta.getAnimalConsulta());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
