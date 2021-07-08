package com.vet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	@NotBlank(message = "O campo data é obrigatório")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String data;

	@NotBlank(message = "O campo observacoes é obrigatório")
	private String observacoes;

	@NotBlank(message = "O campo queixa é obrigatório")
	private String queixa;

	@NotBlank(message = "O campo historico é obrigatório")
	private String historico;

	@ManyToOne
	@JsonBackReference
	private Animal animalConsulta;
	
	@OneToOne
	private Anamnese anamnese;


}
