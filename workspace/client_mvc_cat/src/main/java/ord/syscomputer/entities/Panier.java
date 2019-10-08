package ord.syscomputer.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {

	// on peut avec map de trouver les produit avec la reference de
	// produit(idProduit de type Long)
	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();

	// une methode qui permet d'ajouter un produit
	public void addAtrticle(Produit p, int quantite) {
		if (items.get(p.getId()) == null) {
			LigneCommande lc = new LigneCommande();
			lc.setProduit(p);
			lc.setQuantite(quantite);
			lc.setPrix(p.getPrix());
		} else {
			LigneCommande lc = items.get(p.getId());
			lc.setQuantite(lc.getQuantite() + quantite);

		}
	}

	public Collection<LigneCommande> getItems() {
		return items.values();
	}

	public double getTotale() {
		double total = 0;
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}

	public int getSize() {
		return items.size();
	}

	public void deleteItem(Long idProduit) {
		items.remove(idProduit);
	}

}
