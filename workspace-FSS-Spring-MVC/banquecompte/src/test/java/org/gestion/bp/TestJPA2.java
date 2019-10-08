package org.gestion.bp;

import static org.junit.Assert.*;

import java.util.Collection;
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

public class TestJPA2 {

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
	
			
			 
			 
			List<Operation> ops =metier.consulterOperation("CC1",0,5);
			
			//pour chaque operation op de la list ops on a :
			for(Operation op :ops){
				System.out.println("**********");
				System.out.println(op.getNumeroOperation());
				System.out.println(op.getDateOperation());
				System.out.println(op.getMontant());
				System.out.println(op.getClass().getSimpleName());//affciher le nom de la class de l'operation
			}
			
			
			
			/****Consulter employes par groupe***/
//			List<Employe> empL=metier.getEmployesByGroupe(2L);
//			
//			for(Employe ep: empL){
//				System.out.println("**********");
//				System.out.println(ep.getCodeEmploye());				
//				System.out.println(ep.getNomEmploye());
//			    System.out.println(ep.getEmployeSup().getNomEmploye());
//				
//			}
			/********/
			
			/*
			List<Employe> e =metier.getEmployes();
            List<Groupe>g=metier.getGroupes();			
			
            for(int i=0;i<g.size();i++){
            	Groupe gg=metier.consulterGroupe(g.get(i).getCodeGroupe());
            	System.out.println("****GG*****");
            	System.out.println(gg.getCodeGroupe());
            	System.out.println(gg.getNomGroupe());				
				
            	Employe ee=metier.consulterEmploye(e.get(i).getCodeEmploye());
            	System.out.println("*****EE*****");
            	System.out.println(ee.getCodeEmploye());				
            	System.out.println(ee.getNomEmploye());
            	//ee.getGroupes().iterator().toString();
            	
            //	Collection<Groupe>G=e.get(i).getGroupes();
            }
            */
            	
            
            
            
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
			
	}

}
