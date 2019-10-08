package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LABORATOIRE database table.
 * 
 */
@Entity
@NamedQuery(name="Laboratoire.findAll", query="SELECT l FROM Laboratoire l")
public class Laboratoire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_LAB")
	private String codeLab;

	private String adresse;

	@Column(name="NOM_LAB")
	private String nomLab;

	@Column(name="NUM_TEL")
	private String numTel;

	//bi-directional many-to-one association to Chercheur
	@OneToMany(mappedBy="laboratoire")
	private List<Chercheur> chercheurs;

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

	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public List<Chercheur> getChercheurs() {
		return this.chercheurs;
	}

	public void setChercheurs(List<Chercheur> chercheurs) {
		this.chercheurs = chercheurs;
	}

	public Chercheur addChercheur(Chercheur chercheur) {
		getChercheurs().add(chercheur);
		chercheur.setLaboratoire(this);

		return chercheur;
	}

	public Chercheur removeChercheur(Chercheur chercheur) {
		getChercheurs().remove(chercheur);
		chercheur.setLaboratoire(null);

		return chercheur;
	}

	public List<UniteRecherche> getUniteRecherches() {
		return this.uniteRecherches;
	}

	public void setUniteRecherches(List<UniteRecherche> uniteRecherches) {
		this.uniteRecherches = uniteRecherches;
	}

	public UniteRecherche addUniteRecherch(UniteRecherche uniteRecherch) {
		getUniteRecherches().add(uniteRecherch);
		uniteRecherch.setLaboratoire(this);

		return uniteRecherch;
	}

	public UniteRecherche removeUniteRecherch(UniteRecherche uniteRecherch) {
		getUniteRecherches().remove(uniteRecherch);
		uniteRecherch.setLaboratoire(null);

		return uniteRecherch;
	}

}