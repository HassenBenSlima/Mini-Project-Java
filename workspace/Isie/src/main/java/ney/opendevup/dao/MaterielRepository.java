package ney.opendevup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ney.opendevup.entities.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, String> {

}
