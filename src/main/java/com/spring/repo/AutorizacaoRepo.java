package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Autorizacao;

public interface AutorizacaoRepo extends JpaRepository<Autorizacao, Integer> {

}
