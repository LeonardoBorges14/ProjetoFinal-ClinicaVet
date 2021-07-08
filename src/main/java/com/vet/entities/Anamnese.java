package com.vet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
public class Anamnese implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo  problema Sistema digestivo  é obrigatório")
	private String problemaSistemaDigestivo;

	@NotBlank(message = "O campo  problema Sistema uro Genital  é obrigatório")
	private String problemaSistemaUroGenital;

	@NotBlank(message = "O campo  problema Sistema cardiaco Respiratorio  é obrigatório")
	private String problemaSistemaCardiacoRespiratorio;

	@NotBlank(message = "O campo  problema Sistema Neurologico é obrigatório")
	private String problemaSistemaNeurologico;

	@NotBlank(message = "O campo  problema Sistema Locomotor  é obrigatório")
	private String problemaSistemaLocomotor;

	@NotBlank(message = "O campo problema Pele é obrigatório")
	private String problemaPele;

	@NotBlank(message = "O campo  problema Olhos  é obrigatório")
	private String problemaOlhos;

	@NotBlank(message = "O campo  problema Ouvido  é obrigatório")
	private String problemaOuvido;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private List<Doencas> doencas = new ArrayList<Doencas>();

}
