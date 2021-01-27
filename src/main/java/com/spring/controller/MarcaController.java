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

import com.spring.model.Marca;
import com.spring.model.Usuario;
import com.spring.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/cadastroMarca")
	public ResponseEntity<Object> cadastroMarca(@RequestBody Marca marca){
		marcaService.salvarMarca(marca);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/listaMarca")
	public ResponseEntity<Object> listaMarca(){
		return ResponseEntity.ok(marcaService.getMarcas());
	}
	
	@GetMapping("/editaMarca/{idMarca}")
	public ResponseEntity<Object> editaUsuario(@PathVariable("idMarca") Integer idMarca){
		Marca marca = marcaService.getMarca(idMarca);
		
		if(marca != null) {
			return ResponseEntity.ok(marca);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/apagaMarca/{idMarca}")
	public ResponseEntity<Object> deleteMarca(@PathVariable("idMarca") Integer []idMarca){
		marcaService.removeMarca(idMarca);
		return ResponseEntity.ok().build();
	}
	
	
}
