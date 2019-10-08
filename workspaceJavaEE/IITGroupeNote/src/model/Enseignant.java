package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enseignant database table.
 * 
 */
@Entity
@NamedQuery(name="Enseignant.findAll", query="SELECT e FROM Enseignant e")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String adresse;

	private String cin;

	private String email;

	private String matriculefiscal;

	private String motpasse;

	private String nom;

	private String prenom;

	private int responsableb;

	private int tel;

	//bi-directional many-to-one association to Groupeenseignant
	@OneToMany(mappedBy="enseignant")
	private List<Groupeenseignant> groupeenseignants;

	public Enseignant() {
	}
	
	public Enseignant( String adresse, String cin, String email, String matriculefiscal, String motpasse,
			String nom, String prenom, int responsableb, int tel) {
		super();
		
		this.adresse = adresse;
		this.cin = cin;
		this.email = email;
		this.matriculefiscal = matriculefiscal;
		this.motpasse = motpasse;
		this.nom = nom;
		this.prenom = prenom;
		this.responsableb = responsableb;
		this.tel = tel;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatriculefiscal() {
		return this.matriculefiscal;
	}

	public void setMatriculefiscal(String matriculefiscal) {
		this.matriculefiscal = matriculefiscal;
	}

	public String getMotpasse() {
		return this.motpasse;
	}

	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getResponsableb() {
		return this.responsableb;
	}

	public void setResponsableb(int responsableb) {
		this.responsableb = responsableb;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public List<Groupeenseignant> getGroupeenseignants() {
		return this.groupeenseignants;
	}

	public void setGroupeenseignants(List<Groupeenseignant> groupeenseignants) {
		this.groupeenseignants = groupeenseignants;
	}

	public Groupeenseignant addGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().add(groupeenseignant);
		groupeenseignant.setEnseignant(this);

		return groupeenseignant;
	}

	public Groupeenseignant removeGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().remove(groupeenseignant);
		groupeenseignant.setEnseignant(null);

		return groupeenseignant;
	}

}