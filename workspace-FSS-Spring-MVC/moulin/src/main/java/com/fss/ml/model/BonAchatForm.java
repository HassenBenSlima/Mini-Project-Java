package com.fss.ml.model;


import java.util.List;

import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.FournisseurOlive;

public class BonAchatForm {

	
	private Long cinFourn;
	private BonAchat bont;
	private FournisseurOlive fro;
    private List<BonAchat> listbons;
	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	
	public BonAchat getBont() {
		return bont;
	}
	public void setBont(BonAchat bont) {
		this.bont = bont;
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
	public Long getCinFourn() {
		return cinFourn;
	}
	public void setCinFourn(Long cinFourn) {
		this.cinFourn = cinFourn;
	}
	public List<BonAchat> getListbons() {
		return listbons;
	}
	public void setListbons(List<BonAchat> listbons) {
		this.listbons = listbons;
	}
	public FournisseurOlive getFro() {
		return fro;
	}
	public void setFro(FournisseurOlive fro) {
		this.fro = fro;
	}
	
	
	
		
}
