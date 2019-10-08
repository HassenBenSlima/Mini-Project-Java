package org.gestion.bp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.gestion.bp.entities.Client;
import org.gestion.bp.entities.Compte;
import org.gestion.bp.entities.CompteCourant;
import org.gestion.bp.entities.CompteEpargne;
import org.gestion.bp.entities.Employe;
import org.gestion.bp.entities.Groupe;
import org.gestion.bp.entities.Operation;
import org.gestion.bp.metier.IBanqueMetier;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Test
	public void test1() {
		try {
			ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			
			IBanqueMetier metier =
					(IBanqueMetier)context.getBean("metier");//bean qui se trouve dans le fichier applicationContext
			
			
//			metier.addClient(new Client("C1","AD1"));
//			metier.addClient(new Client("C2","AD2"));
//			metier.addEmploye(new Employe("E1"), null);
//			metier.addEmploye(new Employe("E2"), 1L);
//			metier.addEmploye(new Employe("E3"), 1L);
//			metier.addGroupe(new Groupe("G1"));			
//			metier.addGroupe(new Groupe("G2"));
//			metier.addEmployeToGroupe(1L, 1L);
//			metier.addEmployeToGroupe(2L, 2L);
//			metier.addEmployeToGroupe(3L, 2L);
//			
//			metier.addCompte(new CompteCourant("CC1", new Date(), 9000,8000), 1L, 2L);
//			metier.addCompte(new CompteEpargne("CE1", new Date(), 40000,5.5), 2L, 2L);

			
			
			
			/*metier.verser(5000, "CC1", 2L);
			metier.retirer(6000, "CC1", 2L);
			
			metier.virement(4000,"CC1","CE1", 1L);
			*/
			
			
			/***Test de Consutlation***/
		
		/*	Compte cp=metier.consulterCompte("CC1");
			System.out.println("Solde :"+cp.getSolde());
			System.out.println("Date :"+cp.getDateCreation());
			System.out.println("Client :"+cp.getClient().getNomClient());
			System.out.println("Employé :"+cp.getEmploye().getNomEmploye());
		*/
	
			
			 
			 
			/*List<Operation> ops =metier.consulterOperation("CC1");
			
			//pour chaque operation op de la list ops on a :
			for(Operation op :ops){
				System.out.println("**********");
				System.out.println(op.getNumeroOperation());
				System.out.println(op.getDateOperation());
				System.out.println(op.getMontant());
				System.out.println(op.getClass().getSimpleName());//affciher le nom de la class de l'operation
			}
			
			*/
			
			
			
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
			
	}

}
