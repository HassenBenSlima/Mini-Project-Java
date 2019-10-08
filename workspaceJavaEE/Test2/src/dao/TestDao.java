package dao;

import java.util.List;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {

		ProduitDaoImpl dao = new ProduitDaoImpl();
//		Produit p1 = dao.save(new Produit("HP 6580", 900, 45));
//		Produit p2 = dao.save(new Produit("Imprimant Epson", 1000, 15));
//		System.out.println(p1.toString());
//		System.out.println(p2.toString());

		System.out.println("Chercher des produits");
		List<Produit> prods = dao.produitsParMC("%H%");
		for (Produit p : prods) {
			System.out.println(p.toString());
		}

		System.out.println("---------------------");
		Produit p = dao.findById(1L);
		System.out.println(p.toString());
		p.setPrix(1000);
		dao.update(p);

//		Produit p3 = dao.findById(3L);
//		System.out.println(p3.toString());
//		dao.deleteProduit(3L);
	}

}
