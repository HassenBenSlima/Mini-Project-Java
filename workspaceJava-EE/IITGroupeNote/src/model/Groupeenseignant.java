package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the groupeenseignant database table.
 * 
 */
@Entity
@NamedQuery(name="Groupeenseignant.findAll", query="SELECT g FROM Groupeenseignant g")
public class Groupeenseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;


	private String annee;

	@Temporal(TemporalType.DATE)
	private Date dateAffectation;

	private String semestre;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="codeEnseig")
	private Enseignant enseignant;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="codeGroupe")
	private Groupe groupe;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="codeMatiere")
	private Matiere matiere;

	public Groupeenseignant() {
	}
	

	public Groupeenseignant(String annee, Date dateAffectation, String semestre, Enseignant enseignant, Groupe groupe,
			Matiere matiere) {
		super();
		this.annee = annee;
		this.dateAffectation = dateAffectation;
		this.semestre = semestre;
		this.enseignant = enseignant;
		this.groupe = groupe;
		this.matiere = matiere;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getDateAffectation() {
		
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
		return  dataFormat.format(this.dateAffectation); 
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}