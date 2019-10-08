package net.sid.eboutique.metier;

import net.sid.eboutique.entities.Categorie;
import net.sid.eboutique.entities.Role;
import net.sid.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {
		public Long ajouterCategorie(Categorie c);
		public void supprimerCategrorie(Long idcat);
		public void modifierCategorie(Categorie c);
		public void ajouterUser(User u);
		public void attribuerRole(Role r,Long userID);
}
