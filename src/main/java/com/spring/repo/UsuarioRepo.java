package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
