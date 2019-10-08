package ord.syscomputer.Factory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Produit;

public class ProduitFactory {
	
	public static ProduitDTO produitToProduitDto (Produit produit){
    
    ProduitDTO dto = new ProduitDTO();
    dto.setIdDTO(produit.getId());
    dto.setDesignation(produit.getDesignation());
    dto.setPrix(produit.getPrix());
    dto.setQuantite(produit.getQuantite());
    // dto.setCategorieDto(CategorieFactory.categorieToCategorieDto(produit.getCategorie()));
    return dto;
  	}
	
	  public static Produit produitDtoToProduit (ProduitDTO produitDto) {
	  Produit produit = new Produit();
	  produit.setId(produitDto.getIdDTO());
	  produit.setDesignation(produitDto.getDesignation());
	  produit.setPrix(produitDto.getPrix());
	  produit.setQuantite(produitDto.getQuantite());
	  //  produit.setCategorie(CategorieFactory.categorieDtoToCategorie(produitDto.getCategorieDto()));
      return produit;
	  }	
  
    public static List<ProduitDTO> produitsToproduitsDtos(Collection<Produit> prods) {
      List<ProduitDTO> produitDto = new ArrayList<>();
      prods.forEach(x -> {
          produitDto.add(produitToProduitDto(x));
      });
      return produitDto;
   }

    public static Iterable<ProduitDTO> produitsToproduitsDtosIterable(Iterable<Produit> prods) {
      List<ProduitDTO> produitDto = new ArrayList<>();
      prods.forEach(x -> {
          produitDto.add(produitToProduitDto(x));
      });
      return produitDto;
   }
  
   
   public static List<Produit> produitDtosToProduit(Collection<ProduitDTO> prodsDto) {
      List<Produit> produit = new ArrayList<>();
      prodsDto.forEach(x -> {
    	  produit.add(produitDtoToProduit(x));
      });
      return produit;
   }
  
}
