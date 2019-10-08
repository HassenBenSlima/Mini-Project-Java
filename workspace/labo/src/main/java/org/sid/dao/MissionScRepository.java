
package org.sid.dao;


import org.sid.entities.MissionSc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionScRepository extends JpaRepository<MissionSc, Long> {

	
	@Query("select m from MissionSc m where m.numeroMiss like :x ")
	public Page<MissionSc> chercherMissionSc(@Param("x")String mc,Pageable pageable);
}
