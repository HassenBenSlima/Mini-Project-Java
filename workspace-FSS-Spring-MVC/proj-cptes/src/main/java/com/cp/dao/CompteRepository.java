package com.cp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
