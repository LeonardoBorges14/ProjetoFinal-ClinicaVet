package com.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vet.entities.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {

}
