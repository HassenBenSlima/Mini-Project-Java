package com.cp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cp.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("select c from Client c where c.nom like :x ")
	public List<Client> clientsParMC(@Param("x") String mc);
	
}
