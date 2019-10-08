package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MISSION_SC database table.
 * 
 */
@Entity
@Table(name="MISSION_SC")
@NamedQuery(name="MissionSc.findAll", query="SELECT m FROM MissionSc m")
public class MissionSc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUMERO_MISS")
	private long numeroMiss;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEPART")
	private Date dateDepart;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_RETOUR")
	private Date dateRetour;

	private String destination;

	private BigDecimal frais;

	//bi-directional many-to-one association to Chercheur
	@ManyToOne
	@JoinColumn(name="NUM_CHERCHEUR")
	private Chercheur chercheur;

	public MissionSc() {
	}

	public long getNumeroMiss() {
		return this.numeroMiss;
	}

	public void setNumeroMiss(long numeroMiss) {
		this.numeroMiss = numeroMiss;
	}

	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return this.dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getFrais() {
		return this.frais;
	}

	public void setFrais(BigDecimal frais) {
		this.frais = frais;
	}

	public Chercheur getChercheur() {
		return this.chercheur;
	}

	public void setChercheur(Chercheur chercheur) {
		this.chercheur = chercheur;
	}

}