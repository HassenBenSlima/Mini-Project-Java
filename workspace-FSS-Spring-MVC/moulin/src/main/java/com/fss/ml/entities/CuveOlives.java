package com.fss.ml.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("OLIVE")
public class CuveOlives extends Stock{

	
	private double quantiteactOL;

	
	public double getQuantiteactOL() {
		return quantiteactOL;
	}
	
	public void setQuantiteactOL(double quantiteactOL) {
		this.quantiteactOL = quantiteactOL;
	}

	

	public CuveOlives(String codeStock, double capacite, double quantiteactOL) {
		super(codeStock, capacite);
		this.quantiteactOL = quantiteactOL;
	}

	public CuveOlives() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
