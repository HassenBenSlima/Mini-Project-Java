package org.isie;

import java.util.Date;

import org.isie.dao.EntrepriseRepository;
import org.isie.dao.TaxeReposirotory;
import org.isie.entities.Entreprise;
import org.isie.entities.IR;
import org.isie.entities.TVA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner{
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private TaxeReposirotory taxeReposirotory;
	public static void main(String[] args) {
		SpringApplication.run(TaxesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	Entreprise e1= entrepriseRepository.save(
		new Entreprise("R1", "r1@gmail.com", "SARL"));

	Entreprise e2= entrepriseRepository.save(
		new Entreprise("R2", "r2@gmail.com", "SARL"));
		
		
	taxeReposirotory.save(new TVA("TVA Habitation",new Date(),900,e1));
	taxeReposirotory.save(new TVA("TVA Voiture",new Date(),400,e1));
	taxeReposirotory.save(new IR("IR 2016",new Date(),4500,e1));
	taxeReposirotory.save(new TVA("TVA Habitation",new Date(),400,e2));
		
		
	}
}
