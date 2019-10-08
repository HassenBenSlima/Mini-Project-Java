package ney.opendevup.web;

import org.springframework.data.jpa.repository.JpaRepository;

import ney.opendevup.entities.TypeGent;


public interface TypeRepository extends JpaRepository<TypeGent, Long> {

}
