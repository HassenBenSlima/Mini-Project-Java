package org.sid.dao;

import org.sid.entities.Laboratoire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long>{

	@Query("select l from Laboratoire l where l.codeLab like :x ")
	public Page<Laboratoire> chercherLabo(@Param("x")String mc,Pageable pageable);
}
