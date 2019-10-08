package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BonAchat implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBA;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateBA;
	private double montantAchat;
	private String maturite;
	private double quantiteOL;
	private String regionOlive;
	
	@NotEmpty
	private String designation;
	
	@ManyToOne
	@JoinColumn(name="codeStock")
	private Stock stocko;
	
	
	@ManyToOne
	@JoinColumn(name="idCaisse")
	private Caisse caisse;
	
	@ManyToOne
	@JoinColumn(name="cinFourn")
	private Fournisseur fournisseuro;
    
	
	
	public Long getIdBA() {
		return idBA;
	}

	public void setIdBA(Long idBA) {
		this.idBA = idBA;
	}

	public Date getDateBA() {
		return dateBA;
	}

	public void setDateBA(Date dateBA) {
		this.dateBA = dateBA;
	}

		public String getMaturite() {
		return maturite;
	}

	public void setMaturite(String maturite) {
		this.maturite = maturite;
	}

	public double getQuantiteOL() {
		return quantiteOL;
	}

	public void setQuantiteOL(double quantiteOL) {
		this.quantiteOL = quantiteOL;
	}

	public String getRegionOlive() {
		return regionOlive;
	}

	public void setRegionOlive(String regionOlive) {
		this.regionOlive = regionOlive;
	}

	public Stock getStocko() {
		return   stocko;
	}

	public void setStocko(Stock stocko) {
		this.stocko = stocko;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public Fournisseur getFournisseuro() {
		return fournisseuro;
	}

	public void setFournisseuro(Fournisseur fournisseuro) {
		this.fournisseuro = fournisseuro;
	}

	

	public double getMontantAchat() {
		return montantAchat;
	}

	public void setMontantAchat(double montantAchat) {
		this.montantAchat = montantAchat;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BonAchat(Date dateBA, double montantAchat, String maturite, double quantiteOL, String regionOlive,
			String designation) {
		super();
		this.dateBA = dateBA;
		this.montantAchat = montantAchat;
		this.maturite = maturite;
		this.quantiteOL = quantiteOL;
		this.regionOlive = regionOlive;
		this.designation = designation;
	}

	public BonAchat() {
		super();
		// TODO Auto-generated constructor stub
	}

			
	
}
