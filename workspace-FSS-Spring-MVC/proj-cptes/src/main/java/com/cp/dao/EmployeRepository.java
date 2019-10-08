package com.cp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
