package metier;

import java.sql.Connection;
import java.util.List;

public class Test  {

		public static void main(String []args){
		MetierCatalogueImpl metier= new MetierCatalogueImpl();
		//metier.addCategorie(new Categorie("Ordinateurs"));
		//metier.addCategorie(new Categorie("Imprimentes"));
		//metier.addCategorie(new Categorie("CD"));
		
//		metier.addProduit(new Produit("P1", "HP", 4000, 33), 1);
//		metier.addProduit(new Produit("P2", "HP 89", 6500, 33), 1);
//		metier.addProduit(new Produit("P3", "HP IMP", 4000, 33), 2);
//		metier.addProduit(new Produit("P4", "HP AZE", 4000, 33), 2);
//		metier.addProduit(new Produit("P5", "HP ERT", 4000, 33), 3);
		
		List<Categorie>cats= metier.getAllCategories();
		
		for(Categorie c:cats){
			System.out.println(c.getNomCat());
		}
		System.out.println("-------------------");
		List<Produit> prods= metier.getProduitParCat(1);
		for(Produit p:prods){
			System.out.println(p.getNomProduit());
		}
		System.out.println("-------------------");
		prods= metier.getProduitParMC("H");
		for(Produit p:prods){
			System.out.print(p.getNomProduit());
			System.out.println(" | "+p.getCategorie().getNomCat());
		}
		 
		
		
		}
}
