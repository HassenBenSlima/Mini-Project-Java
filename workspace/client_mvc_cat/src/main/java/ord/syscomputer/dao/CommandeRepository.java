package ord.syscomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ord.syscomputer.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Long>{

}
