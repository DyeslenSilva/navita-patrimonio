package com.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.component.JsonError;
import com.spring.model.Usuario;
import com.spring.service.UsuarioService;

import antlr.collections.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastraUsuario")
	public ResponseEntity<Object> cadastroDoUsuario(@RequestBody @Valid Usuario usuario, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.unprocessableEntity()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(JsonError.build(result));
		}else {
			usuarioService.cadastrarUsuario(usuario);
			return ResponseEntity.ok().build();
		}
	}
	
	@RequestMapping("/listaUsuario")
	public ResponseEntity<java.util.List<Usuario>> listaUsuario(){
		return ResponseEntity.ok(usuarioService.getUsuarios());
	}
	
	@RequestMapping("/editaUsuario/{idUsuario}")
	public ResponseEntity<Object> editaUsuario(@PathVariable("idUsuario") Integer idUsuario){
		Usuario usuario = usuarioService.getUsuario(idUsuario);
		if(usuario != null) {
			usuario.setOld_nome(usuario.getNome());
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping("/removeUsuario/{idUsuario")
	public ResponseEntity<Object> removeUsuario(@PathVariable("idUsuario") Integer idUsuario){
		if(usuarioService.removeUsuario(idUsuario)) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
	
	
}
