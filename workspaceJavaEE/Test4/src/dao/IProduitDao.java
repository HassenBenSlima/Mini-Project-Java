package dao;

import java.util.List;
import metier.entities.Produit;

public interface IProduitDao {

	Produit save(Produit p);

	List<Produit> produitsParMC(String mc);

	Produit getProduit(Long id);

	Produit update(Produit p);

	void deleteProduit(Long id);

	Produit findById(Long id);
}
