package ord.syscomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ord.syscomputer.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
