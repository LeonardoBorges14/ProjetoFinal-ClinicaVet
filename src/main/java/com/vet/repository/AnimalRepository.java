package com.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vet.entities.Animal;

public interface AnimalRepository  extends JpaRepository<Animal, Long>{

}
