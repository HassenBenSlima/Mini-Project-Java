package com.fss.ml.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FRNM")
public class FournisseurMaintenance extends Fournisseur{

	public FournisseurMaintenance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurMaintenance(Long cinFourn, String nomFourn, String prenomFourn, Long telFourn, String adrFourn) {
		super(cinFourn, nomFourn, prenomFourn, telFourn, adrFourn);
		// TODO Auto-generated constructor stub
	}

	

}
