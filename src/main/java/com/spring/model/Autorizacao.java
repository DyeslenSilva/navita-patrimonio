package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autorizacao")
public class Autorizacao {

	@Id
	@Column(name = "name" , length = 13)
	private String nome;
	
	@Column(name = "profile")
	private String perfil;
}
