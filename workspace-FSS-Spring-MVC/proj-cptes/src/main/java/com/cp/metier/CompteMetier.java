package com.cp.metier;

import com.cp.entities.Compte;

public interface CompteMetier {

	public Compte addCompte(Compte cp);
	public Compte consulterCompte(String codeCpte);
}
