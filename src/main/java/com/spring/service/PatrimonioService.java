package com.spring.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Patrimonio;
import com.spring.repo.PatrimonioRepo;

import antlr.collections.List;

@Service
public class PatrimonioService {

	@Autowired
	private PatrimonioRepo patrimonioRepo;
	
	public void save(Patrimonio patrimonio) {
		patrimonioRepo.save(patrimonio);
	}
	
	public java.util.List<Patrimonio> getPatrimonios(){
		return patrimonioRepo.findAll().stream().filter(patrimonio -> patrimonio.equals(patrimonio))
				.collect(Collectors.toList());
	}
	
	public Patrimonio getPatrimonios(Integer idPatrimonio) {
		return patrimonioRepo.findById(idPatrimonio).orElse(null);
	}
	
	
	public void removePatrimonio(int[] lista) {
		Arrays.stream(lista).forEach(idPatrimonio ->{
			Patrimonio patrimonio = getPatrimonios(idPatrimonio);
			
			if(patrimonio !=null) {
				patrimonio.equals(null);
				patrimonioRepo.save(patrimonio);
			}
		});
	}
}
