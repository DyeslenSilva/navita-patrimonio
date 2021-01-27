package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Patrimonio {

	@Column
	private String nome;
	
	@Column
	private Integer marcaId;
	
	@Column
	private String descricao;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer nDoTombo;
	
	
}
