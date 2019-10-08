package net.sid.eboutique.dao;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.entities.Client;
import net.sid.eboutique.entities.Commande;
import net.sid.eboutique.entities.LigneCommande;
import net.sid.eboutique.entities.Panier;
import net.sid.eboutique.entities.Produit;
import net.sid.eboutique.entities.Role;
import net.sid.eboutique.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO{
    
	@PersistenceContext//pour faire l'injection
	private EntityManager em;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);//pour ajouter une categorie
		return c.getIdcategorie()  ;
	}

	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
	// letype d'object que vous allez charger appartient a Categorie.class 
		return em.find(Categorie.class, idCat);
	}
	@Override
	public void supprimerCategrorie(Long idcat) {
	
		Categorie c =em.find(Categorie.class, idcat);
		em.remove(c);// on suppose que le categorie exist
	}

	@Override
	public void modifierCategorie(Categorie c) {
	em.merge(c);	
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat ) {
		Categorie c=getCategorie(idCat);// on va associer la categorie 
		p.setCategorie(c);//puis on va l'associer au produit 
	    em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listproduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produit p where p.designation like :x or p.description like :x");
		req.setParameter("x","%"+mc+"%");//remplacer x par ca valeur
		return req.getResultList();
	}
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Produit p where p.categirie.idcategorie=:x");
		req.setParameter("x",idCat);//remplacer x par ca valeur
		return req.getResultList();
	}

	@Override
	
	public List<Produit> produitsSelectionnes() {
		Query req=em.createQuery("select p from Produit p where p.selected=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
	
	return em.find(Produit.class,idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		Produit p=getProduit(idP);
		em.remove(p);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		
		em.merge(p);
		//editer affciher dans un formulaire les données(edite c'est 'get')
		//update faire la mise a jours
	}

	@Override
	public void ajouterUser(User u) {  
	
	em.persist(u);	
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		User u =em.find(User.class,userID);
		//on n'a pas une association bidirectionnel
	   //pour faire associter il faut faire
		u.getRoles().add(r);
		em.persist(r); 
		
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// enregister le commande Consiste a enregister le Client

	em.persist(c);
	Commande cmd=new Commande ();
	cmd.setDateCommande(new Date());
	
	cmd.setItems(p.getItems());
	
	
	
	for(LigneCommande lc: p.getItems()){
		em.persist(lc);
	}
	em.persist(cmd);
	return cmd;
	
	}

}