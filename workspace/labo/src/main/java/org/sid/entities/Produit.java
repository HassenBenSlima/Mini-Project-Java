package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7682802912819958568L;
	@Id
	@GeneratedValue
	private Long idproduit;
	@NotNull
	//@Size(min=5,max=12)
	private String designation;
	//@DecimalMin(value="100")
	private double prix;
	
	public Long getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(Long idproduit) {
		this.idproduit = idproduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(String designation, double prix) {
		super();
		this.designation = designation;
		this.prix = prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
