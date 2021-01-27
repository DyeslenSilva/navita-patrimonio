package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Patrimonio;
import com.spring.service.PatrimonioService;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {

	@Autowired
	private PatrimonioService servicePat;
	
	@PostMapping("/cadastraPatrimonio")
	public ResponseEntity<Object> cadastroPatrimonio(@RequestBody Patrimonio patrimonio){
		servicePat.save(patrimonio);
		return  ResponseEntity.ok().build();
	}
	
	@GetMapping("/listaDePatrimonios")
	public ResponseEntity<java.util.List<Patrimonio>> listaPatrimonio(){
		return ResponseEntity.ok(servicePat.getPatrimonios());
	}
	
	@RequestMapping("/editaPatrimonio/{idPatrimonio}")
	public ResponseEntity<Object> editaPatrimonio(@PathVariable int idPatrimonio){
		Patrimonio patrimonio = servicePat.getPatrimonios(idPatrimonio);
		
		if(patrimonio != null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/removePatrimonio")
	public ResponseEntity<Object> removePatrimonio(int[] lista){
		servicePat.removePatrimonio(lista);
		return ResponseEntity.ok().build();
	}
	
}
