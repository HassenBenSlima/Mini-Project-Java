package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRsv;
	private double prixRsv;
	private String dateRsv;
	private String descriptionRsv;
    
	@ManyToOne
	@JoinColumn(name="cinClient")
	private Client client;

	public Long getIdRsv() {
		return idRsv;
	}

	public void setIdRsv(Long idRsv) {
		this.idRsv = idRsv;
	}

	public double getPrixRsv() {
		return prixRsv;
	}

	public void setPrixRsv(double prixRsv) {
		this.prixRsv = prixRsv;
	}

	
	public String getDateRsv() {
		return dateRsv;
	}

	public void setDateRsv(String dateRsv) {
		this.dateRsv = dateRsv;
	}

	public String getDescriptionRsv() {
		return descriptionRsv;
	}

	public void setDescriptionRsv(String descriptionRsv) {
		this.descriptionRsv = descriptionRsv;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Reservation(double prixRsv, String dateRsv, String descriptionRsv) {
		super();
		this.prixRsv = prixRsv;
		this.dateRsv = dateRsv;
		this.descriptionRsv = descriptionRsv;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
