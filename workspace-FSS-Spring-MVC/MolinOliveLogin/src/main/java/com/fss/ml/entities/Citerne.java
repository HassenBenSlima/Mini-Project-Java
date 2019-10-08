package com.fss.ml.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("HUILE")
public class Citerne extends Stock{

      
	private int prixUT;
	private double quantiteHuile;
	private String qualiteHuile;
	
	public int getPrixUT() {
		return prixUT;
	}
	public void setPrixUT(int prixUT) {
		this.prixUT = prixUT;
	}
	public double getQuantiteHuile() {
		return quantiteHuile;
	}
	public void setQuantiteHuile(double quantiteHuile) {
		this.quantiteHuile = quantiteHuile;
	}
	public String getQualiteHuile() {
		return qualiteHuile;
	}
	public void setQualiteHuile(String qualiteHuile) {
		this.qualiteHuile = qualiteHuile;
	}
	
	public Citerne(String codeStock, double capacite, int prixUT, double quantiteHuile, String qualiteHuile) {
		super(codeStock, capacite);
		this.prixUT = prixUT;
		this.quantiteHuile = quantiteHuile;
		this.qualiteHuile = qualiteHuile;
	}
	public Citerne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
	
	
	
	
	
	
	
}
