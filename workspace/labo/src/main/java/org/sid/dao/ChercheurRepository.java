package org.sid.dao;

import org.sid.entities.Chercheur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChercheurRepository extends JpaRepository<Chercheur, Long>{

	@Query("select c from Chercheur c where c.nom like :x ")
	public Page<Chercheur> chercherChercheur(@Param("x")String mc,Pageable pageable);
	
}
