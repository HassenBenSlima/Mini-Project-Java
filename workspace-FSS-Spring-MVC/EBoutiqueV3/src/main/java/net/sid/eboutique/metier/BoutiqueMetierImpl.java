package net.sid.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.sid.eboutique.dao.IBoutiqueDAO;
import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.entities.Client;
import net.sid.eboutique.entities.Commande;
import net.sid.eboutique.entities.Panier;
import net.sid.eboutique.entities.Produit;
import net.sid.eboutique.entities.Role;
import net.sid.eboutique.entities.User;

@Transactional //si on ajouter , on suppose que tous les methode sont transactionnelle
public class BoutiqueMetierImpl implements IAdminCategoriesMetier{
//lie avec l'interface IBoutiqueDao
	
	private IBoutiqueDAO dao;
	
	
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
		
	}

	@Override
	public void modifierProduit(Produit p) {
       dao.modifierProduit(p);		
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		// TODO Auto-generated method stub
		dao.supprimerCategrorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, userID);
	}

}
