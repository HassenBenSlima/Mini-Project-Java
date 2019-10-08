package ney.opendevup.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PC")
public class PC extends Materiel{

	public PC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PC(String reference, String marque, String description) {
		super(reference, marque, description);
		// TODO Auto-generated constructor stub
	}

	public PC(String reference) {
		super(reference);
		// TODO Auto-generated constructor stub
	}

	
}
