package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.Citerne;

public class CiterneForm {

	private String codeStock;

	private String citernes;

	private List<Citerne> ctrns;
	private List <Citerne> citerneByName;
	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	private Citerne citerne;
	private double quantiterAjtHuile;
	
	
	
	
	public String getCiternes() {
		return citernes;
	}
	public void setCiternes(String citernes) {
		this.citernes = citernes;
	}
	public List<Citerne> getCiterneByName() {
		return citerneByName;
	}
	public void setCiterneByName(List<Citerne> citerneByName) {
		this.citerneByName = citerneByName;
	}
	public double getQuantiterAjtHuile() {
		return quantiterAjtHuile;
	}
	public void setQuantiterAjtHuile(double quantiterAjtHuile) {
		this.quantiterAjtHuile = quantiterAjtHuile;
	}
	public Citerne getCiterne() {
		return citerne;
	}
	public void setCiterne(Citerne citerne) {
		this.citerne = citerne;
	}
	public String getCodeStock() {
		return codeStock;
	}
	public void setCodeStock(String codeStock) {
		this.codeStock = codeStock;
	}
	public List<Citerne> getCtrns() {
		return ctrns;
	}
	public void setCtrns(List<Citerne> ctrns) {
		this.ctrns = ctrns;
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
