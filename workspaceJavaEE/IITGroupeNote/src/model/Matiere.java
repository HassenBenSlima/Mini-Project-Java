package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@NamedQuery(name="Matiere.findAll", query="SELECT m FROM Matiere m")
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private int coefficient;

	private int credit;

	private String libelle;

	private int volumeC;

	private int volumeTd;

	private int volumeTp;

	//bi-directional many-to-one association to Groupeenseignant
	@OneToMany(mappedBy="matiere")
	private List<Groupeenseignant> groupeenseignants;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="matiere")
	private List<Note> notes;

	public Matiere() {
	}
	public Matiere(int coefficient, int credit, String libelle, int volumeC, int volumeTd, int volumeTp) {
		super();
		this.coefficient = coefficient;
		this.credit = credit;
		this.libelle = libelle;
		this.volumeC = volumeC;
		this.volumeTd = volumeTd;
		this.volumeTp = volumeTp;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getVolumeC() {
		return this.volumeC;
	}

	public void setVolumeC(int volumeC) {
		this.volumeC = volumeC;
	}

	public int getVolumeTd() {
		return this.volumeTd;
	}

	public void setVolumeTd(int volumeTd) {
		this.volumeTd = volumeTd;
	}

	public int getVolumeTp() {
		return this.volumeTp;
	}

	public void setVolumeTp(int volumeTp) {
		this.volumeTp = volumeTp;
	}

	public List<Groupeenseignant> getGroupeenseignants() {
		return this.groupeenseignants;
	}

	public void setGroupeenseignants(List<Groupeenseignant> groupeenseignants) {
		this.groupeenseignants = groupeenseignants;
	}

	public Groupeenseignant addGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().add(groupeenseignant);
		groupeenseignant.setMatiere(this);

		return groupeenseignant;
	}

	public Groupeenseignant removeGroupeenseignant(Groupeenseignant groupeenseignant) {
		getGroupeenseignants().remove(groupeenseignant);
		groupeenseignant.setMatiere(null);

		return groupeenseignant;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setMatiere(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setMatiere(null);

		return note;
	}

}