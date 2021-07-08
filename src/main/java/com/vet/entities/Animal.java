package com.vet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "O campo foto é obrigatório")
	private String foto;

	@NotBlank(message = "O campo raca é obrigatório")
	private String raca;

	@NotBlank(message = "O campo pelagem é obrigatório")
	private String pelagem;
	
	@NotNull(message = "o campo peso não pode ser nullo")
	@Min(value= 1, message = "O campo peso deve ser maior ou igual a 1")
	private Integer peso;

	@NotNull(message = "o campo tipo não pode ser nullo")
	@Min(value=1,message = "O campo tipo deve ser maior ou igual a 1")
	private Integer tipo;
	
	@NotNull(message = "o campo estado não pode ser nullo")
	@Min(value=1, message = "O campo estado deve ser maior ou igual a 1")
	private Integer estado;

	@NotBlank(message = "O campo campo data Nascimento é obrigatório")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String dataNascimento;

	@NotBlank(message = "O campo data cadastro é obrigatório")
	@Pattern(regexp= "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "Datas devem estar no formato YYYY-MM-DD")
	private String dataCadastro;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "animalExame")
	@JsonManagedReference
	private List<Exame> exame = new ArrayList<Exame>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "animalConsulta")
	@JsonManagedReference
	private List<Consulta> consulta = new ArrayList<Consulta>();
	

}
