package com.cp.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.dao.CompteRepository;
import com.cp.entities.Compte;

@Service
public class CompteMetierImpl implements CompteMetier{

	//pour gerer les compte on a besion de fait apellet a la couche Dao
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public Compte addCompte(Compte cp) {
		// TODO Auto-generated method stub
		return compteRepository.save(cp);
	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		
		Compte cp = compteRepository.findOne(codeCpte);
		if (cp==null)throw new RuntimeException("Compte innexistant");
				return cp;
	}

}
