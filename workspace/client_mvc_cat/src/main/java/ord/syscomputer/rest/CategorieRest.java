package ord.syscomputer.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

import ord.syscomputer.Service.CategorieService;
import ord.syscomputer.Service.ProduitService;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Categorie;


@RestController
@RequestMapping("/api/categories")
public class CategorieRest {

    private final CategorieService categorieService;
    private final ProduitService produitService;
    
	

	public CategorieRest(CategorieService categorieService, ProduitService produitService) {
		super();
		this.categorieService = categorieService;
		this.produitService = produitService;
	}

	@GetMapping
	public List<CategorieDto> listCategories() {
		List<CategorieDto> categories=categorieService.findAll();
		return categories;
	}
	@GetMapping("/{id}")
	public CategorieDto findById(@PathVariable Long id) {
		CategorieDto categories=categorieService.findOne(id);
		return categories;
	}
//after all things
	@PostMapping
	public ResponseEntity<CategorieDto> createCategories(@RequestBody CategorieDto cat) throws URISyntaxException{
			 
		 CategorieDto result=categorieService.save(cat);
		
		 return ResponseEntity.created(new URI("/api/categories"+
		result.getIdCategorie())).body(result);		
	}
	
	@DeleteMapping("/{idCat}")
	public ResponseEntity<Void> deleteCat(@PathVariable Long idCat){
		categorieService.delete(idCat);
        return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<CategorieDto> updateCategorie(@RequestBody CategorieDto cat){
		 CategorieDto result=categorieService.update(cat);
		 return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/{idCat}/produits")
	public List<ProduitDTO> getProduitsByCat(@PathVariable Long idCat){
		List<ProduitDTO> prodsCat=categorieService.getProduitsByCat(idCat);
		return prodsCat;
	}
	
}
