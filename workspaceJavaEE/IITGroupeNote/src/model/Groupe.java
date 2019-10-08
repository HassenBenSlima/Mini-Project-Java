package model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.Session;

import hibernate.util.HibernateUtil;

import java.util.List;


/**
 * The persistent class for the groupe database table.
 * 
 */
@Entity
@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g")
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String abreviation;

	private String nom;
	
	private int nbEtudiant;

	//bi-directional many-to-one association to Etudiant
	@OneToMany(mappedBy="groupe")
	private List<Etudiant> etudiants;

	//bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name="codeNiveau")
	private Niveau niveau;

	//bi-directional many-to-one association to Groupeenseignant
	@OneToMany(mappedBy="groupe")
	private List<Groupeenseignant> groupeenseignants;

	public Groupe() {
	}
	

	public Groupe(String abreviation, String nom, Niveau niveau) {
		super();
		this.abreviation = abreviation;
		this.nom = nom;
		this.niveau = niveau;
	}
	
	



	public int getNbEtudiant() {
		return etudiants.size();
	}


	public void setNbEtudiant() {
		this.nbEtudiant = etudiants.size();
	}


	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAbreviation() {
		return this.abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant addEtudiant(Etudiant etudiant) {
		getEtudiants().add(etudiant);
		etudiant.setGroupe(this);

		return etudiant;
	}

	public Etudiant removeEtudiant(Etudiant etudiant) {
		getEtudiants().remove(etudiant);
		etudiant.setGroupe(null);

		return etudiant;
	}

	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Groupeenseignant> getGroupeenseignants() {
		return this.groupeenseignants;
	}

	public void setGroupeenseignants(List<Groupeenseignant> groupeenseignants) {
		this.groupeenseignants = groupeenseignants;
	}

	public Groupeenseignant addGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().add(groupeenseignant);
		groupeenseignant.setGroupe(this);

		return groupeenseignant;
	}

	public Groupeenseignant removeGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().remove(groupeenseignant);
		groupeenseignant.setGroupe(null);

		return groupeenseignant;
	}

}