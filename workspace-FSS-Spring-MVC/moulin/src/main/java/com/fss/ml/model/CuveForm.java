package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.CuveOlives;


public class CuveForm {

	
	private String codeStock;
	
	private String cuve;
	private List<CuveOlives> listcuve;
	private List<CuveOlives> rechCuveByName;

	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	private CuveOlives cuveOlive;
	private double quantiterRtrOlive;
	
	
	
	
	public String getCuve() {
		return cuve;
	}
	public void setCuve(String cuve) {
		this.cuve = cuve;
	}
	public List<CuveOlives> getRechCuveByName() {
		return rechCuveByName;
	}
	public void setRechCuveByName(List<CuveOlives> rechCuveByName) {
		this.rechCuveByName = rechCuveByName;
	}
	public double getQuantiterRtrOlive() {
		return quantiterRtrOlive;
	}
	public void setQuantiterRtrOlive(double quantiterRtrOlive) {
		this.quantiterRtrOlive = quantiterRtrOlive;
	}
	public String getCodeStock() {
		return codeStock;
	}
	public void setCodeStock(String codeStock) {
		this.codeStock = codeStock;
	}
	public List<CuveOlives> getListcuve() {
		return listcuve;
	}
	public void setListcuve(List<CuveOlives> listcuve) {
		this.listcuve = listcuve;
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
	public CuveOlives getCuveOlive() {
		return cuveOlive;
	}
	public void setCuveOlive(CuveOlives cuveOlive) {
		this.cuveOlive = cuveOlive;
	}





}
