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
public class Manicipalite  implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idManicipalite;
	 private String nom;
	 private Long nombreGens;
	 
	 @OneToMany(mappedBy="manicipalite")
	 private Collection<Gens> gens;
	 
	 @OneToMany(mappedBy="manicipality")
	 private Collection<Endroit> endoits;

	 
	public Collection<Endroit> getEndoits() {
		return endoits;
	}

	public void setEndoits(Collection<Endroit> endoits) {
		this.endoits = endoits;
	}

	public Long getIdManicipalite() {
		return idManicipalite;
	}

	public void setIdManicipalite(Long idManicipalite) {
		this.idManicipalite = idManicipalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getNombreGens() {
		return nombreGens;
	}

	public void setNombreGens(Long nombreGens) {
		this.nombreGens = nombreGens;
	}

	public Collection<Gens> getGens() {
		return gens;
	}

	public void setGens(Collection<Gens> gens) {
		this.gens = gens;
	}

	public Manicipalite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manicipalite(String nom, Long nombreGens) {
		super();
		this.nom = nom;
		this.nombreGens = nombreGens;
	}

	public Manicipalite(Long idManicipalite) {
		super();
		this.idManicipalite = idManicipalite;
	}
	 
	 
	 
}
