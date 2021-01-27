package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Patrimonio;

public interface PatrimonioRepo extends JpaRepository<Patrimonio, Integer> {

}
