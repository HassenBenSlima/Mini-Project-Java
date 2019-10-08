package com.fss.ml.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FRNO")
public class FournisseurOlive extends Fournisseur {

	public FournisseurOlive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurOlive(Long cinFourn, String nomFourn, String prenomFourn, Long telFourn, String adrFourn) {
		super(cinFourn, nomFourn, prenomFourn, telFourn, adrFourn);
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}
