package ney.opendevup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ney.opendevup.entities.Endroit;

public interface EndroidRepository extends JpaRepository<Endroit,Long> {

	@Query("select e from Endroit e where e.manicipality.idManicipalite= :x")
	List<Endroit>chercherEndroitByManicipalite(@Param ("x") Long mc);
}
