package ord.syscomputer.Factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDto;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;

public class CategorieFactory {

	/**
	 * @param categorie
	 * @return
	 */
	public static CategorieDto categorieToCategorieDto(Categorie categorie) {
		if (categorie != null) {
			CategorieDto dto = new CategorieDto();
			dto.setIdCategorie(categorie.getIdCategorie());
			dto.setNomCategorie(categorie.getNomCategorie());
			return dto;
		} else {
			return null;
		}
	}

	public static Categorie categorieDtoToCategorie(CategorieDto categorieDto) {
		Categorie categorie = new Categorie();
		categorie.setIdCategorie(categorieDto.getIdCategorie());
		categorie.setNomCategorie(categorieDto.getNomCategorie());
		List<Produit> produits = new ArrayList<>();

		for (ProduitDto produitDto : categorieDto.getListProduitsDto()) {
			Produit produit = ProduitFactory.produitDtoToProduit(produitDto);
			produit.setCategorie(categorie);
			produits.add(produit);
		}
		categorie.setProduits(produits);
		return categorie;
	}

	public static List<CategorieDto> categorieToCategorieDtos(Collection<Categorie> cats) {
		List<CategorieDto> categorieDto = new ArrayList<>();
		cats.forEach(x -> {
			categorieDto.add(categorieToCategorieDto(x));
		});
		return categorieDto;
	}
}