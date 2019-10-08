package com.fss.ml.model;

import java.util.Collection;
import java.util.List;

import com.fss.ml.entities.Client;
import com.fss.ml.entities.Reservation;

public class ReseservationClForm {
	
	private Long cinClient;
	private Collection<Reservation> reservations;
	private int page=0;
	private int nbLigne=2;
	private int nombrePages;
	private Client client;
	private String exception;
	
	private String dateRsv;
	private  List<Reservation> rsvByDat;
	private List<Reservation> listRsv;
	
	
	
	
	
	public Long getCinClient() {
		return cinClient;
	}
	public void setCinClient(Long cinClient) {
		this.cinClient = cinClient;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNbLigne() {
		return nbLigne;
	}
	public void setNbLigne(int nbLigne) {
		this.nbLigne = nbLigne;
	}
	public int getNombrePages() {
		return nombrePages;
	}
	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getDateRsv() {
		return dateRsv;
	}
	public void setDateRsv(String dateRsv) {
		this.dateRsv = dateRsv;
	}
	public List<Reservation> getRsvByDat() {
		return rsvByDat;
	}
	public void setRsvByDat(List<Reservation> rsvByDat) {
		this.rsvByDat = rsvByDat;
	}
	public List<Reservation> getListRsv() {
		return listRsv;
	}
	public void setListRsv(List<Reservation> listRsv) {
		this.listRsv = listRsv;
	}

	
	
	
	
		
}
