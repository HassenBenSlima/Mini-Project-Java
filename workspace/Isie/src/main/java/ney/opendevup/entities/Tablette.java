package ney.opendevup.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Tablette")
public class Tablette extends Materiel {

	public Tablette() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tablette(String reference, String marque, String description) {
		super(reference, marque, description);
		// TODO Auto-generated constructor stub
	}

	public Tablette(String reference) {
		super(reference);
		// TODO Auto-generated constructor stub
	}

}
