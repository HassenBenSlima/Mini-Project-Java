package ney.opendevup.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Flash")
public class Flash extends Materiel{

	public Flash() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flash(String reference, String marque, String description) {
		super(reference, marque, description);
		// TODO Auto-generated constructor stub
	}

	public Flash(String reference) {
		super(reference);
		// TODO Auto-generated constructor stub
	}
	

}
