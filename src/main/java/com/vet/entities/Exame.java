package com.vet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "o campo hemograma não pode ser vazio")
	private Boolean hemograma;
	
	@NotNull(message = "o campo colesterol não pode ser vazio")
	private Boolean colesterol;
	
	@NotNull(message = "o campo fosforo não pode ser vazio")
	private Boolean fosforo;
	
	@NotNull(message = "o campo calcio não pode ser vazio")
	private Boolean calcio;
	
	@NotNull(message = "o campo glicose não pode ser vazio")
	private Boolean glicose;
	
	@NotNull(message = "o campo magnesio não pode ser vazio")
	private Boolean magnesio;
	
	@NotNull(message = "o campo ureia não pode ser vazio")
	private Boolean ureia;
	
	@NotNull(message = "o campo potassio não pode ser vazio")
	private Boolean potassio;
	
	@NotEmpty(message = "o campo ultrassonografia não pode ser vazio")
	private String ultrassonografia;
	
	@NotEmpty(message = "o campo radiografia não pode ser vazio")
	private String radiografia;
	
	@NotEmpty(message = "o campo data não pode ser vazio")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String data;

	@ManyToOne
	@JsonBackReference
	private Animal animalExame;
}
