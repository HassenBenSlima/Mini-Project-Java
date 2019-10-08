package ord.syscomputer.Factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ord.syscomputer.dto.ProduitDto;
import ord.syscomputer.entities.Produit;

public class ProduitFactory {
	
	public static Produit produitDtoToProduit(ProduitDto produitDto) {
		Produit produit = new Produit();
		produit.setId(produitDto.getId());
		produit.setDesignation(produitDto.getDesignation());
		produit.setPrix(produitDto.getPrix());
		produit.setQuantite(produitDto.getQuantite());	
		return produit;
	}
	
	public static ProduitDto produitToProduitDto(Produit produit) {
		if (produit != null) {
			ProduitDto dto = new ProduitDto();
			dto.setId(produit.getId());
			dto.setDesignation(produit.getDesignation());
			dto.setPrix(produit.getPrix());
			dto.setQuantite(produit.getQuantite());
			dto.setCategorieDto(produit.getCategorie().getNomCategorie());
			return dto;
		} else {
			return null;
		}

	}

	

	public static List<ProduitDto> produitsToproduitsDtos(Collection<Produit> prods) {
		List<ProduitDto> produitDto = new ArrayList<>();
		prods.forEach(x -> {
			produitDto.add(produitToProduitDto(x));
		});
		return produitDto;
	}

	public static List<Produit> produitDtosToProduit(Collection<ProduitDto> prodsDto) {
		List<Produit> produit = new ArrayList<>();
		prodsDto.forEach(x -> {
			produit.add(produitDtoToProduit(x));
		});
		return produit;
	}

}
