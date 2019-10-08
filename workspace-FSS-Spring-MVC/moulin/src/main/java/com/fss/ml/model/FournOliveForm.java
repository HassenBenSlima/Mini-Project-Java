package com.fss.ml.model;
    
import java.util.List;
    
import com.fss.ml.entities.FournisseurOlive;
    
    
public class FournOliveForm {
    
	
	private List<FournisseurOlive> listFournObyname;
	private String nomFourn;
	private FournisseurOlive frounOlive;
	private List<FournisseurOlive> listFournOlive;
	
	private int page=0;
	private int nbLigne=4;
	private int nombrePages;
	private String exception;
	
	
	public List<FournisseurOlive> getListFournObyname() {
		return listFournObyname;
	}
	public void setListFournObyname(List<FournisseurOlive> listFournObyname) {
		this.listFournObyname = listFournObyname;
	}
	public String getNomFourn() {
		return nomFourn;
	}
	public void setNomFourn(String nomFourn) {
		this.nomFourn = nomFourn;
	}
	public FournisseurOlive getFrounOlive() {
		return frounOlive;
	}
	public void setFrounOlive(FournisseurOlive frounOlive) {
		this.frounOlive = frounOlive;
	}
	public List<FournisseurOlive> getListFournOlive() {
		return listFournOlive;
	}
	public void setListFournOlive(List<FournisseurOlive> listFournOlive) {
		this.listFournOlive = listFournOlive;
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
