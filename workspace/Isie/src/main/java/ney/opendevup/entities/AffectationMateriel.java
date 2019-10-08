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
public class AffectationMateriel implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAffectationMateriel;
	
	private Date dateMateriel;
	
	@ManyToOne
	@JoinColumn(name="cin")
	private Gens gensM;
	
	@ManyToOne
	@JoinColumn(name="reference")
	private Materiel materiel;

	public Long getIdAffectationMateriel() {
		return idAffectationMateriel;
	}

	public void setIdAffectationMateriel(Long idAffectationMateriel) {
		this.idAffectationMateriel = idAffectationMateriel;
	}

	public Date getDateMateriel() {
		return dateMateriel;
	}

	public void setDateMateriel(Date dateMateriel) {
		this.dateMateriel = dateMateriel;
	}




	public Gens getGensM() {
		return gensM;
	}

	public void setGensM(Gens gensM) {
		this.gensM = gensM;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public AffectationMateriel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectationMateriel(Date dateMateriel, Gens gensM, Materiel materiel) {
		super();
		this.dateMateriel = dateMateriel;
		this.gensM = gensM;
		this.materiel = materiel;
	}
	

	
	
	

}
