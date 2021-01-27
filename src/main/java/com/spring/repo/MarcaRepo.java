package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Marca;

public interface MarcaRepo extends JpaRepository<Marca, Integer> {

}
