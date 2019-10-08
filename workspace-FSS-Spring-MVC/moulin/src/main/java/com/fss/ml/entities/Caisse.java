package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Caisse implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCaisse;
	private double solde;
	
	//@Transient
	//private double mt;

	@OneToMany(mappedBy="caissef")
	private Collection<Facture> factures;

	
	@OneToMany(mappedBy="caissem")
	private Collection<Maintenance> maintenances;

	
	@OneToMany(mappedBy="caisse")
	private Collection<BonAchat> bonachats;

	public Long getIdCaisse() {
		return idCaisse;
	}

	public void setIdCaisse(Long idCaisse) {
		this.idCaisse = idCaisse;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Collection<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}

	public Collection<Maintenance> getMaintenances() {
		return maintenances;
	}

	public void setMaintenances(Collection<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}

	public Collection<BonAchat> getBonachats() {
		return bonachats;
	}

	public void setBonachats(Collection<BonAchat> bonachats) {
		this.bonachats = bonachats;
	}

	public Caisse(double solde) {
		super();
		this.solde = solde;
	}

	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
