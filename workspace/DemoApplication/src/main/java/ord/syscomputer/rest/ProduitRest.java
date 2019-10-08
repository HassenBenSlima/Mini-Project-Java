package ord.syscomputer.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.net.URI;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ord.syscomputer.Service.ProduitService;
import ord.syscomputer.dto.ProduitDto;

@RestController
@RequestMapping("/api/produits")
public class ProduitRest {
	
	private final ProduitService produitService;
    private static final String ENTITY_NAME= "produit";

    
    
	public ProduitRest(ProduitService produitService) {
		super();
		this.produitService = produitService;
	}

	@GetMapping
	public List<ProduitDto> listProduits(){
		List<ProduitDto> produit=produitService.findAll();
		return produit;
	}
	
	@GetMapping(value="/{id}")
	public ProduitDto findOne(@PathVariable Long id){
		return produitService.findOne(id);
	}
	
	@PostMapping
	public  ResponseEntity<ProduitDto> saveProduit(@Valid @RequestBody ProduitDto p,BindingResult bindingResult)
			throws URISyntaxException, MethodArgumentNotValidException
	{ 
		 if (bindingResult.hasErrors()) {
	            throw new MethodArgumentNotValidException(null, bindingResult);
	        }
		System.out.println(p.getId());
		if(p.getId()!=null){
			bindingResult.addError(new FieldError("ProduitDto","ID Produit","Post does not allow a Produit with a ID"));
			throw new MethodArgumentNotValidException(null, bindingResult);
		}
		
		ProduitDto result= produitService.save(p);
		
		return ResponseEntity.created(new URI("/api/produits/" + result.getId())).body(result); 
	}
	
	@PutMapping
	public ResponseEntity<ProduitDto> update(@Valid @RequestBody ProduitDto p,BindingResult bindingResult) throws MethodArgumentNotValidException//requestBody pour affciher les données sous format JSON
	{	  if (bindingResult.hasErrors()) {
        throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (p.getId() == null) {
        bindingResult.addError(new FieldError("ProduitDTO", "ID", "PUT method does not accepte " + ENTITY_NAME + " with code"));
        throw new MethodArgumentNotValidException(null, bindingResult);
    }
		ProduitDto result=produitService.update(p);
	 return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteProd(@PathVariable Long id){
		produitService.delete(id);
        return ResponseEntity.ok().build();
	}
/*	
	@GetMapping(value="/chercher")
	public Page<Produit> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="4")int size)
	{	
		return produitMetier.chercher(mc,page,size);
	}
	
	@GetMapping(value="/categories/{idCat}")
	public List<Produit> getProduitByCat(@PathVariable Long idCat){
		return produitMetier.getProduitByCat(idCat);
	}*/
	
}
