package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the niveau database table.
 * 
 */
@Entity
@NamedQuery(name="Niveau.findAll", query="SELECT n FROM Niveau n")
public class Niveau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private int nbrgroupe;

	private String nom;

	//bi-directional many-to-one association to Groupe
	@OneToMany(mappedBy="niveau")
	private List<Groupe> groupes;

	public Niveau() {
	}
	

	public Niveau(int nbrgroupe, String nom) {
		super();
		this.nbrgroupe = nbrgroupe;
		this.nom = nom;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNbrgroupe() {
		return this.nbrgroupe;
	}

	public void setNbrgroupe(int nbrgroupe) {
		this.nbrgroupe = nbrgroupe;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Groupe> getGroupes() {
		return this.groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe addGroupe(Groupe groupe) {
		getGroupes().add(groupe);
		groupe.setNiveau(this);

		return groupe;
	}

	public Groupe removeGroupe(Groupe groupe) {
		getGroupes().remove(groupe);
		groupe.setNiveau(null);

		return groupe;
	}

}