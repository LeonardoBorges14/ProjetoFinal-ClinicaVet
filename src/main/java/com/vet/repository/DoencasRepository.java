package com.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vet.entities.Doencas;

public interface DoencasRepository extends JpaRepository<Doencas, Long> {

}
