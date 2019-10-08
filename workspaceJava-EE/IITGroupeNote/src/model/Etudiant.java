package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String adresse;

	private String cin;

	private String email;

	private String motpasse;

	private String nom;

	private int numinsci;

	private String prenom;

	private int tel;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="codeGroupe")
	private Groupe groupe;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="etudiant")
	private List<Note> notes;

	public Etudiant() {
	}
	
	public Etudiant( String adresse, String cin, String email, String motpasse, String nom, int numinsci,
			String prenom, int tel, Groupe groupe) {
		super();
		
		this.adresse = adresse;
		this.cin = cin;
		this.email = email;
		this.motpasse = motpasse;
		this.nom = nom;
		this.numinsci = numinsci;
		this.prenom = prenom;
		this.tel = tel;
		this.groupe = groupe;
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

	public int getNuminsci() {
		return this.numinsci;
	}

	public void setNuminsci(int numinsci) {
		this.numinsci = numinsci;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setEtudiant(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setEtudiant(null);

		return note;
	}

}