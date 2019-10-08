package org.sid.dao;

import org.sid.entities.UniteRecherche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UniterRechercherRepository extends JpaRepository<UniteRecherche,Long >{
	
	@Query("select u from UniteRecherche u where u.nom like :x ")
	public Page<UniteRecherche> chercherUniteRecherche(@Param("x")String mc,Pageable pageable);
}
