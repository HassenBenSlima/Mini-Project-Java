import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.BDDMockito.given;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ord.syscomputer.Factory.CategorieFactory;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.Service.CategorieService;
import ord.syscomputer.dao.CategorieRepository;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDto;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;

public class CategorieServiceTest {

	@Mock
	private ProduitRepository produitRepository;
	@Mock
	private CategorieRepository categorieRepository;
	@Mock
	private CategorieService categorieService;
	@Mock
	private ProduitFactory produitFactory;
	
	private Produit produit;
	private Produit produit2;
	private Categorie categorie;
	
	   @Rule
	    public ExpectedException thrown = ExpectedException.none();

	   @Before
	    public void setup(){
    MockitoAnnotations.initMocks(this);
    this.categorieService = new  CategorieService
    		(categorieRepository,produitRepository);
    
    
    categorie=new Categorie();
    categorie.setIdCategorie(1L); 
    categorie.setNomCategorie("Test");
    List<Produit>prods=new ArrayList<>();

    produit= new Produit();
    produit.setId(1L);
    produit.setDesignation("code Saisie");
    produit.setPrix(new BigDecimal(20));
    produit.setQuantite(200);
    
    produit2= new Produit();
    produit2.setId(2L);
    produit2.setDesignation("code Saisie");
    produit2.setPrix(new BigDecimal(10));
    produit2.setQuantite(200);
	prods.add(produit);
	prods.add(produit2);
    categorie.setProduits(prods);
	   }

	@Test
	public void calculeAVGShouldReturnAVG() {
		
		given(this.categorieRepository.findOne(anyLong())).willReturn(this.categorie);
	       
	  assertThat(this.categorieService.calculeAvgPrice(1L)).
			  isEqualTo(BigDecimal.valueOf(15));
	}


}
