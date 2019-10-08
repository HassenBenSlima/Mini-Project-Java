package ord.syscomputer.Factory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.entities.Categorie;

public class CategorieFactory {

	public static CategorieDto  categorieToCategorieDto (Categorie categorie){
	        CategorieDto dto = new CategorieDto();
	        dto.setIdCategorie(categorie.getIdCategorie());
	        dto.setNomCategorie(categorie.getNomCategorie());
	        if(categorie.getProduits()!=null){
	            dto.setListProduitsDto((List)ProduitFactory.produitsToproduitsDtos
	                   (categorie.getProduits()));   
	            }
	        return dto;
	    }
	
	public static Categorie categorieDtoToCategorie (CategorieDto categorieDto) {
		
		Categorie categorie = new Categorie();
		
		categorie.setIdCategorie(categorieDto.getIdCategorie());
		categorie.setNomCategorie(categorieDto.getNomCategorie());
	   
		/* 
		Collection<Produit> produits=new ArrayList<>();
		
		for(ProduitDto p : categorieDto.getListProduitsDto()){
			System.out.println("HASSEN Produit");
			Produit produit=new Produit();
			produit.setCategorie(categorie);
			produit.setDesignation(p.getDesignation());
			produit.setPrix(0);
			produit.setQuantite(0);
			produits.add(produit);
		}
		categorie.setProduits(produits);*/
    
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