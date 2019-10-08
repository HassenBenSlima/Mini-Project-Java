package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRsv;
	private double prixRsv;
    @Size(max=10,min=10, message="la date doit etre sous la forme dd/mm/yyyy")
	@NotEmpty(message="s'il vous pait selectionné la date")
	private String dateRsv;
	
	@NotEmpty
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
