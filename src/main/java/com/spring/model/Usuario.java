package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Usuario {

	@Column
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String senha;
	
	@Transient
	private String old_nome = "";
	
	
	
}
