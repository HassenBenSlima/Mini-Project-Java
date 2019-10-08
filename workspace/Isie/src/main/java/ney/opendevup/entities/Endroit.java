package ney.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Endroit implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idendroid;
	private String nom;
	private String description;
	
	@OneToMany(mappedBy="endroit")
	private Collection<Affectation> affectationEnEndroit;

	public Long getIdendroid() {
		return idendroid;
	}
	
	@ManyToOne
	@JoinColumn(name="idManicipalite")
	private Manicipalite manicipality;

	
	public void setIdendroid(Long idendroid) {
		this.idendroid = idendroid;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Affectation> getAffectationEnEndroit() {
		return affectationEnEndroit;
	}

	public void setAffectationEnEndroit(Collection<Affectation> affectationEnEndroit) {
		this.affectationEnEndroit = affectationEnEndroit;
	}

	public Endroit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endroit(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Endroit(Long idendroid) {
		super();
		this.idendroid = idendroid;
	}

	public Endroit(String nom, String description, Manicipalite manicipality) {
		super();
		this.nom = nom;
		this.description = description;
		this.manicipality = manicipality;
	}

	
}
