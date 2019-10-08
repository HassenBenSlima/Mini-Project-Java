package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.FournisseurMaintenance;


public class FournMainForm {

	private String nomFourn;
	private List<FournisseurMaintenance> listfrounByname;
	private FournisseurMaintenance frounMain;
	private List<FournisseurMaintenance> listFournMain;
	
	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	
	public List<FournisseurMaintenance> getListfrounByname() {
		return listfrounByname;
	}
	public void setListfrounByname(List<FournisseurMaintenance> listfrounByname) {
		this.listfrounByname = listfrounByname;
	}
	public String getNomFourn() {
		return nomFourn;
	}
	public void setNomFourn(String nomFourn) {
		this.nomFourn = nomFourn;
	}
	public FournisseurMaintenance getFrounMain() {
		return frounMain;
	}
	public void setFrounMain(FournisseurMaintenance frounMain) {
		this.frounMain = frounMain;
	}
	public List<FournisseurMaintenance> getListFournMain() {
		return listFournMain;
	}
	public void setListFournMain(List<FournisseurMaintenance> listFournMain) {
		this.listFournMain = listFournMain;
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
