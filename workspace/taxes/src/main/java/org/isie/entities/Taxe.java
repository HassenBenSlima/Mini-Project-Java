package org.isie.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;import org.springframework.data.domain.ExampleMatcher.StringMatcher;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",
discriminatorType=DiscriminatorType.STRING, length=3)
public abstract class Taxe implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String titre;
	private Date dateTaxe;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="CODE_ENT")
	private Entreprise entreprise;
	
public Taxe(String titre, Date dateTaxe, double montant, Entreprise entreprise) {
		super();
		this.titre = titre;
		this.dateTaxe = dateTaxe;
		this.montant = montant;
		this.entreprise = entreprise;
	}

	public Taxe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
