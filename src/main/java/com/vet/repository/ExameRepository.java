package com.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vet.entities.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

}
