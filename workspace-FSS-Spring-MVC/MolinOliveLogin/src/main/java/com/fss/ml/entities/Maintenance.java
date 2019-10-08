package com.fss.ml.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Maintenance implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMain;
	private String descpanne;
	private String dateMain;
	private double prixMain;
    
	@ManyToOne
	@JoinColumn(name="idCaisse")
	private Caisse caissem;
	

	@ManyToOne
	@JoinColumn(name="cinFourn")
	private Fournisseur fournisseurm;


	public Long getIdMain() {
		return idMain;
	}


	public void setIdMain(Long idMain) {
		this.idMain = idMain;
	}


	public String getDescpanne() {
		return descpanne;
	}


	public void setDescpanne(String descpanne) {
		this.descpanne = descpanne;
	}


	public String getDateMain() {
		return dateMain;
	}


	public void setDateMain(String dateMain) {
		this.dateMain = dateMain;
	}


	public double getPrixMain() {
		return prixMain;
	}


	public void setPrixMain(double prixMain) {
		this.prixMain = prixMain;
	}


	


	public Caisse getCaissem() {
		return caissem;
	}


	public void setCaissem(Caisse caissem) {
		this.caissem = caissem;
	}


	public Fournisseur getFournisseurm() {
		return fournisseurm;
	}


	public void setFournisseurm(Fournisseur fournisseurm) {
		this.fournisseurm = fournisseurm;
	}


	public Maintenance(String descpanne, String dateMain, double prixMain) {
		super();
		this.descpanne = descpanne;
		this.dateMain = dateMain;
		this.prixMain = prixMain;
	}


	public Maintenance() {
		super();
	}
	
	
	
	
}
