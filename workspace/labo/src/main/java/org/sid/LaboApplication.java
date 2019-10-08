package org.sid;

import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;

import org.sid.dao.ArticleRepository;
import org.sid.dao.LaboratoireRepository;
import org.sid.dao.ProduitRepository;
import org.sid.dao.UniterRechercherRepository;
import org.sid.entities.Article;
import org.sid.entities.Laboratoire;
import org.sid.entities.Produit;
import org.sid.entities.UniteRecherche;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class LaboApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=	SpringApplication.run(LaboApplication.class, args);
	
	ProduitRepository dao=ctx.getBean(ProduitRepository.class);
	
	
	/*dao.save(new Produit("LX654",78600));
	dao.save(new Produit("HLX",54300));
	dao.save(new Produit("ALX",1200));
	dao.save(new Produit("HP870",3400));*/
	System.out.println("------------------------");
	System.out.println("Liste de tous les produits:");
	    
	List<Produit> prods =dao.findAll();
	for (Produit p:prods)
	{
		System.out.println(p.getDesignation()+"--"+p.getPrix());
	}
	
	System.out.println("------------------------");
	System.out.println("Produits de la page 0:");
	
	Page<Produit> pageProduits =dao.findAll(new PageRequest(0,2));
	
	System.out.println("Page courante :"+pageProduits.getNumber());
	System.out.println("Nombre de pages :"+pageProduits.getTotalPages());
	System.out.println("Nombre de produits :"+pageProduits.getTotalElements());	
	
	System.out.println("Afficher Tous les Produits de la page 0 ");
	
	List<Produit> prods2=pageProduits.getContent();
	
	for (Produit p:prods2)
	{
		System.out.println(p.getDesignation()+"--"+p.getPrix());
	}
	System.out.println("------------------------");
	//Produit p =dao.findOne(1L);
	System.out.println("------------------------");
	System.out.println("Chercher des produits:");
	Page<Produit>prods3=dao.chercherProduits("%L%", new PageRequest(0, 2));
	
	for (Produit p:prods3.getContent())
	{
		System.out.println(p.getDesignation()+"--"+p.getPrix());
	}
	
	
	/*
	LaboratoireRepository dao1=ctx.getBean(LaboratoireRepository.class);
	dao1.save(new Laboratoire("HH","AA","BB",20014411L));

	UniterRechercherRepository dao2 = ctx.getBean(UniterRechercherRepository.class);
	dao2.save(new UniteRecherche(20L, "Route_mahdia", "uniter1",20014411L));*/
	
	
	ArticleRepository dao3=ctx.getBean(ArticleRepository.class);
	
	System.out.println("------------------------");
	System.out.println("Produits de la page 0:");
	
	Page<Article> pageArt =dao3.findAll(new PageRequest(0,2));
	
	System.out.println("Page courante :"+pageArt.getNumber());
	System.out.println("Nombre de pages :"+pageArt.getTotalPages());
	System.out.println("Nombre de produits :"+pageArt.getTotalElements());	
	
	System.out.println("Afficher Tous les Produits de la page 0 ");
	
	List<Article> art2=pageArt.getContent();
	
	for (Article a:art2)
	{
		System.out.println(a.getCodeArt()+"--"+a.getTitre());
	}
	System.out.println("------------------------");
	
	
	}
}
 