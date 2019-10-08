package ord.syscomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ord.syscomputer.entities.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{

}
