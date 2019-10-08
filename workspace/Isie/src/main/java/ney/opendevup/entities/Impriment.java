package ney.opendevup.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Impriment")
public class Impriment extends Materiel {

	public Impriment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Impriment(String reference, String marque, String description) {
		super(reference, marque, description);
		// TODO Auto-generated constructor stub
	}

	public Impriment(String reference) {
		super(reference);
		// TODO Auto-generated constructor stub
	}
	
	
}
