package com.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vet.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
