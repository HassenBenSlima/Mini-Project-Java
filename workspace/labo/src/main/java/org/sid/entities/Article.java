package org.sid.entities;



import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ARTICLE database table.
 * 
 */
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_ART")
	private String codeArt;

	@Column(name="NBRE_PAGE")
	private BigDecimal nbrePage;

	@Column(name="NOM_CONF")
	private String nomConf;

	private String titre;

	//bi-directional many-to-one association to Chercheur
	@ManyToOne
	@JoinColumn(name="NUM_CHERCHEUR")
	private Chercheur chercheur;

	public Article() {
	}

	public String getCodeArt() {
		return this.codeArt;
	}

	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}

	public BigDecimal getNbrePage() {
		return this.nbrePage;
	}

	public void setNbrePage(BigDecimal nbrePage) {
		this.nbrePage = nbrePage;
	}

	public String getNomConf() {
		return this.nomConf;
	}

	public void setNomConf(String nomConf) {
		this.nomConf = nomConf;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Chercheur getChercheur() {
		return this.chercheur;
	}

	public void setChercheur(Chercheur chercheur) {
		this.chercheur = chercheur;
	}

	public Article(String codeArt, BigDecimal nbrePage, String nomConf, String titre) {
		super();
		this.codeArt = codeArt;
		this.nbrePage = nbrePage;
		this.nomConf = nomConf;
		this.titre = titre;
	}
	
	

}