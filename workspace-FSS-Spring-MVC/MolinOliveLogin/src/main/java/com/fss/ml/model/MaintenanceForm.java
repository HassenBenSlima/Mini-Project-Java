package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.Maintenance;

public class MaintenanceForm {

	
	private String nameFourn;
	private Maintenance maitn;
	private List<Maintenance> mainByName;
    private List<Maintenance> listmaints ;
    
	private int page=0;
	private int nbLigne=3;
	private int nombrePages;
	private String exception;
	public String getNameFourn() {
		return nameFourn;
	}
	public void setNameFourn(String nameFourn) {
		this.nameFourn = nameFourn;
	}
	public Maintenance getMaitn() {
		return maitn;
	}
	public void setMaitn(Maintenance maitn) {
		this.maitn = maitn;
	}
	public List<Maintenance> getMainByName() {
		return mainByName;
	}
	public void setMainByName(List<Maintenance> mainByName) {
		this.mainByName = mainByName;
	}
	public List<Maintenance> getListmaints() {
		return listmaints;
	}
	public void setListmaints(List<Maintenance> listmaints) {
		this.listmaints = listmaints;
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
