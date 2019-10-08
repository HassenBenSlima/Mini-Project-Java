package org.sid.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;



/**
 * The persistent class for the UNITE_RECHERCHE database table.
 * 
 */
@Entity
@Table(name="UNITE_RECHERCHE")
public class UniteRecherche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_UNT")
	private Long numUnt;

	private String adresse;

	private String nom;

	@Column(name="NUM_TEL")
	private Long numTel;

	//bi-directional many-to-one association to Chercheur
	@OneToMany(mappedBy="uniteRecherche")
	private List<Chercheur> chercheurs1;

	//bi-directional many-to-many association to Chercheur
	@ManyToMany
	@JoinTable(
		name="DERIGER"
		, joinColumns={
			@JoinColumn(name="NUM_UNT")
			}
		, inverseJoinColumns={
			@JoinColumn(name="NUM_CHERCHEUR")
			}
		)
	private List<Chercheur> chercheurs2;

	//bi-directional many-to-one association to Laboratoire
	@ManyToOne
	@JoinColumn(name="CODE_LAB")
	private Laboratoire laboratoire;

	public UniteRecherche() {
	}

	public long getNumUnt() {
		return this.numUnt;
	}

	public void setNumUnt(long numUnt) {
		this.numUnt = numUnt;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getNumTel() {
		return this.numTel;
	}

	public void setNumTel(Long numTel) {
		this.numTel = numTel;
	}

	public List<Chercheur> getChercheurs1() {
		return this.chercheurs1;
	}

	public void setChercheurs1(List<Chercheur> chercheurs1) {
		this.chercheurs1 = chercheurs1;
	}


	public List<Chercheur> getChercheurs2() {
		return this.chercheurs2;
	}

	public void setChercheurs2(List<Chercheur> chercheurs2) {
		this.chercheurs2 = chercheurs2;
	}

	public Laboratoire getLaboratoire() {
		return this.laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public UniteRecherche(long numUnt, String adresse, String nom, Long numTel) {
		super();
		this.numUnt = numUnt;
		this.adresse = adresse;
		this.nom = nom;
		this.numTel = numTel;
	}
	

}