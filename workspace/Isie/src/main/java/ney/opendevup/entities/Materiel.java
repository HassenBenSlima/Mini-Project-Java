package ney.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_Materiel",
					discriminatorType=DiscriminatorType.STRING,length=10)
public abstract class  Materiel implements Serializable{
	
	@Id 
	private String reference;
	@NotEmpty
	private String marque;
	@NotEmpty
	private String description;
	
	
	@OneToMany(mappedBy="materiel")
	private Collection<AffectationMateriel> AffectationMtrl;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	    
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<AffectationMateriel> getAffectationMtrl() {
		return AffectationMtrl;
	}

	public void setAffectationMtrl(Collection<AffectationMateriel> affectationMtrl) {
		AffectationMtrl = affectationMtrl;
	}

	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel(String reference, String marque, String description) {
		super();
		this.reference = reference;
		this.marque = marque;
		this.description = description;
	}

	public Materiel(String reference) {
		super();
		this.reference = reference;
	}
	
	
}
