package com.fss.ml.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historique implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistVente;
	private String code ;
	private double quantitevente;
	
	public Long getIdHistVente() {
		return idHistVente;
	}
	public void setIdHistVente(Long idHistVente) {
		this.idHistVente = idHistVente;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getQuantitevente() {
		return quantitevente;
	}
	public void setQuantitevente(double quantitevente) {
		this.quantitevente = quantitevente;
	}
	
	public Historique(Long idHistVente, String code, double quantitevente) {
		super();
		this.idHistVente = idHistVente;
		this.code = code;
		this.quantitevente = quantitevente;
	}
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
