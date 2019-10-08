package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.Client;


public class ClientForm {
   
	private Long cinClient;
	private Client clt;
	private List<Client> listClient;
	
	private int page=0;
	private int nbLigne=2;
	private int nombrePages;
	private String exception;
	public Long getCinClient() {
		return cinClient;
	}
	public void setCinClient(Long cinClient) {
		this.cinClient = cinClient;
	}
	public Client getClt() {
		return clt;
	}
	public void setClt(Client clt) {
		this.clt = clt;
	}
	
	
	
	public List<Client> getListClient() {
		return listClient;
	}
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
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
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
	
	
}
