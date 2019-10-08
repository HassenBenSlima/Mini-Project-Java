package ney.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeGent implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String nom;
	
	@OneToMany(mappedBy="gtsType")
	private Collection<Gens> gentsType;

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Gens> getGentsType() {
		return gentsType;
	}

	public void setGentsType(Collection<Gens> gentsType) {
		this.gentsType = gentsType;
	}

	public TypeGent(String nom) {
		super();
		this.nom = nom;
	}

	public TypeGent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeGent(Long idType) {
		super();
		this.idType = idType;
	}
	
	
	
}
