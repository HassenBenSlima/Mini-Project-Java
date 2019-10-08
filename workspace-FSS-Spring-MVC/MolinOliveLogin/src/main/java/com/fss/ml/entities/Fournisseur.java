package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FRN",
discriminatorType=DiscriminatorType.STRING, length=4)
public class Fournisseur implements Serializable {
   
	@Id
	private Long cinFourn;
	private String nomFourn;
	private String prenomFourn;
	private Long telFourn ;
	private String adrFourn;
	
	@OneToMany(mappedBy="fournisseurm")
	private Collection<Maintenance> maintenances ;
	
	@OneToMany(mappedBy="fournisseuro")
	private Collection<BonAchat> bonachats;

	public Long getCinFourn() {
		return cinFourn;
	}

	public void setCinFourn(Long cinFourn) {
		this.cinFourn = cinFourn;
	}

	public String getNomFourn() {
		return nomFourn;
	}

	public void setNomFourn(String nomFourn) {
		this.nomFourn = nomFourn;
	}

	public String getPrenomFourn() {
		return prenomFourn;
	}

	public void setPrenomFourn(String prenomFourn) {
		this.prenomFourn = prenomFourn;
	}

	public Long getTelFourn() {
		return telFourn;
	}

	public void setTelFourn(Long telFourn) {
		this.telFourn = telFourn;
	}

	public String getAdrFourn() {
		return adrFourn;
	}

	public void setAdrFourn(String adrFourn) {
		this.adrFourn = adrFourn;
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

	public Fournisseur(Long cinFourn, String nomFourn, String prenomFourn, Long telFourn, String adrFourn) {
		super();
		this.cinFourn = cinFourn;
		this.nomFourn = nomFourn;
		this.prenomFourn = prenomFourn;
		this.telFourn = telFourn;
		this.adrFourn = adrFourn;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}


		
}
