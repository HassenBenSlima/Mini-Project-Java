package ord.syscomputer.Service;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Produit;
import ord.syscomputer.util.RestPreconditions;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProduitService {
        
     private final ProduitRepository produitRepository;
     private static final String ENTITY_NAME= "produit";
  

    public ProduitService ( ProduitRepository produitRepository)
    {
    	this.produitRepository= produitRepository;
    }
    
    @Transactional(readOnly = true)
    public List<ProduitDTO> findAll()
    {
       List<Produit> produits = produitRepository.findAll();
       List <ProduitDTO> produitDtos = ProduitFactory.produitsToproduitsDtos(produits);
       return produitDtos;
    }

    public ProduitDTO save(ProduitDTO produitDto) {
    	//System.out.println(produitDto.getCategorieDto().getIdCategorie());
    	System.out.println(produitDto.getDesignation());
    	
    	Produit produit = ProduitFactory.produitDtoToProduit(produitDto);   
    	 Produit savedProduit = produitRepository.save(produit);
         ProduitDTO dto =  ProduitFactory.produitToProduitDto(savedProduit);
         return dto;
      }

    	 public ProduitDTO update(ProduitDTO produitDto) {
          Produit produit = produitRepository.findOne(produitDto.getIdDTO());
        /*  if(produit==null)
        	  throw new MyResourceNotFoundException("Produit does not exist");
          */
   	      RestPreconditions.checkFound(produit,ENTITY_NAME+" not found");

          produit.setDesignation(produitDto.getDesignation());
          produit.setPrix(produitDto.getPrix());
          produit.setQuantite(produitDto.getQuantite());
          
          produitRepository.save(produit);
          ProduitDTO dto =  ProduitFactory.produitToProduitDto(produit);
          return dto;
          }
    
    public ProduitDTO findOne(Long id) {
    	   Produit produit = produitRepository.findOne(id);
    	   RestPreconditions.checkFound(produit,ENTITY_NAME+" not found");
           ProduitDTO dto = ProduitFactory.produitToProduitDto(produit);
           return dto;
    }
    
    public void delete(Long id) {
        produitRepository.delete(id);
    }    
    
}
