package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Client implements Serializable {
    
	@Id
    private Long cinClient;
	@NotEmpty
    private String nomClient;
	@NotEmpty
	private String prenomClient;
	@NotEmpty
	private String adrClient;
	
	@NotNull
	private Long telClient;
	
	@OneToMany(mappedBy="client")
	private Collection<Reservation> reservations;
	
	@OneToMany(mappedBy="client")
	private Collection<Facture> factures;
	
	
	public Long getCinClient() {
		return cinClient;
	}
	public void setCinClient(Long cinClient) {
		this.cinClient = cinClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdrClient() {
		return adrClient;
	}
	public void setAdrClient(String adrClient) {
		this.adrClient = adrClient;
	}
	public Long getTelClient() {
		return telClient;
	}
	public void setTelClient(Long telClient) {
		this.telClient = telClient;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Collection<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	public Client(Long cinClient, String nomClient, String prenomClient, String adrClient, Long telClient) {
		super();
		this.cinClient = cinClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adrClient = adrClient;
		this.telClient = telClient;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
			
}
