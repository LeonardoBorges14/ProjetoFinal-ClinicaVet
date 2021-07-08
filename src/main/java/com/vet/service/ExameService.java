package com.vet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vet.entities.Exame;
import com.vet.repository.ExameRepository;
import com.vet.service.exception.ResourceNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;

	public Exame findById(Long id) {
		Optional<Exame> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(
				"Exame de id " + id + " não encontrado!"));
	}
	
	public List<Exame> findAll() {
		return repository.findAll();
	}
	
	public Exame insert (Exame obj) { 
		return repository.save(obj);
	}

	public Exame update(Long id, Exame exame) {
		Exame obj = findById(id);
		obj.setCalcio(exame.getCalcio());
		obj.setColesterol(exame.getColesterol());
		obj.setData(exame.getData());
		obj.setFosforo(exame.getFosforo());
		obj.setGlicose(exame.getGlicose());
		obj.setHemograma(exame.getHemograma());
		obj.setMagnesio(exame.getMagnesio());
		obj.setPotassio(exame.getPotassio());
		obj.setRadiografia(exame.getRadiografia());
		obj.setUltrassonografia(exame.getUltrassonografia());
		obj.setUreia(exame.getUreia());
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
			
	}
}
