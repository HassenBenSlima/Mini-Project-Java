package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.Client;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.Stock;

public class FactureForm {
 	
	private Long cinClient;
	private Facture factur;
	private List<Facture> factureClient;
    private List <Stock> ctf;
    private int page=0;
	private int nbLigne=5;
	private int nombrePages;
	private Client client;
	private String exception;
    
	public Facture getFactur() {
		return factur;
	}
	public void setFactur(Facture factur) {
		this.factur = factur;
	}
	public List<Stock> getCtf() {
		return ctf;
	}
	public void setCtf(List<Stock> ctf) {
		this.ctf = ctf;
	}
	public Long getCinClient() {
		return cinClient;
	}
	public void setCinClient(Long cinClient) {
		this.cinClient = cinClient;
	}
	public List<Facture> getFactureClient() {
		return factureClient;
	}
	public void setFactureClient(List<Facture> factureClient) {
		this.factureClient = factureClient;
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

    
    
    
    
    }
