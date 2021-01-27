package com.spring.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Autorizacao;
import com.spring.model.Usuario;
import com.spring.repo.AutorizacaoRepo;
import com.spring.repo.UsuarioRepo;

import antlr.collections.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepo repoUsuario;
	
	private AutorizacaoRepo autorizacaoRepo;
	
	public void cadastrarUsuario(Usuario usuario) {
		repoUsuario.save(usuario);
	}
	
	public java.util.List<Usuario> getUsuarios(){
		return repoUsuario.findAll().stream()
				.filter(usuario -> usuario.equals(usuario))
				.collect(Collectors.toList());
	}
	
	public Usuario getUsuario(Integer idUsuario) {
		return repoUsuario.findById(idUsuario).orElse(null);
	}
	
	public boolean removeUsuario(Integer idUsuario) {
		Usuario usuario = getUsuario(idUsuario);
		
		if(usuario != null) {
			Autorizacao autorizacao = autorizacaoRepo.findById(idUsuario).orElse(null);
			if(autorizacao != null) {
				autorizacaoRepo.delete(autorizacao);
			}
			
			repoUsuario.delete(usuario);
			
			return true;
		} else {
			return false;
		}
	}
}
