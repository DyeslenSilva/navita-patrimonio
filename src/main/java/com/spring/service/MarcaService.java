package com.spring.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Autorizacao;
import com.spring.model.Marca;
import com.spring.repo.AutorizacaoRepo;
import com.spring.repo.MarcaRepo;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepo marcaRepo;
	
	@Autowired
	private AutorizacaoRepo autoRepo;
	
	public void salvarMarca(Marca marca) {
		marcaRepo.save(marca);
	}
	
	public java.util.List<Marca> getMarcas(){
		return marcaRepo.findAll().stream()
				.filter(marca -> marca.equals(marca))
				.collect(Collectors.toList());
	}
	
	public Marca getMarca(int idMarca) {
		return marcaRepo.findById(idMarca).orElse(null);
	}
	
	public void removeMarca(Integer[] lista) {
		Arrays.stream(lista).forEach(id ->{
			Marca marca= getMarca(id);
			
			if(marca != null) {
				marca.equals(marca);
				marcaRepo.save(marca);
			}
		});
	}
	
	
}
