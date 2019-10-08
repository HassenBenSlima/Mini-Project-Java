package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "produit" database table.
 * 
 */
@Entity
@Table(name="\"produit\"")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idproduit\"")
	private long idproduit;

	@Column(name="\"designation\"")
	private String designation;

	@Column(name="\"prix\"")
	private double prix;

	public Produit() {
	}

	public long getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(long idproduit) {
		this.idproduit = idproduit;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}