package com.fss.ml.model;

import java.util.List;

import com.fss.ml.entities.Employe;

public class EmployerForm {
	
	private Long cinEmp;
	private Employe employ;
	private List<Employe> empll;
	
	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	
	public Long getCinEmp() {
		return cinEmp;
	}
	public void setCinEmp(Long cinEmp) {
		this.cinEmp = cinEmp;
	}
	public Employe getEmploy() {
		return employ;
	}
	public void setEmploy(Employe employ) {
		this.employ = employ;
	}
	public List<Employe> getEmpll() {
		return empll;
	}
	public void setEmpll(List<Employe> empll) {
		this.empll = empll;
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
