package com.fss.ml;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fss.ml.entities.BonAchat;
import com.fss.ml.entities.Caisse;
import com.fss.ml.entities.Citerne;
import com.fss.ml.entities.Client;
import com.fss.ml.entities.CuveOlives;
import com.fss.ml.entities.Employe;
import com.fss.ml.entities.Facture;
import com.fss.ml.entities.Fournisseur;
import com.fss.ml.entities.FournisseurMaintenance;
import com.fss.ml.entities.FournisseurOlive;
import com.fss.ml.entities.Maintenance;
import com.fss.ml.entities.Reservation;
import com.fss.ml.entities.Stock;
import com.fss.ml.metier.MoulinOliveMetier;

public class TestJPA {

	@Test
	public void test() {
	
			try {
				ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
						
		        MoulinOliveMetier metier=
		      (MoulinOliveMetier) context.getBean("metier");
//				List<Client> c=metier.listClient();
//    metier.ajouterClient(new Client(1L, "hassen","ben slima", "sakia", 20014411L));
//			    metier.ajouterClient(new Client(4L, "atef","boujelben", "sakia", 20014411L));
//			    List<Client> c2=metier.listClient();
//				assertTrue(c.size()+2==c2.size());
//		
//				List<Employe> empl1=metier.listEmploye();
//				metier.ajouterEmploye(new Employe(861L, "Mohamed", "Ben Slima",200L, "sakia", "mo9awel", "8->12"));
//				metier.ajouterEmploye(new Employe(821L, "Amina", "Ben Slima",2001L, "sakia", "dorctora", "8->12"));
//				List<Employe> empl2=metier.listEmploye();
//			
//				assertTrue(empl1.size()+2==empl2.size());
//		        
//				List<Fournisseur> frn1=metier.listFournisseur();
//				metier.ajouterFournisseur(new FournisseurOlive(55L, "mohamed","ZEDZE",222L, "cerc"));
//				metier.ajouterFournisseur(new FournisseurMaintenance(20L, "amina","ZEDZE",222L, "cerc"));
//				List<Fournisseur> frn2=metier.listFournisseur();
				

//   			assertTrue(frn1.size()+2==frn2.size());
//		    
//  			metier.ajouterReservation(new Reservation(12, new Date(), "bien"), 1L);
//              metier.ajouterCaisse(new Caisse(600000));
                
//                List<Citerne> ctr1=metier.listCiterne();
//               metier.ajouterStock(new Citerne("ref01", 222222, 100, 10000, "extra"));
//                metier.ajouterStock(new Citerne("ref02", 222222, 1020, 10000, "extra"));
//               List<Citerne> ctr2=metier.listCiterne();
//      			assertTrue(ctr1.size()+2==ctr2.size());
			
//		        List<CuveOlives> cv1=metier.listCuve();
       //       metier.ajouterStock(new CuveOlives("stock11",5221455,400));
//              metier.ajouterStock(new CuveOlives("stock22",5221455,400));
//                 List<CuveOlives> cv2=metier.listCuve();
//					assertTrue(cv1.size()+2==cv2.size());
		        
//		 metier.ajouterCaisse(new Caisse(6000000));
		  // metier.RetirerMoney(1L, 600000);
		        //metier.supprimerStock("ref11");
		        
	//	 metier.ajouterBA(new BonAchat(new Date(), 33,"SUPER",6,"sfax","xssqx"),1L, 55L, "stock11");
		//metier.ajouterBA(new BonAchat(new Date(), 100, "bien", 100, "sfax", "good"), 1L, 55L);        
		       // metier.ajouterMaintenance(new Maintenance("main", "20/04/2016", 7 ), 20L, 1L);
		        
		        //List<Stock> ctrns= new ArrayList<Stock>();
		        //ctrns.add(new Citerne("ref01", 222, 100, 10000L, "extra"));
	     //  metier.ajouterFacture(new Facture("espaisses", new Date(),5, 242,"ccc"), 1L, 1L);
				
		    //   metier.AjouterOlive("stock11", 415);
		       // metier.RetirerOlive("stock11", 15);
		      //metier.viderCuve("stock11");
		        
		         //metier.AjouteHuile("ref01", 100);
		        //metier.RetirerHuile("ref01", 100);
		        
		      // metier.ajouterReservation(new Reservation(200,"25/01/24", "coucou") , 1L);
			} catch (Exception e) {
				assertTrue(e.getMessage(),false);
				}
	}
	
}
