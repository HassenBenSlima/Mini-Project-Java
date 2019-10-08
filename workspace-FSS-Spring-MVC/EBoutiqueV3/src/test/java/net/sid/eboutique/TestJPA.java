package net.sid.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.Context;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.entities.Produit;
import net.sid.eboutique.metier.IAdminCategoriesMetier;

public class TestJPA {
	ClassPathXmlApplicationContext context;
		
	@Before
	public void setUp() throws Exception{
	 
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
				
	}
	
	@Test
	public void test1() {
//		try {
//			ClassPathXmlApplicationContext app=
//			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
//			assertTrue(true);
//			} catch (Exception e) {
//			assertTrue(e.getMessage(),false);
//			}
//test pour categories
        try {
			
        	IAdminCategoriesMetier metier =
					(IAdminCategoriesMetier) context.getBean("metier");
			
			List<Categorie> cts1=metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs","Ordnmmmmmm",null, "image.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimantes","imprrrrrrr",null, "image.jpg"));
			List<Categorie> cts2=metier.listCategories();
			
			assertTrue(cts1.size()+2==cts2.size());
	        } catch (Exception e) {

		assertTrue(e.getMessage(),false);
			}
		
	}
//test pour produit
	
	@Test
	public void test2() {

        try {
			IAdminCategoriesMetier metier =
					(IAdminCategoriesMetier) context.getBean("metier");
			
			List<Produit> prods=metier.listproduits();
			metier.ajouterProduit(new Produit("HP45ERT", "HP7890", 6000, true, "image1.jpg", 50), 1L);
			metier.ajouterProduit(new Produit("AZERTY", "HP7890", 6000, true, "image1.jpg", 50), 1L);
			List<Produit> prods2=metier.listproduits();
		
			assertTrue(prods.size()+2==prods2.size());
	        } catch (Exception e) {
	assertTrue(e.getMessage(),false);
			}
	}
}
