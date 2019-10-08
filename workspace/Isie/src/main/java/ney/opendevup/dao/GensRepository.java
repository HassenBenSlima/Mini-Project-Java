package ney.opendevup.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ney.opendevup.entities.Gens;

public interface GensRepository extends JpaRepository<Gens,Long>{

	@Query("select gen from Gens gen where str(gen.cin) like :x or gen.nom like :x")
	public Page <Gens> chercherGensByCin(@Param("x") String mc,Pageable pePageable);

	
	@Query("select g from Gens g where g.manicipalite.idManicipalite= :x")
	public List<Gens> chercherGensByManicipalité(@Param("x") Long mc);

}
