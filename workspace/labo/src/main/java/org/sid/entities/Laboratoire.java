package org.sid.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LABORATOIRE database table.
 * 
 */
@Entity
public class Laboratoire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_LAB")
	private String codeLab;

	private String adresse;

	@Column(name="NOM_LAB")
	private String nomLab;

	@Column(name="NUM_TEL")
	private Long numTel;

	//bi-directional one-to-one association to Chercheur
	@OneToOne(mappedBy="laboratoire")
	private Chercheur chercheur;

	//bi-directional many-to-one association to UniteRecherche
	@OneToMany(mappedBy="laboratoire")
	private List<UniteRecherche> uniteRecherches;

	public Laboratoire() {
	}

	public String getCodeLab() {
		return this.codeLab;
	}

	public void setCodeLab(String codeLab) {
		this.codeLab = codeLab;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNomLab() {
		return this.nomLab;
	}

	public void setNomLab(String nomLab) {
		this.nomLab = nomLab;
	}

	public Long getNumTel() {
		return this.numTel;
	}

	public void setNumTel(Long numTel) {
		this.numTel = numTel;
	}

	


	public Chercheur getChercheur() {
		return chercheur;
	}

	public void setChercheur(Chercheur chercheur) {
		this.chercheur = chercheur;
	}

	public List<UniteRecherche> getUniteRecherches() {
		return this.uniteRecherches;
	}

	public void setUniteRecherches(List<UniteRecherche> uniteRecherches) {
		this.uniteRecherches = uniteRecherches;
	}

	

	public Laboratoire(String codeLab, String adresse, String nomLab, Long numTel) {
		super();
		this.codeLab = codeLab;
		this.adresse = adresse;
		this.nomLab = nomLab;
		this.numTel = numTel;
	}

}