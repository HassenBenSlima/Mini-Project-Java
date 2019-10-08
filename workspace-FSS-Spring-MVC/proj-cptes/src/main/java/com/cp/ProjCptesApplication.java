package com.cp;

import java.util.Date;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_2.perty.recipe.formatErrors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import com.cp.entities.Client;
import com.cp.entities.Compte;
import com.cp.entities.CompteCourant;
import com.cp.entities.CompteEpargne;
import com.cp.entities.Operation;
import com.cp.metier.ClientMetier;
import com.cp.metier.CompteMetier;
import com.cp.metier.OperationMetier;

@SpringBootApplication
public class ProjCptesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(ProjCptesApplication.class, args);
	
	ClientMetier clientMetier =ctx.getBean(ClientMetier.class);
	
	clientMetier.addClient(new Client("A"));
	clientMetier.addClient(new Client("B"));
	clientMetier.addClient(new Client("BA"));
	
	System.out.println("---------------------");
	List<Client> clients =clientMetier.listClient();
	clients.forEach(c->System.out.println(c.getNom()));
	
	/*
	for(Client c: clients){
		
		System.out.println(c.getNom());
	}
	*/
	System.out.println("---------------------");
	List<Client> clts=clientMetier.clientparMC("%A%");
	
	clts.forEach(c->System.out.println(c.getNom()));

	System.out.println("---------Comptes------------");
	
	CompteMetier compteMetier =ctx.getBean(CompteMetier.class);
	
	compteMetier.addCompte(
			new CompteCourant("CC1",new Date(), 9000, new Client(1L) , 8000));
	
	compteMetier.addCompte(
			new CompteCourant("CC2",new Date(), 9000, new Client(2L) , 8000));
	
	compteMetier.addCompte(
			new CompteEpargne("CE1",new Date(), 9000, new Client(1L) , 5.5));
	
	Compte cp =compteMetier.consulterCompte("CC1");
	
	System.out.println("Solde= "+cp.getSolde());
	System.out.println("Date= "+cp.getDateCreation());

	System.out.println("---------Opérataions------------");
    
	OperationMetier operationMetier =ctx.getBean(OperationMetier.class);
	
/*	operationMetier.verser("CC1", 9000);
	operationMetier.retirer("CC1", 6000);
	operationMetier.verser("CC1", 200000);
	operationMetier.retirer("CC1", 6000);
	operationMetier.verser("CC1", 23000);
	operationMetier.retirer("CC1", 8000);
	operationMetier.virement("CC1", "CE1", 7000);
	
	Page<Operation>ops= operationMetier.listOperation("CC1", 0, 3);
	
	//getContent si vous voulez les listes des operations
	for(Operation o:ops.getContent()){
		
		System.out.println(o.getNumeroOperation());
		System.out.println(o.getMontant());
		System.out.println(o.getDateOperation());
		
	}
	*/
	
	
	
	
	
	}
	

	
	
}
