package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int compostage;

	private float noteds;

	private float noteexam;

	private float notepresentielle;

	private float notetp;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="codeMa")
	private Matiere matiere;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="codeEt")
	private Etudiant etudiant;

	public Note() {
	}
	

	public Note(int compostage, Matiere matiere, Etudiant etudiant) {
		super();
		this.compostage = compostage;
		this.matiere = matiere;
		this.etudiant = etudiant;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompostage() {
		return this.compostage;
	}

	public void setCompostage(int compostage) {
		this.compostage = compostage;
	}

	public float getNoteds() {
		return this.noteds;
	}

	public void setNoteds(float noteds) {
		this.noteds = noteds;
	}

	public float getNoteexam() {
		return this.noteexam;
	}

	public void setNoteexam(float noteexam) {
		this.noteexam = noteexam;
	}

	public float getNotepresentielle() {
		return this.notepresentielle;
	}

	public void setNotepresentielle(float notepresentielle) {
		this.notepresentielle = notepresentielle;
	}

	public float getNotetp() {
		return this.notetp;
	}

	public void setNotetp(float notetp) {
		this.notetp = notetp;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}