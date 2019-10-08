package ney.opendevup.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Affectation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateAffectation;
	private String posteTravail ;
	@ManyToOne
	@JoinColumn(name="cin")
	private Gens gens;
	@ManyToOne
	@JoinColumn(name="idendroid")
	private Endroit endroit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public String getPosteTravail() {
		return posteTravail;
	}
	public void setPosteTravail(String posteTravail) {
		this.posteTravail = posteTravail;
	}
	public Gens getGens() {
		return gens;
	}
	public void setGens(Gens gens) {
		this.gens = gens;
	}
	public Endroit getEndroit() {
		return endroit;
	}
	public void setEndroit(Endroit endroit) {
		this.endroit = endroit;
	}
	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Affectation(Date dateAffectation, String posteTravail) {
		super();
		this.dateAffectation = dateAffectation;
		this.posteTravail = posteTravail;
	}
	
	public Affectation(Date dateAffectation, String posteTravail, Gens gens, Endroit endroit) {
		super();
		this.dateAffectation = dateAffectation;
		this.posteTravail = posteTravail;
		this.gens = gens;
		this.endroit = endroit;
	}
	
	

	
	
}
