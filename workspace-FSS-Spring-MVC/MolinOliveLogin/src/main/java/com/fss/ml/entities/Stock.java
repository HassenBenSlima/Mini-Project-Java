package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_STK",
discriminatorType=DiscriminatorType.STRING, length=5)
public class Stock implements Serializable{
	
	@Id
	private String codeStock;
	private double capacite;
	
	@ManyToMany
	@JoinTable(name="FACT_C",joinColumns=
	@JoinColumn(name="codeStock"),
	inverseJoinColumns=@JoinColumn(name="idVente"))
	private Collection<Facture> factures;
	
	
	@OneToMany(mappedBy="stocko")
	private Collection<BonAchat> bonachats;
    

	public String getCodeStock() {
		return codeStock;
	}



	public void setCodeStock(String codeStock) {
		this.codeStock = codeStock;
	}



	public double getCapacite() {
		return capacite;
	}



	public void setCapacite(double capacite) {
		this.capacite = capacite;
	}



	public Collection<Facture> getFactures() {
		return factures;
	}



	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}



	public Collection<BonAchat> getBonachats() {
		return bonachats;
	}



	public void setBonachats(Collection<BonAchat> bonachats) {
		this.bonachats = bonachats;
	}



	public Stock(String codeStock, double capacite) {
		super();
		this.codeStock = codeStock;
		this.capacite = capacite;
	}



	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	}
