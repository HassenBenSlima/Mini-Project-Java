package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idVente;
	private String typeReglement;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateVente;
	private double montantf;
	private double quantite;
	
	private String designation;
	
	@ManyToOne
	@JoinColumn(name="cinClient")
	private Client client;

    
    @ManyToMany(mappedBy="factures")
	private Collection<Stock> citernes;
	
    
    @ManyToOne
    @JoinColumn(name="idCaisse")
    private Caisse caissef;


	public Long getIdVente() {
		return idVente;
	}


	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}


	public String getTypeReglement() {
		return typeReglement;
	}


	public void setTypeReglement(String typeReglement) {
		this.typeReglement = typeReglement;
	}


	public Date getDateVente() {
		return dateVente;
	}


	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}


	public double getMontantf() {
		return montantf;
	}


	public void setMontantf(double montantf) {
		this.montantf = montantf;
	}


	public double getQuantite() {
		return quantite;
	}


	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Collection<Stock> getCiternes() {
		return citernes;
	}


	public void setCiternes(Collection<Stock> citernes) {
		this.citernes = citernes;
	}


	

	public Caisse getCaissef() {
		return caissef;
	}


	public void setCaissef(Caisse caissef) {
		this.caissef = caissef;
	}

    
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	

	public Facture(String typeReglement, Date dateVente, double montantf, double quantite, String designation) {
		super();
		this.typeReglement = typeReglement;
		this.dateVente = dateVente;
		this.montantf = montantf;
		this.quantite = quantite;
		this.designation = designation;
	}


	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	    

}
